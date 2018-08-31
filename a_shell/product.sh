#! /bin/bash
cd movie-server
mvn clean package docker:build  -DpushImage -Dmaven.test.skip=true