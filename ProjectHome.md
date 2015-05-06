## What is libsndfile? ##
[libsndfile](http://www.mega-nerd.com/libsndfile/) is an audio manipulation tool written in C.

## What is the purpose of this project? ##
If you don't want to use the java.sound API (which is limited) or other java tools for audio conversions, you now have the option of using libsndfile as a native java library.

I didn't want to reinvent the wheel.


## How was libsndfile wrapped? ##
Using [SWIG](http://www.swig.org/), I generated a java wrapper for libsndfile.  The wrapper configuration exists in swig/libsndfile.i .

This project includes everything required to regenerate the wrapper for Windows 7, 64bit JDK1.7 (see swig/README.txt for prereqs).  However, it can serve as a basis for generating for any operating system (see swig/generate\_dlls.sh)


## A Java DLL Wrapper? ##
Concerned about performance of a java wrapper for a native DLL?  Don't be.  There are some example videos online (swig related?) that show java DLL wrappers to be extremely efficient.


## Examples ##
I added a few simple [junit](http://junit.sourceforge.net/) tests to verify functionality, that can also be used as a basis for development.


## Project Structure ##
This is a [maven](http://maven.apache.org/) project.


## How do I install it? ##
If you are running a supported platform (currently, windows 7), download the most recent release ZIP and run 'install\_dlls.sh' in cygwin.

Done!


## My platform isn't supported ##
This project can be extended to work on any platform, including OSX.

It simply involves writing a new set of generate**.sh and install**.sh scripts.  I'm hoping to extend to OSX in the near future..


## What else? ##
Enjoy.