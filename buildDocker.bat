@echo off
call mvn clean
call mvn package
call docker build -t learnboot .

