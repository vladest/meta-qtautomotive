############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

DESCRIPTION = "Qt component for application lifecycle management"
LICENSE = "(GFDL-1.3 & The-Qt-Company-GPL-Exception-1.0 & (LGPL-3.0 | GPL-2.0+)) | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=43a31c6abffdd61c938811959b3c1b71"

require recipes-qt/qt5/qt5.inc
require recipes-qt/qt5/qt5-git.inc

SRCREV = "9295baad5f20cf7b3e12aad37e7255a143b0c89b"

DEPENDS = "qtbase qtdeclarative libyaml libarchive"
# \
#           ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "qtwayland", "", d)}"

#RDEPENDS_${PN} = "libcrypto ${PN}-tools"
RDEPENDS_${PN} = "libcrypto"

#${@bb.utils.contains("DISTRO_FEATURES", "wayland", "-config force-multiprocess", "-config force-singleprocess", d)} 

EXTRA_QMAKEVARS_PRE += "\
    -config install-prefix=/usr \
    -config systemd-workaround \
    -config hardware-id=neptune \
    "

do_install_append() {
    install -m 0755 -d ${D}/opt/am/
    install -m 0644 ${S}/template-opt/am/config.yaml ${D}/opt/am/
}

FILES_${PN} += "\
    /opt/am \
    "

BBCLASSEXTEND += "nativesdk"

DEPENDS_class-nativesdk = "qtbase nativesdk-glibc-locale nativesdk-libarchive"
DEPENDS_class-nativesdk_remove_mingw32 += "nativesdk-glibc-locale nativesdk-libarchive"

EXTRA_QMAKEVARS_PRE_class-nativesdk += "\
    -config tools-only \
    "
