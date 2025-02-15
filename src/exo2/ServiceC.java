package exo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServiceC implements Runnable {

    private final Socket SocketClient;
    private static List<Cours> courses;
    public static void setCourses(List<Cours> pCourses) {
        courses = pCourses;
    }

    public ServiceC(Socket SocketClient) {
        this.SocketClient = SocketClient;
    }
    private static Cours getCours(int noCours) {
        for (Cours c : courses)
            if (c.getNumeroCours() == noCours)
                return c;
        return null;
    }
    @Override
    public void run() {
        String reponse = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(SocketClient.getInputStream()));
            PrintWriter out = new PrintWriter(SocketClient.getOutputStream(), true);

            out.println("Liste des cours disponibles :");
            for (Cours cours : courses) {
                out.println(cours.toString());
            }

            out.println("FIN_LISTE");


            out.println("Tapez le numero de cours : ");
            int noCours = Integer.parseInt(in.readLine());

            out.println("Tapez le nombre de places : ");
            int nbrePlaces = Integer.parseInt(in.readLine());

            Cours cours = getCours(noCours);

            if (cours != null) {
                synchronized (cours) {
                    try {
                        cours.inscription(nbrePlaces);
                        reponse = "Inscription reussie: " + cours;
                    } catch (PasAsseezDePlacesException e) {
                        reponse = e.toString();
                    }
                }
            } else {
                reponse = "Aucun cours ne porte ce numero";
            }
            out.println(reponse);
        } catch (Exception e) {
            e.printStackTrace();
            reponse = "Erreur lors de l'inscription: " + e.getMessage();
        } finally {
            try {
                SocketClient.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    protected void finalize() throws Throwable {
        SocketClient.close();
    }
}
