for database in *.bin
do
	if [ -f "$database.sig" ]; then
		#If it does exist sign if it doesn't match
		if ! gpg --verify "$database.sig"; then
			rm "$database.sig";
			gpg --sign --local-user 6395FC9911EDCD6158712DF7BADFCABDDBF5B694 --detach-sign "$database";
		fi;
	else
		#Sign it if it doesn't exist
		gpg --sign --local-user 6395FC9911EDCD6158712DF7BADFCABDDBF5B694 --detach-sign "$database";
	fi;

done
