package de.flash.game.user.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String getInput() {
        boolean flag = true;
        String response = "";
        while (flag)
        try {
            response = reader.readLine();
            flag = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
