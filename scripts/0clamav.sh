#!/bin/sh
#License: CC0
#Description: Hypatia conversion script for ClamAV databases (GPL-2.0)

#sudo -i freshclam
origDir="$PWD"
mkdir /tmp/mss
cd /tmp/mss
cp /var/lib/clamav/main.c*d .
cp /var/lib/clamav/daily.c*d .
sigtool -u main.c*d
sigtool -u daily.c*d
