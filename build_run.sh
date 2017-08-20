#!/bin/bash
mvn clean compile assembly:single &&
clear &&
java -jar target/tictactoe-1.0-SNAPSHOT-jar-with-dependencies.jar
