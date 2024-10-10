package day3.variable;

import javax.swing.*;
import java.awt.*;

public class JFrame2 {
    public static void main(String[] args) {
        // JFrame은 윈도우가 가지고 있는 API를 자바가 호출해서 사용하는 형태입니다.
        JFrame frame = new JFrame();
        Font f = new Font("나눔고딕", Font.BOLD, 35);
        JLabel label = new JLabel("로그인");
        label.setFont(f);
        label.setForeground(Color.BLUE);

        // 인스턴스화를 하면 heap메모리에 JFrame이 상주합니다.
        // 그래서 setSize(), setVisible() 같은 메서드를 호출할 수 있습니다.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) 300.8, 500);    // 화면 크기 설정
        frame.add("South", label);        // 라벨 위치 지정
        frame.setVisible(true);                 // 화면에 출력

    }
}
