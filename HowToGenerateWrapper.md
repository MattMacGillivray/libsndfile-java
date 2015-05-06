#How to generate the java libsndfile wrapper for windows7, JDK1.7 x64

# Introduction #
How to generate the java libsndfile wrapper for windows7, JDK1.7 x64 (text also included in swig/README.txt)

# Details #

Prereqs:
  1. 64bit java installation.
  1. Ensure you are using it - check Windows/System32 and Windows/SysWOW64  for java.exe, javaw.exe (etc) files.  If they exist, nuke 'em.
  1. Cygwin with full development tools installed.
  1. Swig - http://www.swig.org/
  1. libsndfile 64 bit installation.

How was this wrapper generated?
Run the generate\_dlls.sh script.

# Notes #
  1. Currently using v1.0.25 (2011-07-23) of libsndfile (swig/LIBSNDFILE\_VERSION.txt)
  1. sndfile.h, sndfile.hh were taken from LIBSNDFILE\_INSTALL\_DIR/include
  1. libsndfile-1.dll was taken from LIBSNDFILE\_INSTALL\_DIR/bin