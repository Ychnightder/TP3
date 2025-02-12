package exo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args)  {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("Server lancé on port 8888");
            Socket clientSocket = serverSocket.accept();
            System.out.println("exo1.Client connected");
            Thread t = new Thread(new ServiceInversion(clientSocket));
            t.start();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
              try {
                  serverSocket.close();
              }catch (IOException e){
                  e.printStackTrace();
              }
            }
        }
    }
}
