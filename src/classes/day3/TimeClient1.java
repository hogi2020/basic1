package classes.day3;

// TimeClient.java: 서버에 접속해서 1초마다 시간 문자열을 받아서 출력하는 프로그램

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient1 extends Thread {
    public JLabel timelabel;

    // 다른 클래스의 화면에 TimeClient가 청취한 현재 시분초 문자열을 출력
    // 출력하는 문제 이므로 JLabel UI클래스를 선언하였습니다.
    // 파라미터를 갖는 생성자 추가해야 합니다와 연결되어 있습니다.
    // 파라미터 자리에 필요한 타입도 결정할 수 있다면...
    public TimeClient1() {}
    public TimeClient1(JLabel timelabel){
        this.timelabel = timelabel;
    }


    // run() 시작
    public void run() {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String timeStr = null;

        try {
            socket = new Socket("localhost", 2008);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true) {
                System.out.println("while(true)");
                while((timeStr = in.readLine()) != null) {
                    System.out.println(timeStr);
                    timelabel.setText(timeStr);  // setText 업데이트 진행
                }
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException i) {}
            }

        } catch(IOException i) {
            timelabel.setText("타임서버에 접속할 수 없습니다.");
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {}
        }
    }

    // run() 종료
    public static void main(String args[]){
        TimeClient1 tc = new TimeClient1();
        tc.start();
    }

}
