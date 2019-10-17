DESCRIPTION = "Sample state-scripts that will write to psplash"
HOMEPAGE = "https://mender.io"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
    file://Download_Enter_00 \
    file://ArtifactInstall_Enter_00 \
    file://ArtifactReboot_Enter_00 \
    file://mender-progressbar-mock \
"

inherit mender-state-scripts

do_install() {
    install -d ${D}/${sysconfdir}/mender/scripts/
    install -m 755 ${WORKDIR}/Download_Enter_00 ${D}/${sysconfdir}/mender/scripts/

    install -d ${D}/${bindir}
    install -m 755 ${WORKDIR}/mender-progressbar-mock ${D}/${bindir}
}

do_compile() {
    cp ${WORKDIR}/ArtifactInstall_Enter_00 ${MENDER_STATE_SCRIPTS_DIR}/
    cp ${WORKDIR}/ArtifactReboot_Enter_00 ${MENDER_STATE_SCRIPTS_DIR}/
}
