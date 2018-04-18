package org.lab2.authorization;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.lab2.io.*;
import org.lab2.io.Reader;
import org.lab2.io.Writer;

import java.io.*;
import java.net.Socket;

public class Authorization implements Runnable{

    private final Socket socket;

    public Authorization(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String messageIn, messageOut;
            while (true){
                messageIn = new Reader(socket).readMessage();
                System.out.println(messageIn);
                messageOut = br.readLine();
                new Writer(socket).writeMessage(messageOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




        /*try {
            *//*String message = new Reader(socket).readMessage();

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            AuthForm authForm = gson.fromJson(message, AuthForm.class);
            System.out.println(authForm);*//*
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

