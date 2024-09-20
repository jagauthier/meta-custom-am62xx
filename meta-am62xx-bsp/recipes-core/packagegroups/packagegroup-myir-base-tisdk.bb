DESCRIPTION = "Additional packages beyond console packages shared by TI SDKs"
LICENSE = "MIT"
PR = "r23"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

OPTEE_PKGS = " \
    optee-client \
    optee-test \
    optee-examples \
"

RDEPENDS:${PN} = "\
    dbus-broker \
    expat \
    glib-2.0 \
    libxml2 \
    libpcre \
    iptables \
    iperf3 \
    netperf \
    arago-gpl-notice \
    arago-feed-config \
    nfs-utils-client \
    cifs-utils \
    phytool \
    ${@bb.utils.contains_any('OPTEEOUTPUTMACHINE', 'ti', "${OPTEE_PKGS}", "", d)} \
"

RDEPENDS:${PN}:append:k3 = " ${OPTEE_PKGS}"
