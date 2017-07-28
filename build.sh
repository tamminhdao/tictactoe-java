#!/bin/bash
javac src/main/java/com/tictactoe/*.java
jar cfe tictactoe.jar com.tictactoe com/tictactoe/main.class
java -jar tictactoe.jar
