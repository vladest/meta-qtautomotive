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

DESCRIPTION = "Qt IVI"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE.FDL;md5=938bb8da9e07e20ebf320ed6f7e703a295fe3d62 \
                    file://LICENSE.GPL2;md5=d159169d1050894d3ea3b98e1c965c4058208fe1 \
                    file://LICENSE.GPL3;md5=94a9ed024d3859793618152ea559a168bbcbb5e2 \
                    file://LICENSE.GPL3-EXCEPT;md5=b1cb1bec78a34d81471d01a7acd048277e6fd447 \
                    file://LICENSE.LGPL3;md5=65c5ca88a67c30becee01c5a8816d964b03862f9"

SECTION = "libs"
DEPENDS = "qtbase qtdeclarative qtmultimedia"
DEPENDS_class-native = "qtbase"
DEPENDS_class-nativesdk = "qtbase"

require recipes-qt/qt5/qt5.inc
require recipes-qt/qt5/qt5-git.inc

QT_MODULE_BRANCH_QFACE = "upstream/develop"

SRC_URI = "${QT_GIT}/qtivi.git;name=qtivi;branch=5.9;protocol=${QT_GIT_PROTOCOL};destsuffix=git"

#SRC_URI += " \
#    ${QT_GIT}/qtivi-qface.git;name=qface;branch=${QT_MODULE_BRANCH_QFACE};protocol=${QT_GIT_PROTOCOL};destsuffix=git/src/3rdparty/qface \
#    file://0001-Use-QT_HOST_BINS-get-for-getting-correct-path.patch \
#"

SRCREV_qtivi = "23f789d9bd81853b586af098e56afcd4fa9c650b"
SRCREV_qface = "295824c8df7f74af8f3d1f368ec15942e6622f22"
SRCREV = "${SRCREV_qtivi}"
SRCREV_FORMAT = "qtivi_qface"

S = "${WORKDIR}/git"

BBCLASSEXTEND += "native nativesdk"

INSANE_SKIP_${PN}_class-native = "already-stripped"
