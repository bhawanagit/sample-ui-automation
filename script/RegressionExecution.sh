#!/bin/bash
set -eu

echo "Running Testpack for Regression on qa"
cd /home/circleci/sample-ui-automation/src/test/java/resources/driver
ls
chmod +x chromedriver
cd /home/circleci/sample-ui-automation
mvn clean test	-Dcucumber.options="--tags @Regression"
