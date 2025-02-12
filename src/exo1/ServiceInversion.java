package exo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceInversion implements Runnable{

    private Socket socketClient;

    public ServiceInversion(Socket socketClient) {
        this.socketClient = socketClient;
    }

    @Override
    public void run() {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("exo1.Client a envoyé : " + line);
                String resverse = new StringBuilder(line).reverse().toString();
                out.println(resverse);
            }
            in.close();
            out.close();
            socketClient.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
