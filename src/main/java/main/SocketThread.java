package main;

import java.io.*;
import java.net.Socket;

/**
 * Created by User on 18.03.2016.
 */
public class SocketThread extends Thread{
    private Socket s;
    public SocketThread(Socket s){
        this.s = s;
    }

    public void run() {
        try {
            InputStream inputStream = s.getInputStream();
            OutputStream outputStream = s.getOutputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);

            String l;
            while ((l = reader.readLine()) != null) {
                if (l.contains("Bue")) {
                    writer.close();
                    reader.close();
                    s.close();
                    break;

                }
                writer.write(l);
                writer.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
