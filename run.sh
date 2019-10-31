#!/usr/bin/env bash
#starts payara docker container, stop and remove previous if any
docker stop payara 2> /dev/null
docker rm payara 2> /dev/null
docker run -p 8080:8080 --name payara payara/server-full
