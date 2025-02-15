package exo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8888;
        try {
            Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connecté au serveur " + host + " sur le port " + port);
            System.out.println("Tapez une chaîne de caractères :");
            String userInput;

            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Reponse : " + in.readLine());
                System.out.println("Tapez une chaîne de caractères :");
            }

            out.close();
            in.close();
            stdIn.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
