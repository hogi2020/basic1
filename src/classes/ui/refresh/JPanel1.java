package classes.ui.refresh;

import javax.swing.*;
import java.awt.*;

// JPanel은 JFrame처럼 윈도우창을 제공하지 않습니다.
public class JPanel1 extends JPanel {

    // 생성자
    public JPanel1() {
        System.out.println("JPanel1의 디폴트 생성자 호출");
        initDisplay();
    }

    public void initDisplay() {
        this.setBackground(Color.GREEN);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JPanel1();
    }
}
