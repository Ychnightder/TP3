package exo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServeurC {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        List<Cours> listeDesCours = new ArrayList<>();
        listeDesCours.add(new Cours(1, "Programmation Java", 10));
        listeDesCours.add(new Cours(2, "Bases de donnees SQL", 15));
        listeDesCours.add(new Cours(3, "Reseaux et Securite", 8));
        listeDesCours.add(new Cours(4, "Developpement Web", 12));


        int port = 3000;
        try {
            serverSocket = new ServerSocket(port);

            System.out.println("Serveur se lance sur le port : " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouveau client connecte°");
                ServiceC serviceCours = new ServiceC(clientSocket);


                ServiceC.setCourses(listeDesCours);

                Thread t = new Thread(serviceCours);
                t.start();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l’exécution du serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
