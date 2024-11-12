package athread.step1;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//서버측에서 전송한 문자열을 청취하기
class KiwiClientThread extends Thread{
    public void run(){
        System.out.println("run메소드 호출 성공");
    }
}
public class KiwiClient extends JFrame{
    LoginApp loginApp = null;
    JTabbedPane tp = new JTabbedPane();
    MessageRoom mr = new MessageRoom(this);
    WaitRoom wr = new WaitRoom(this);
    Socket mySocket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String ip = "127.0.0.1";
    int port = 3000;
    public KiwiClient(LoginApp loginApp){
        this.loginApp = loginApp;
        initDisplay();
        //connect_process();
    }
    //이 메소드는 반드시 initDisplay()호출 한 뒤에 호출해야 합니다.
    //왜냐면 지연이 발생하니까
    public void connect_process(){
        this.setTitle( loginApp.nickName +"님의 대화창");
        try{
            mySocket = new Socket(ip, port);
            oos = new ObjectOutputStream(mySocket.getOutputStream());
            ois = new ObjectInputStream(mySocket.getInputStream());
            Room room = new Room();
            room.state = "대기";
            oos.writeObject(Protocol.WAIT
            +Protocol.seperator+loginApp.nickName
            +Protocol.seperator+room.state);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void initDisplay(){
        //tp.addTab("대기실", wr);
        //tp.addTab("단톡방", mr);
        this.setSize(650,580);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        KiwiClientThread kct = new KiwiClientThread();
        kct.start();
    }
}
