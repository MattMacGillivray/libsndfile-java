
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