package day6.variable;

import javax.swing.*;

public class KiwiTalk {
    // 선언부
    JFrame frame = new JFrame();

    // 화면 처리부
    public void initDisplay() {
        System.out.println("Kiwi Talk의 initDisplay호출 성공");
        frame.setTitle("Kiwi님의 대화창");
        frame.setSize(700, 400);
        frame.setVisible(true);
    }

    // 메인메소드는 없어도 괜찮습니다. KiwiLogin에서 main 메소드가 실행되므로
}
