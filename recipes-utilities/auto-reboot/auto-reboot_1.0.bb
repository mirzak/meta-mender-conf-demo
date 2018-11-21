DESCRIPTION = "Systemd Service script to force a reboot to test automatic rollbacks by the Mender client."
HOMEPAGE = "https://mender.io"
LICENSE = "Apache-2.0"

SRC_URI = " \
	file://auto-reboot.service \
	file://LICENSE \
"
LIC_FILES_CHKSUM = "file://${S}/../LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit systemd

SYSTEMD_SERVICE_${PN} = "auto-reboot.service"
FILES_${PN} += "${systemd_unitdir}/system/auto-reboot.service"

do_install() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/auto-reboot.service ${D}/${systemd_unitdir}/system
}
