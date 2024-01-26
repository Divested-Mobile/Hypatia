rm -f raw/threatview.md5
rm -f raw/threatview.sha1
wget "https://threatview.io/Downloads/MD5-HASH-ALL.txt" -O - | sort -u > raw/threatview.md5
wget "https://threatview.io/Downloads/SHA-HASH-FEED.txt" -O - | sort -u > raw/threatview.sha1
