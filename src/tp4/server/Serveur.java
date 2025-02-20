package tp4.server;

import tp4.service.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur implements Runnable {
    private Class<? extends Service> serviceClass;
    private int port;
    private static int cpt = 0;

    public Serveur(Class<? extends Service> serviceClass, int port) {
        this.serviceClass = serviceClass;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur-"+port);
            while (true) {
                Socket socketClient = serverSocket.accept();
                System.out.println("Client-"+cpt++);

                Service service = serviceClass.getDeclaredConstructor().newInstance();

                service.setSocket(socketClient);

                new Thread(service).start();
            }
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
