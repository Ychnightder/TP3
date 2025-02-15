package exo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientC {
    private static int port = 3000;
    private static String host = "localhost";
    private static int idClient = 1;
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        try {
            socket = new Socket(host, port);

            PrintWriter sout = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connecte au serveur " + host + " sur le port " + port + ": ");
            String line;

            System.out.println(sin.readLine()); // Titre "Liste des cours disponibles :"
            while (!(line = sin.readLine()).equals("FIN_LISTE")) {
                System.out.println(line);
            }

            line = sin.readLine(); // 1�re question
            System.out.println(line);

            // prompt d'invite � la saisie
            System.out.print("->");
            line = clavier.readLine();
            sout.println(line);

            line = sin.readLine(); // 2�me question
            System.out.println(line);

            // prompt d'invite � la saisie
            System.out.print("->");
            line = clavier.readLine();
            sout.println(line);

            System.out.println(sin.readLine());
            socket.close();

        }
        catch (IOException e) {
            System.err.println("Fin du service");
        }
        // Refermer dans tous les cas la socket
        try {
            if (socket != null) socket.close();
        }
        catch (IOException ignored) {}
    }
}
