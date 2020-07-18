#!/bin/bash

PROJ_DIR=$1
PKG_NAME=$2
PKG_DIR=''
FILE_NAME=$3
ROOT_DIR=src/main/java

if [ ! -d ${PROJ_DIR} ]; then
  mkdir ${PROJ_DIR}
  echo "Project '${PROJ_DIR}' created"
fi

cd ${PROJ_DIR}

if [ ! -d ${ROOT_DIR} ]; then
  mkdir -p ${ROOT_DIR}
  echo "Root '${ROOT_DIR}' source directory created"
fi

if [ ! -z ${PKG_NAME} ]; then
  PKG_DIR=$(echo ${PKG_NAME} | tr '.' '/')

  cd ${ROOT_DIR}

  if [ ! -d ${PKG_DIR} ]; then
    mkdir -p ${PKG_DIR}
    echo "Package directory ${PKG_DIR} created"
  fi

  cd ${PKG_DIR}

  if [ ! -z ${FILE_NAME} ]; then
    touch ${FILE_NAME}
    echo "package ${PKG_NAME};" > ${FILE_NAME}
    echo "File ${FILE_NAME} created"
  fi
fi
