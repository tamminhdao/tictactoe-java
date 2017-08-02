package com.tictactoe;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LanguageMenu {
    private UserInput receiver;
    private Gson gson = new Gson();
    private ArrayList<String> availableLanguages = new ArrayList<>();

    public LanguageMenu(UserInput receiver) {
        this.receiver = receiver;
        listFilesFromFolder(new File("languageFiles"));
    }

    public Messages chooseLanguage() {
        System.out.println("Pick a language from below and enter it in the console.");
        displayAvailableLanguageOptions();
        String languageSelection = this.getInput();
        try {
            String path = "languageFiles/" + languageSelection + ".json";
            return gson.fromJson(new FileReader(path), Messages.class);
        } catch (FileNotFoundException fnf) {
            System.out.println("The application is not yet available in this language. \n");
        }
        return chooseLanguage();
    }

    private String getInput() {
        return this.receiver.obtainInput();
    }

    private void listFilesFromFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesFromFolder(fileEntry);
            } else {
                availableLanguages.add(fileEntry.getName());
            }
        }
    }

    private void displayAvailableLanguageOptions() {
        for (int i = 0; i < availableLanguages.size(); i++) {
            String str = availableLanguages.get(i);
            str = str.substring(0, str.lastIndexOf('.'));
            System.out.println(str);
        }
    }
}
