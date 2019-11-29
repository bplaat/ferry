#!/bin/bash
clear
mkdir classes
if javac -Xlint -d classes -cp ferry.jar $(find ferry-test -name "*.java"); then
    jar cfm ferry-test.jar ferry-test/manifest.mf -C classes .
    java -jar ferry-test.jar
fi
rm -r classes
