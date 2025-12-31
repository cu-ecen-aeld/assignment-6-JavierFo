LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/cu-ecen-aeld/assignments-3-and-later-JavierFo.git;protocol=https;branch=main"

PV = "1.0+git${SRCPV}"

SRCREV = "4275a7d617d5c062cf8c1afeb3f8287c9aafd363"

S = "${WORKDIR}/git/server"

FILES:${PN} += "${bindir}/aesdsocket"

TARGET_LDFLAGS += "-pthread -lrt"

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "aesdsocket"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/aesdsocket-start-stop ${D}${sysconfdir}/init.d/aesdsocket
    install -d ${D}${bindir}
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/aesdsocket
}
