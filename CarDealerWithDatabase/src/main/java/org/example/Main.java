package org.example;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String asciiArt = FigletFont.convertOneLine("Car Dealer W  Database");
        System.out.println(asciiArt);

        Menu m = new Menu();
        m.display();

    }
}