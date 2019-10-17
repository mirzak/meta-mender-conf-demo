FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://mender.service \
    file://artifact-verify-key.pem \
"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 644 ${WORKDIR}/mender.service ${D}${systemd_unitdir}/system/
}
