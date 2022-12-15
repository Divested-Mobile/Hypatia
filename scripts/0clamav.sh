#!/bin/sh
#License: GPL-3.0
#Description: Hypatia conversion script for ClamAV databases (GPL-2.0)

#sudo -i freshclam
origDir="$PWD"
mkdir /tmp/mss
mkdir /tmp/mss/optimized
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
	#remove unnecessary bits to reduce file size and app memory usage
	python "$origDir"/optimize.py "$db" >> optimized/"$db";
	#sort to increase compression efficiency
	sort -k3 -t ":" --parallel=$(nproc) --output processed/"$db" optimized/"$db";
done;

gzip -k /tmp/mss/*.hdb
gzip -k /tmp/mss/*.hsb
gzip -k /tmp/mss/processed/*.hdb
gzip -k /tmp/mss/processed/*.hsb
