#!/bin/bash
mvn clean compile assembly:single &&
mvn package && clear && java -jar target/tictactoe-1.0-SNAPSHOT-jar-with-dependencies.jar
