#!/bin/sh

# this script compiles a C module for MML F&P
#   this version appropriate for JSim binary distribution
# arguments are
#    $1 home directory $JSIMHOME
#    $2 directory to build in
#    $3 module name,  without .c extension
#    $4... additional compilation flags

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

# parse command line
if [ $# -lt 3 ]
then
  echo "jscompile_c requires at least 3 arguments"
  exit 1
fi
export JSIMHOME="$1"
shift
DIR="$1"
shift
NAME="$1"
shift
CFPFLAGS="$*"

# cd DIR
cd $DIR
if [ $? -ne 0 ]
then
  echo "Invalid C compilation directory: $DIR"
  exit 1
fi

# make module.cfp
TARGET="$NAME".cfp
rm -f $TARGET
$JSIMMAKE -f $JSIMHOME/lib/Makefile.global $TARGET
if [ $? -ne 0 ]
then
  echo "C compilation make failed"
  exit 1
fi
