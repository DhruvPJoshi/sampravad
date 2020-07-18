#!/bin/bash

PROJ_NAME=$1
JAR_NAME=${2}.jar
ENTRY_POINT=$3
SRC_ROOT=src/main/java
BIN_ROOT=bin/main/java

if [ -d ${PROJ_NAME} ]; then
  cd ${PROJ_NAME}
  PROJ_PWD=`pwd`

  if [ -d bin ]; then
    echo "Cleaning: previous builds"
    rm -rf bin
  fi

  echo "Building: ${PROJ_NAME}"
  mkdir -p ${BIN_ROOT}
  javac -d ${BIN_ROOT}/ $(find "${SRC_ROOT}/." -name "*.java")
  echo "Finished: building ${PROJ_NAME}"

  if [ ! -d lib ]; then
    mkdir lib
  fi

  cd ${BIN_ROOT}

  if [ ! -z ${JAR_NAME} ]; then
    echo "Packing: jar '${JAR_NAME}"
    if [ ! -z ${ENTRY_POINT} ]; then
      jar cfe ${JAR_NAME} ${ENTRY_POINT} .
    else
      jar cf ${JAR_NAME} .
    fi

    mv ${JAR_NAME} ${PROJ_PWD}/lib/
    echo "Jar: ${JAR_NAME} created in lib/"
  fi
else
  echo "Please provide a project name"
fi
