#!/bin/bash
clear
mkdir classes
if javac -Xlint -d classes $(find ferry -name "*.java"); then
    jar cfe ferry.jar ml.bastiaan.ferry.App -C classes .
    java -jar ferry.jar
fi
rm -r classes
