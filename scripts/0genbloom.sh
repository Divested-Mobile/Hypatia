#!/bin/sh
#License: CC0

rm production/index.html
cp template.html production/index.html
echo "<pre>" >> production/index.html
sed -i "s/\[DATE\]/$(date -u)/" production/index.html
java -jar HypatiaDatabaseConverter-0.1__.jar raw/ >> production/index.html
echo "</pre>" >> production/index.html
cat extended.html >> production/index.html
mv raw/hypatia-*-bloom.bin production/

sed -s 'N;/md5: 0, sha1: 0, sha256: 0/!P;D' -i production/index.html
