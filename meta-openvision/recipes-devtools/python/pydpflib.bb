DESCRIPTION = "DPF access extension module"
MAINTAINER = "https://sourceforge.net/projects/pydpf/"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=6a256fd20875b5cf06888bbcbe1a21aa"

SRC_URI = "git://github.com/athoik/pydpflib.git;protocol=http"

DEPENDS = "libusb"

S = "${WORKDIR}/git"

inherit gitpkgv ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "setuptools3", "setuptools", d)}

PV = "0.14+git${SRCPV}"
PKGV = "0.14+git${GITPKGV}"

do_compile_prepend() {
    $MAKE -C ./dpf-ax/dpflib all
}

include python-package-split.inc
