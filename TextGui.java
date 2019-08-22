package com.googlecode.lanterna;

import java.io.IOException;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


public class TextGui{

    public static void main(String[] args) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);

        screen.startScreen();
        screen.clear();
        terminal.setForegroundColor(TextColor.ANSI.RED);

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                screen.setCharacter(i, j, new TextCharacter('.'));
            }
        }
        
        screen.refresh();

        screen.readInput();
        // screen.stopScreen();
    }

}