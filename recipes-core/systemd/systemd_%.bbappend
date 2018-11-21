FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://wlan.network"

FILES_${PN} += "${sysconfdir}/systemd/network/wlan.network"

do_install_append() {
  if ${@bb.utils.contains('PACKAGECONFIG','networkd','true','false',d)}; then
        install -d ${D}${sysconfdir}/systemd/network
        install -m 0755 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
  fi
}
