wget "https://threatview.io/Downloads/MD5-HASH-ALL.txt" -O - >> raw/threatview.md5
wget "https://threatview.io/Downloads/SHA-HASH-FEED.txt" -O - >> raw/threatview.sha1

sort -u -o raw/threatview.md5 raw/threatview.md5
sort -u -o raw/threatview.sha1 raw/threatview.sha1
