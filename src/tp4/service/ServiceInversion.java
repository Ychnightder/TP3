package tp4.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ServiceInversion extends Service {

    public ServiceInversion() {
        super();
    }

    @Override
    public void run() {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
            PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client a recu : " + line);
                String resverse = new StringBuilder(line).reverse().toString();
                out.println(resverse);
            }
            in.close();
            out.close();
            getSocket().close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
