SUMMARY = "Task to install graphics sources in SDK"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check

REQUIRED_MACHINE_FEATURES = "gpu"

RDEPENDS:${PN} = "\
    ${PREFERRED_PROVIDER_virtual/gpudriver}-src \
    ${@bb.utils.contains('MACHINE_FEATURES', 'gc320', 'ti-gc320-driver-src', '', d)} \
"
