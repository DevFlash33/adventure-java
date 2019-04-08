package de.flash.game;

import java.awt.*;
import java.io.Console;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            System.out.println(filename);
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
        }else{
            new Game();
        }

    }
}
