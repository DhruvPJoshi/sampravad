#!/bin/bash

PROJ_NAME=$1

if [ ! -d ${PROJ_NAME} ]; then
  echo "Err: project '${PROJ_NAME}' does not exist"
  exit 1
fi

cd ${PROJ_NAME}
rm -rf bin/
rm -rf lib/
echo "${PROJ_NAME} cleaned"
