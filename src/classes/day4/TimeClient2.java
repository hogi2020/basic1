package classes.day4;

import java.io.IOException;
import java.net.Socket;

public class TimeClient2 extends Thread {

    public void init() {
        try {
            Socket s = new Socket("localhost", 5000);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    // 메인 스레드
    public static void main(String[] args) {
        TimeClient2 tc2 = new TimeClient2();
        tc2.init();
    }
}
