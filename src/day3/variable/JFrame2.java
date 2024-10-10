package day3.variable;

import javax.swing.*;
import java.awt.*;

public class JFrame2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Font f = new Font("궁서체", Font.BOLD, 35);
        JLabel label = new JLabel("로그인");
        label.setFont(f);
        label.setForeground(Color.BLUE);

        // 인스턴스화를 하면 heap메모리에 JFrame이 상주합니다.
        // 그래서 setSize(), setVisible() 같은 메서드를 호출할 수 있습니다.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);    // 화면크기 설정
        frame.add("South", label);        // 라벨 위치 지정
        frame.setVisible(true);                 // 화면에 출력
    }
}
