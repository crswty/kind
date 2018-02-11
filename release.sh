#!/bin/bash
set -e

echo Bintray User:
read bintrayUser

echo Bintray Key:
read -s bintrayKey

echo Version:
read version

./gradlew -PbintrayUser="$bintrayUser" -PbintrayKey="$bintrayKey" -Pversion="$version" uploadArchives