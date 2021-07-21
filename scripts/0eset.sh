#!/bin/bash
#License: GPLv3
#Description: Hypatia conversion script for https://github.com/eset/malware-ioc (BSD-2-Clause)

processHashes() {
	local name=$(basename $1);
	if [ -f $1/samples.$2 ]; then
		while IFS= read -r line
		do
			echo "$line":0:ESET."$name" >> ./eset.$3;
		done < "$1/samples.$2";
	fi;
}
export -f processHashes;

find . -maxdepth 2 -mindepth 1 -type d -exec bash -c 'processHashes "{}" md5 hdb' \;
find . -maxdepth 2 -mindepth 1 -type d -exec bash -c 'processHashes "{}" sha1 hsb' \;
find . -maxdepth 2 -mindepth 1 -type d -exec bash -c 'processHashes "{}" sha256 hsb' \;
gzip *.hdb;
gzip *.hsb;
