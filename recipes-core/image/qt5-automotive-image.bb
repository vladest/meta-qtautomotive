# Pulled from a mix of different images:
include recipes-core/images/rpi-basic-image.bb
# This image is a little more full featured, and includes wifi
# support, provided you have a raspberrypi3
#inherit linux-raspberrypi-base

inherit sdcard_image-rpi
SUMMARY = "The minimal image that can run Qt5 applications with QtAutomotive suite"
LICENSE = "MIT"

AUTOMOTIVE = " \
    qtapplicationmanager \
	 qtivi \
"    

MY_TOOLS = " \
    qtbase \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-tools \
"
MY_PKGS = " \
    qt3d \
    qt3d-dev \
    qt3d-mkspecs \
    qtcharts \
    qtcharts-dev \
    qtcharts-mkspecs \
    qtconnectivity-dev \
    qtconnectivity-mkspecs \
    qtquickcontrols2 \
    qtquickcontrols2-dev \
    qtquickcontrols2-mkspecs \
    qtdeclarative \
    qtdeclarative-dev \
    qtdeclarative-mkspecs \
    qtgraphicaleffects \
    qtgraphicaleffects-dev \
    qtvirtualkeyboard \
"
MY_FEATURES = " \
    linux-firmware-bcm43430 \
    bluez5 \
    i2c-tools \
    python-smbus \
    bridge-utils \
    hostapd \
    dhcp-server \
    iptables \
    wpa-supplicant \
"
DISTRO_FEATURES_append += " bluez5 bluetooth wifi"
IMAGE_INSTALL_append = " \
    ${MY_TOOLS} \
    ${MY_PKGS} \
    ${MY_FEATURES} \
    ${AUTOMOTIVE} \
"