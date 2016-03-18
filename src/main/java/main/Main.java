package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 17.03.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5050);

        System.out.println("Server started!");


        while(true){
            Socket s = serverSocket.accept();
            InputStream inputStream = s.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while(bufferedReader.ready()){
                String l = bufferedReader.readLine();
                System.out.println(l);
            }
        }
    }
}
