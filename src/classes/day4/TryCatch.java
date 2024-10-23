package classes.day4;

import java.io.IOException;
import java.net.Socket;

public class TryCatch {
    public static void main(String[] args) {
        int is[] = new int[3];
        System.out.println(is[2]);

        try {
            Socket s = new Socket("Localhost", 5000);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
