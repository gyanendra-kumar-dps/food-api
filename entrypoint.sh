#!/bin/sh
echo "starting Food Api"
echo "present working directory ${pwd}"
java -jar food-api.jar --spring.config.location="application.yml"