package ojmServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OjmServer extends Thread {

    ServerSocket ss = null;
    Socket socket = null;

    @Override
    public void run() {

        try {
            // 서버 & 소켓 Connect
            ss = new ServerSocket(3000);
            System.out.println("Server started successfully.....");

            while(true) {
                socket = ss.accept();
                System.out.println("ClientNo. | " + socket.getInetAddress());
            }

//            PrintWriter out = new PrintWriter(socket.getOutputStream());
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
            try {ss.close();}
            catch (IOException ex) {e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        OjmServer os = new OjmServer();
        os.start();
    }
}
