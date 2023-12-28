#!/bin/bash
#License: CC0
#Description: Hypatia conversion script for https://github.com/AssoEchap/stalkerware-indicators (CC BY 4.0)

while IFS=, read -r col1SHA col2Package col3Certificate col4Version col5Name
do
	if [ -n "$col1SHA" ] && [ -n "$col5Name" ]; then
		echo "$col1SHA:0:$col5Name" >> ./stalkerware.hsb;
	fi;
done < samples.csv;

sed -i '1d' stalkerware.hsb;
