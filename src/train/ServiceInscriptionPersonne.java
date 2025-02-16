package train;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static train.ServeurT.getListePersonnes;

public class ServiceInscriptionPersonne implements Runnable {

    Socket SocketClient;


    public ServiceInscriptionPersonne(Socket SocketClient) {
        this.SocketClient = SocketClient;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(SocketClient.getInputStream()));
            PrintWriter out = new PrintWriter(SocketClient.getOutputStream(), true);

          String nom =      in.readLine();
          String prenom =   in.readLine();
          System.out.println("data: Nom = " + nom + ", Prenom = " + prenom);
          Personne personne = new Personne(nom,prenom);

          synchronized (ServeurT.getListePersonnes()) {
              ServeurT.getListePersonnes().add(personne);
          }
            System.out.println(ServeurT.getListePersonnes());
          System.out.println("Inscription Reussie");

          SocketClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
