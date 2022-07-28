@echo off
call mvn clean
call mvn package -Dmaven.test.skip=true
call docker build -t learnboot .

