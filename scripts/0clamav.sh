#!/bin/sh
#License: GPL-3.0
#Description: Hypatia conversion script for ClamAV databases (GPL-2.0)

#sudo -i freshclam
mkdir /tmp/mss
mkdir /tmp/mss/processed
cd /tmp/mss
cp /var/lib/clamav/main.c*d .
cp /var/lib/clamav/daily.c*d .
sigtool -u main.c*d
sigtool -u daily.c*d

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

databases=("Android.hdb" "Android.hsb" "main.hdb" "main.hsb" "daily.hdb" "daily.hsb");
for db in "${databases[@]}"
do
	sort --parallel=$(nproc) --unique "$db" --output processed/"$db";
done;

gzip /tmp/mss/*.hdb
gzip /tmp/mss/*.hsb
gzip /tmp/mss/processed/*.hdb
gzip /tmp/mss/processed/*.hsb
