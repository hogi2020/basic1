package athread.tallk4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageRoom extends JFrame implements ActionListener {
    JPanel jp_center = new JPanel();
    JScrollPane jsp_center = new JScrollPane(jp_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JPanel jp_south = new JPanel();
    JTextField jtf_msg = new JTextField(20);
    JButton jb_msg = new JButton("send");

    int i = 1;  // 멤버변수

    // 생성자
    public MessageRoom() {
        initDisplay();
    }


    // 화면 출력부
    public void initDisplay() {
        jtf_msg.addActionListener(this);
        jb_msg.addActionListener(this);
        jp_center.setLayout(new GridLayout(0, 1));
        jp_south.setLayout(new BorderLayout());
        jp_south.add("Center", jtf_msg);
        jp_south.add("East", jb_msg);

        this.add("Center", jp_center);
        this.add("South", jp_south);
        this.setSize(500, 600);
        this.setVisible(true);
    }


    // 동작 구현
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == jb_msg || obj == jtf_msg) {
            jtf_msg.setText("");
            JPanel jp_msg = new JPanel();

            if(i % 2 == 1) {
                jp_msg.setBackground(Color.green);
                i++;
            } else {
                jp_msg.setBackground(Color.orange);
                i++;
            }

            jp_msg.add(new JLabel("Message : " + jtf_msg.getText()));

            jp_center.add(jp_msg);
            jp_center.revalidate();
            jp_center.repaint();
            jtf_msg.setText("");

            SwingUtilities.invokeLater(
                    () -> jsp_center.getVerticalScrollBar().setValue(jsp_center.getVerticalScrollBar().getMaximum()));
        } ////// end of if (JTextField에 엔터 치거나 전송 버튼 누르면)
    }


    // 메인 메소드
    public static void main(String[] args) {
        new MessageRoom();

    }
}// end of MessageRoom
