#!/bin/sh
#License: CC0
#Description: Hypatia conversion script for https://github.com/avast/covid-19-ioc

tail -n +2 */*.csv | sed 's/,/ , /' | awk '{ print $1 }' | sort -u  >> avast-covid19.sha256
