@echo off

set JSIMHOME=%~d0%~p0\..\..
set JSIMJRE=%JSIMHOME%\win32\jre
set JAVA="%JSIMJRE%\bin\java"
set CLASSPATH=%JSIMJRE%\lib\rt.jar
set CLASSPATH=%CLASSPATH%;%JSIMHOME%\lib\JSimClient.jar
set CLASSPATH=%CLASSPATH%;%JSIMHOME%\lib\JSimServer.jar
set CLASSPATH=%CLASSPATH%;%JSIMHOME%\lib\tools6.jar
set JSIMNATIVE=%JSIMHOME%\win32\lib
set PATH=%JSIMHOME%\win32\bin;%JSIMNATIVE%;%JSIMJRE%\bin;%PATH%
set JSIMMEM=1200
%JAVA% "-Djsim.home=%JSIMHOME%" -Xmx%JSIMMEM%m "-Djava.library.path=%JSIMNATIVE%" -Djsim.userdir=HOME JSim.text.JSXWrap %*
# create JSim wrappers for XSim-style models
#   Part 2: native compile

# check status from Java wrapper generation
if [ $? -ne 0 ]
then
  echo "jsxwrap: JSim wrapper generation failed"
  exit 1
fi

# the following must be defined for proper operation
export JSIMMAKE=make
export JSIMOS=win32
export JSIMOSARCH=win32
JSIMARCH=
if [ "$JSIMOS" = "macos" ]
then
  JSIMARCH=`uname -p`
  if [ "$JSIMARCH" = "powerpc" ]
  then
    JSIMARCH=ppc
  fi
fi
export JSIMARCH

LANG="$1"
shift
MODEL="$1"
shift
OBJECTS="$*"

# compile wrapper to F&P library
export XFP_OBJS="$OBJECTS"
$JSIMMAKE -f $JSIMHOME/lib/Makefile.global jsx"$MODEL".xfp
if [ $? -ne 0 ]
then
  echo "jsxwrap: JSim wrapper compilation failed"
  exit 1
fi

