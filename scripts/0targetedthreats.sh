#!/bin/bash
#License: CC0
#Description: Hypatia conversion script for https://github.com/botherder/targetedthreats (CC BY-SA 4.0)

while IFS=, read -r col1MD5 col2SHA256 col3Family col4Actor col5Country col6Report
do
	col4Actor=$(sed -e 's/^"//' -e 's/"$//' <<< "$col4Actor");
	col3Family=$(sed -e 's/^"//' -e 's/"$//' <<< "$col3Family");
	if [ -n "$col4Actor" ] && [ -n "$col3Family" ]; then
		description="$col4Actor-$col3Family";
	elif [ -n "$col4Actor" ] && [ -z "$col3Family" ]; then
		description="$col4Actor";
	elif [ -z "$col4Actor" ] && [ -n "$col3Family" ]; then
		description="$col3Family";
	fi;
	if [ -z "$description" ]; then
		description="targetedthreats";
	fi;

	col1MD5=$(sed -e 's/^"//' -e 's/"$//' <<< "$col1MD5");
	if [ -n "$col1MD5" ]; then
		echo "$col1MD5:0:$description" >> ./targetedthreats.hdb;
	fi;

	col2SHA256=$(sed -e 's/^"//' -e 's/"$//' <<< "$col2SHA256");
	if [ -n "$col2SHA256" ]; then
		echo "$col2SHA256:0:$description" >> ./targetedthreats.hsb;
	fi;
done < samples.csv;

sed -i '1d' targetedthreats.hdb;
sed -i '1d' targetedthreats.hsb;
