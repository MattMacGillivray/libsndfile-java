
if [ -z "$JAVA_HOME" ]; then
	echo Please set your JAVA_HOME environment variable to proceed
	echo
	echo Fail.
	exit 1;
fi

echo Setting environment variables
if $cygwin; then
	JAVA_HOME_SHORT=`cygpath -d "$JAVA_HOME"`
	JAVA_HOME_UNIX=`cygpath -u "$JAVA_HOME_SHORT"`
fi
echo $JAVA_HOME_SHORT
echo $JAVA_HOME_UNIX
echo done
echo

echo Cleaning directories
rm libsndfile_wrap.c
rm libsndfile_wrap.dll
rm libsndfile_wrap.o
rm ../src/main/java/com/meganerd/*.java
echo done
echo

echo Generating DLL
swig -java -package com.meganerd -outdir ../src/main/java/com/meganerd libsndfile.i
x86_64-w64-mingw32-gcc -c libsndfile_wrap.c -I$JAVA_HOME_UNIX/include -I$JAVA_HOME_UNIX/include/win32
x86_64-w64-mingw32-gcc -static -shared libsndfile_wrap.o -Wl,-add-stdcall-alias -o libsndfile_wrap.dll libsndfile-1.dll
echo done
echo

echo Copying DLLs to $JAVA_HOME_UNIX/bin
cp libsndfile_wrap.dll $JAVA_HOME_UNIX/bin
cp libsndfile-1.dll $JAVA_HOME_UNIX/bin
echo done
echo

echo Copying DLLs to $JAVA_HOME_UNIX/jre/bin
cp libsndfile_wrap.dll $JAVA_HOME_UNIX/jre/bin
cp libsndfile-1.dll $JAVA_HOME_UNIX/jre/bin
echo done
echo

echo Awesome.
