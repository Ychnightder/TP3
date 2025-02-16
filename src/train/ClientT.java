package train;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientT {

//    --- socket
    private static int port = 3000;
    private static String host = "localhost";
    private static int count = 0;
    public static void main(String[] args) {
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        Socket SocketClient = null;
        try{
            SocketClient = new Socket(host , port);
            BufferedReader in = new BufferedReader(new InputStreamReader(SocketClient.getInputStream()));
            PrintWriter out = new PrintWriter(SocketClient.getOutputStream(), true);
            String line;

            System.out.println("Votre Nom : ");
            line = clavier.readLine();
            out.println(line);

            System.out.println("Votre Prenom : ");
            line = clavier.readLine();
            out.println(line);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
