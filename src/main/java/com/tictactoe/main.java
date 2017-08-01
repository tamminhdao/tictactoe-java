package com.tictactoe;
import com.google.gson.Gson;


import java.io.FileNotFoundException;
import java.io.FileReader;

public class main {
    public static void main (String arg[]) throws FileNotFoundException {
//        Program program = new Program();
//        program.run();

    Gson g = new Gson();
    Messages m = g.fromJson(new FileReader("languageFiles/english.json"), Messages.class);
    System.out.println (m.Game_announceTie);
    }
}
