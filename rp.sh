#!/usr/bin/env bash

#rp repeats command n times with delay in seconds in between.

#example : ./rp.sh "curl -i localhost:8080/sandbox/resources/ping 2>/dev/null | head -1" 5 1
#           repeats curl request 5 times with delay of 1 second, only first line of response is displayed

COMMAND=$1
#Default value is 1000000
N=$2
#Default value is 0.3 s
DELAY=$3

for (( VAR = 0; VAR < ${N:=1000000}; ++VAR )); do
    eval "${COMMAND} &"
    sleep ${DELAY:=0.3}
done



