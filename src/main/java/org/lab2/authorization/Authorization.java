package org.lab2.authorization;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.lab2.io.Reader;

import java.io.IOException;
import java.net.Socket;

public class Authorization implements Runnable{

    private final Socket socket;

    public Authorization(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String message = new Reader(socket).readMessage();

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            AuthForm authForm = gson.fromJson(message, AuthForm.class);
            System.out.println(authForm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

