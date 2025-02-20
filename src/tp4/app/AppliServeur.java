package tp4.app;

import tp4.server.Serveur;
import tp4.service.ServiceInversion;

public class AppliServeur {
    public static void main(String[] args) {
        new Thread(new Serveur(ServiceInversion.class , 8888)).start();
    }
}
