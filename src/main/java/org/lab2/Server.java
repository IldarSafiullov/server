package org.lab2;

import org.lab2.authorization.Authorization;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) throws IOException {
        ServerSocket  serverSocket = new ServerSocket(8090);

        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new Authorization(socket)).start();
        }
    }
}





