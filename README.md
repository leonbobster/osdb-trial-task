### Run App:

Clone this repository and run following commands inside the project directory:

```
docker build -t osdb-trial-task .
docker run -it -v `pwd`:/tmp/app-data --rm osdb-trial-task java -cp out App /tmp/app-data/data2.txt
```

For Windows environment you should change \`pwd\` with absolute path to a directory with call logs.

For example: `... -v c:\path\to\dir\with\logs:/tmp/app-data ...`

If you want to run app for another log you should change `data2.txt` with any other file name you want.
