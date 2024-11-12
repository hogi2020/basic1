package athread.step1;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class KiwiServerThread extends Thread{
    KiwiServer ks = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String nickName = null;
    KiwiServerThread(){}
    //아래 생성자는 언제 호출되는가? - 사용자가 서버에 접속하면 - 클라이언트 소켓을 얻어낸다.
    KiwiServerThread(KiwiServer ks){
        this.ks = ks;
        try {
            oos = new ObjectOutputStream(ks.client.getOutputStream());
            ois = new ObjectInputStream(ks.client.getInputStream());
            String msg = (String)ois.readObject();
            System.out.println(msg);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class KiwiServer extends JFrame implements Runnable{
    //3000번 포트를 열어놓고 사용자가 접속하기를 기다린다.
    ServerSocket ss = null;
    //클라이언트측에서 3000으로 들어오면 클라이언트의 소켓정보를 client변수에 담음
    Socket client = null;
    List<KiwiServerThread> globalList = null;
    List<Room> roomList = null;
    public KiwiServer(){
        roomList = new Vector<>();
        globalList = new Vector<>();
    }
    @Override
    public void run() {
        System.out.println("run호출 성공");
        try {
            ss = new ServerSocket(3000);
            System.out.println("Server Ready.....");
            //////////// waiting 구간
            while(true){
                client = ss.accept();
                System.out.println(client.getInetAddress().getHostAddress());
                KiwiServerThread t = new KiwiServerThread(this);
                t.start();
            }//end of while
        }catch (Exception e) {

        }
    }
    public static void main(String[] args) {
        KiwiServer ks = new KiwiServer();
        Thread t = new Thread(ks);
        t.start();
    }//end of main
}
