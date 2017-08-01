package com.tictactoe;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LanguageMenu {
    private UserInput receiver;
    private Gson gson = new Gson();
    private Messages messages;

    public LanguageMenu(UserInput receiver) {
        this.receiver = receiver;
    }

    public Messages chooseLanguage() {
        System.out.println("English or Vietnamese");
        String languageSelection = this.getInput();
        if (languageSelection.equals("E")) {
            try {
                Messages messages = gson.fromJson(new FileReader("languageFiles/english.json"), Messages.class);
                return messages;
            } catch (FileNotFoundException fnf) {
                System.out.println("Language not available.");
            }
        } else {
            try {
                Messages messages = gson.fromJson(new FileReader("languageFiles/vietnamese.json"), Messages.class);
                return messages;
            } catch (FileNotFoundException fnf) {
                System.out.println("Language not available.");
            }
        }
        return this.messages;
    }

    private String getInput() {
        return this.receiver.obtainInput();
    }
}
