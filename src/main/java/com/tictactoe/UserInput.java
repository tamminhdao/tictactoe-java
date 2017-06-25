package com.tictactoe;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput(Scanner s) {
        this.scanner = s;
    }

    public String obtainInput() {
        String input = this.scanner.nextLine();
        input = input.replaceAll("\\s+", "");
        return input;
    }
}
