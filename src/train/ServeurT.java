package train;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServeurT {
    private static List<Personne> listePersonnes = new ArrayList<>();
    public static List<Personne> getListePersonnes() {
        return listePersonnes;
    }
    private static int cpt = 1;

    public static void main(String[] args) {
        listePersonnes.add(new Personne("jhon","Doe"));
        listePersonnes.add(new Personne("Jane","Doe"));
        listePersonnes.add(new Personne("jack","Doe"));

        ServerSocket serverSocket = null;

        int port = 3000;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Serveur port: " + port);

            while (true) {
               Socket client = serverSocket.accept();
                System.out.println("Client connecte N-"+ cpt++);
                ServiceInscriptionPersonne service = new ServiceInscriptionPersonne(client);
                Thread t = new Thread(service);
                t.start();

            }

        } catch (Exception e) {
            e.getMessage();
        }

    }
}
