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

DESCRIPTION = "Neptune IVI UI"
LICENSE = "GPL-3.0 | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=c41b4a3e669de55dfe304b8376b04a82"

#inherit qt5-module systemd
inherit systemd
require recipes-qt/qt5/qt5-git.inc

QT_GIT = "git://github.com/qtproject"
QT_MODULE = "qt-apps-neptune-ui"

SRC_URI += " \
    file://neptune.service \
    "

SRCREV = "2cf65ed117e8e4494b1ab66b35e3dc9a70234659"

DEPENDS = "qtbase qtdeclarative qttools-native qtquickcontrols2 qtapplicationmanager"
RDEPENDS_${PN} = "qtivi qtvirtualkeyboard dbus \
                  qtquickcontrols-qmlplugins qtgraphicaleffects-qmlplugins \
                  ${@bb.utils.contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_install_append() {
    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/neptune.service ${D}${systemd_unitdir}/system/
}

PACKAGES =+ "${PN}-apps"
RRECOMMENDS_${PN} += "${PN}-apps"

FILES_${PN}-apps += "/opt/neptune/apps"
FILES_${PN} += "\
    /opt/neptune \
    "

SYSTEMD_SERVICE_${PN} = "neptune.service"
