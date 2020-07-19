#!/bin/bash

EXEC_NAME=${1}.jar
HOST_NAME=$2
PORT=$3

if [ ! -f lib/${EXEC_NAME} ]; then
  echo "Err: Cannot find executable"
  echo "Info: Please run build.sh to build and pack an executable archive"
  exit 1
fi

java -jar lib/${EXEC_NAME} ${HOST_NAME} ${PORT}
