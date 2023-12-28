#!/bin/sh
#License: CC0
#Description: Hypatia conversion script for https://threatfox.abuse.ch/export/csv/sha256/full/ (CC0)

tail -n +10 full_sha256.csv | awk '{ print $4 } ' | sed 's/^"//' | sed 's/",$//' > threatfox.sha256
