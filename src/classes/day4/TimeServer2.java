package classes.day4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer2 extends Thread {

    @Override
    public void run() {

    }

    public void init() {
        int port = 5000;

        try {
            // 예외가 발생할 가능성이 있는 코드를 쓴다.
            ServerSocket ss = new ServerSocket(port);

            while(true) {
                System.out.println("Server Waiting....");
                Socket s = ss.accept();
                System.out.println(s.getInetAddress());
            }

        } catch(IOException e) {
            System.out.println("예외가 발생하였음" + e.toString());
        }
    }

    public static void main(String[] args) {
        TimeServer2 ts2 = new TimeServer2();
        ts2.init();  // 준비
        ts2.start();
    }
}
