#!/usr/bin/env bash
# build project and deploy to payara server
mvn clean package
docker cp target/sandbox.war payara:/opt/payara/deployments
docker cp password.file payara:/opt/payara/passwordFile
echo 'deploying to payara docker container ...'
docker exec payara bash -c "asadmin -u admin -W passwordFile --notify deploy --force deployments/sandbox.war"

