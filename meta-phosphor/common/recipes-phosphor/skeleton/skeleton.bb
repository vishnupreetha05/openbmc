SUMMARY = "Temp placeholder for skeleton function"
DESCRIPTION = "Temp placeholder for skeleton repository"
HOMEPAGE = "http://github.com/openbmc/skeleton"
PR = "r1"

inherit obmc-phosphor-license
inherit obmc-phosphor-systemd

DEPENDS += "glib-2.0"
RDEPENDS_${PN} += "python-subprocess python-tftpy"
SRC_URI += "git://github.com/openbmc/skeleton"

SRCREV = "831188fedd74d86e137ec0c8e39c7395548ad480"

S = "${WORKDIR}/git"

do_compile() {
        oe_runmake all
}

do_install() {
        install -d ${D}/${sbindir} ${D}${libdir}
        for i in ${S}/bin/*.py ${S}/bin/*.exe; do
                install $i ${D}/${sbindir}
        done
        install ${S}/bin/libopenbmc_intf.so ${D}/${libdir}
}
