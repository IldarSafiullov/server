package org.lab2.authorization;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
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
            DataInputStream din = new DataInputStream(socket.getInputStream());
            String userStr = din.readUTF();
            System.out.println(userStr);

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            User user = gson.fromJson(userStr, User.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

