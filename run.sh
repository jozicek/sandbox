#!/usr/bin/env bash

docker stop payara 2> /dev/null
docker rm payara 2> /dev/null
docker run -p 8080:8080 --name payara payara/server-full
