package ojmServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class OjmClient extends JFrame implements Runnable, ActionListener {
    Socket clientSocket = null;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;
    String msg = null;

    // Display 레이아웃 구성
    JPanel pnl_center = new JPanel();
    JPanel pnl_south = new JPanel();
    JTextField txt_field = new JTextField();
    JTextArea txt_area = new JTextArea();


    public void inDisplay() {
        pnl_center.add("Center", txt_area);
        pnl_south.add("Center", txt_field);

        txt_field.addActionListener(this);
        this.add("Center", txt_area);
        this.add("South", txt_field);
        this.setTitle("EveryChat!");
        this.setSize(300, 500);
        this.setVisible(true);
        txt_field.requestFocusInWindow();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 클라이언트-서버 소켓 연결
        try {
            clientSocket = new Socket("localhost", 3000);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            //out = new PrintWriter(clientSocket.getOutputStream(), true);
            //in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Start to ready Program...");

            // 메세지 수신 스레드
            new Thread(this).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == txt_field) {
            msg = txt_field.getText();

            // 동작 시, 텍스트 필드가 공란이 아니면 메세지 전송
            if (!msg.isEmpty()) {
                try {
                    out.writeObject(msg);               // 서버로 메세지 전송
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                txt_field.setText("");          // 텍스트필드 초기화
                txt_field.setFocusable(true);   // 텍스트필드에 포커스
            }
        }
    }


    @Override
    public void run() {
        // 메세지 수신
        try {
            msg = null;
            while (true) {
                msg = (String) in.readObject();
                System.out.println("수신메세지 | " + msg);
                txt_area.append(" " + msg + "\n");
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        OjmClient oc = new OjmClient();
        oc.inDisplay();
    }
}
