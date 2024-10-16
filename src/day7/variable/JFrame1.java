package day7.variable;

import javax.swing.*;
import java.util.Arrays;

public class JFrame1 {
    // 선언부
    JFrame frame = null;

    // 화면 구성
    public void initDisplay() {
        frame = new JFrame();
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame1 f1 = new JFrame1();
        f1.initDisplay();
    }
}
