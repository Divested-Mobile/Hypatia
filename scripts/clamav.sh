#!/bin/bash
#License: GPLv3

#sudo freshclam
mkdir /tmp/mss
cd /tmp/mss
cp /var/lib/clamav/main.cvd .
cp /var/lib/clamav/daily.cld .
sigtool -u main.cvd
sigtool -u daily.cld

#MD5
grep "Andr\\." main.hdb >> Android.hdb
grep "Andr\\." daily.hdb >> Android.hdb
grep "Unix\\." main.hdb >> Android.hdb
grep "Unix\\." daily.hdb >> Android.hdb
grep "Multios\\." main.hdb >> Android.hdb
grep "Multios\\." daily.hdb >> Android.hdb

#SHA
grep "Andr\\." main.hsb >> Android.hsb
grep "Andr\\." daily.hsb >> Android.hsb
grep "Unix\\." main.hsb >> Android.hsb
grep "Unix\\." daily.hsb >> Android.hsb
grep "Multios\\." main.hsb >> Android.hsb
grep "Multios\\." daily.hsb >> Android.hsb

gzip /tmp/mss/*.hdb
gzip /tmp/mss/*.hsb
