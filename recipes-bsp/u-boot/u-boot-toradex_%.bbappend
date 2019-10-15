FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://mender-logo.bmp"

SRC_URI_append_colibri-imx7-emmc = "\
    file://0001-configs-colibri_imx7_emmc-update-display-resulution.patch \
    file://0002-configs-colibri_imx7_emmc-remove-console-tty1.patch \
    file://0003-configs-colibri_imx7_emmc-set-quiet-and-disable-cons.patch \
"

do_configure_prepend() {
    cp ${WORKDIR}/mender-logo.bmp ${S}/tools/logos/toradex.bmp
}
