#! /bin/bash
find . | grep "^.*.java$" > files.txt
javac @files.txt
java Main
