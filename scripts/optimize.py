import sys

database = open(sys.argv[1], "r");
for line in database:
	arrSplit = line.strip().split(":");
	strHash = arrSplit[0];
	strName = arrSplit[2].split("-")[0];
	print(strHash + ":0:" + strName);
