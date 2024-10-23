package ojmServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class OjmClient extends JFrame implements ActionListener {
    Socket socket = null;

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
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == txt_field) {
            txt_area.append("  " + txt_field.getText() + "\n");
            txt_field.setText("");
            txt_field.setFocusable(true);
        }
    }


    public static void main(String[] args) {
        OjmClient oc = new OjmClient();

        // 클라이언트 소켓 정의
        try {
            oc.socket = new Socket("localhost", 3000);
        } catch (IOException e) {e.printStackTrace();}

        oc.inDisplay();
    }
}
