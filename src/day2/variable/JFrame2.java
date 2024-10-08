package day2.variable;

import javax.swing.*;

public class JFrame2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        // 창이 닫히면 Runtime 상태를 자동으로 종료합니다.
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String title = "카카오톡";

        jFrame.setTitle(title);
        jFrame.setSize(700, 500);
        jFrame.setVisible(true);
    }
}
