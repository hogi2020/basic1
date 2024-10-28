package ojmServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class OjmClientHandler implements Runnable {
    // 선언부
    Socket socket;
    OjmServer os;
    ObjectInputStream in;
    ObjectOutputStream  out;

    // 생성자
    public OjmClientHandler(Socket socket, OjmServer os) {
        this.socket = socket;
        this.os = os;
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            os.addClientToRoom(out, null);
            
        } catch (IOException | ClassCastException e) {
        }
    }
    
}
