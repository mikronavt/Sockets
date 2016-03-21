package main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 17.03.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5050);

        System.out.println("Server started");



        while(true){
            Socket s = serverSocket.accept();

            SocketThread t = new SocketThread(s);
            t.start();


        }
    }
}
