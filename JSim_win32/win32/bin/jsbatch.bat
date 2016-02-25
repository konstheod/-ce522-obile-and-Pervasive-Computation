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
%JAVA% "-Djsim.home=%JSIMHOME%" -Xmx%JSIMMEM%m "-Djava.library.path=%JSIMNATIVE%" -Djsim.userdir=HOME JSim.text.Batch %*
