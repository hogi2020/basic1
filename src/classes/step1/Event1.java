package classes.step1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event1 extends JFrame implements ActionListener {

    JButton jb = new JButton("전송");
    public void initDisplay() {
        // 내가 정한 메소드 이름임
        this.setSize(500, 350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Event1 e1 = new Event1();
        e1.initDisplay();
    }

    // 개발자가 직접 호출하지 않고, 어떤 상황이 발생하면 JVM이 호출합니다.
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed 호출 성공");
    }
}
