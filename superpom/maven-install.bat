@echo off
cd /d %~dp0
call mvn -e -Dmaven.test.skip=true install
pause
