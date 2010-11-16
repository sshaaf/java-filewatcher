@echo off

REM Test if JAFW_DEV variable is set
if "%JAFW_DEV%" == "" goto wrongenv

REM Test if JAFW_DEV variable is set
if "%ANT_HOME%" == "" goto wrongenv2


REM Global Ant options
set ANT_OPTS=-Xmx512m
set CLASSPATH=%ANT_HOME%\lib\ant.jar;%ANT_HOME%\lib\ant-xalan1.jar;%ANT_HOME%\lib\ant-xalan2.jar

REM Start ant with supplied arguments
%ANT_HOME%\bin\ant.bat -buildfile %JAFW_DEV%\build\build.xml %*

goto end

:wrongenv
echo "Error: The \$JAFW_DEV environment variable is not set"
goto end

:wrongenv2
echo "Error: The \$ANT_HOME environment variable is not set"
goto end


:end