
How to make a LIBSNDFILE wrapper for java.

Prereqs:
1.  64bit java installation.
2.  Ensure you are using it - check Windows/System32 and Windows/SysWOW64 for java*.exe files.  If they exist, nuke 'em.
3.  Cygwin with full development tools installed.
4.  Swig - http://www.swig.org/
5.  libsndfile 64 bit installation.

How was this wrapper generated?
Run the generate_dlls.sh script.

sndfile.h, sndfile.hh were taken from LIBSNDFILE_INSTALL_DIR/include
libsndfile-1.dll was taken from LIBSNDFILE_INSTALL_DIR/bin