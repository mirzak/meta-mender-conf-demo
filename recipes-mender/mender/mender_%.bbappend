FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://mender.service"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 644 ${WORKDIR}/mender.service ${D}${systemd_unitdir}/system/
}
