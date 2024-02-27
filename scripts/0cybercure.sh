wget "https://api.cybercure.ai/feed/get_hash?type=csv" -O - | sed 's/,/\n/g' >> raw/cybercure.md5

sort -u -o raw/cybercure.md5 raw/cybercure.md5
