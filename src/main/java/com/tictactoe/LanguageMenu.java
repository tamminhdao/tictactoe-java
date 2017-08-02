package com.tictactoe;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LanguageMenu {
    private UserInput receiver;
    private Gson gson = new Gson();

    public LanguageMenu(UserInput receiver) {
        this.receiver = receiver;
    }

    public Messages chooseLanguage() {
        System.out.println("Press [E] for English or [V] for Vietnamese");
        String languageSelection = this.getInput();
        if (languageSelection.equals("E")) {
            try {
                Messages messages = gson.fromJson(new FileReader("languageFiles/english.json"), Messages.class);
                return messages;
            } catch (FileNotFoundException fnf) {
                System.out.println("Language not available.");
            }
        } else if (languageSelection.equals("V")) {
            try {
                Messages messages = gson.fromJson(new FileReader("languageFiles/vietnamese.json"), Messages.class);
                return messages;
            } catch (FileNotFoundException fnf) {
                System.out.println("Language not available.");
            }
        }
        return chooseLanguage();
    }

    private String getInput() {
        return this.receiver.obtainInput();
    }
}
