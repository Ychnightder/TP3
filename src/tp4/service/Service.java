package tp4.service;

import java.net.Socket;

public abstract class Service implements Runnable {

    private Socket socket;
    public Service() {
    }
    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    @Override
    public  void run(){};
}
