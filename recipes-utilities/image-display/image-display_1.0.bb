DESCRIPTION = "Systemd Service script to run mpv in a loop with a PNG file for demo purposes."
HOMEPAGE = "https://mender.io"
LICENSE = "Apache-2.0"

SRC_URI = "\
    file://image-display.service \
    file://demo-image-locked.png \
    file://demo-image-unlocked.png \
"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

RDEPENDS_${PN} = "fbida fbv"

inherit systemd

IMAGE_DISPLAY_IMAGE_FILE ?= "demo-image-1.png"

do_install() {
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/${PN}.service ${D}/${systemd_unitdir}/system

    install -d ${D}/data/mender/demo
    install -m 0644 ${WORKDIR}/demo-image-unlocked.png \
                  ${D}/data/mender/demo/demo-image-1.png

    install -m 0644 ${WORKDIR}/demo-image-locked.png \
                  ${D}/data/mender/demo/demo-image-2.png

    install -d ${D}/${sysconfdir}
    ln -s /data/mender/demo/${IMAGE_DISPLAY_IMAGE_FILE} \
          ${D}/${sysconfdir}/demo-image.png
}

SYSTEMD_SERVICE_${PN} = "${PN}.service"

FILES_${PN} += "/data/mender/demo ${systemd_unitdir}/system/${PN}.service"
