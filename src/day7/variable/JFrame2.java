package day7.variable;

import javax.swing.*;

public class JFrame2 extends JFrame {
    // 화면 구성
    public void initDisplay() {
        // this는 해당 클래스의 인스턴스 객체를 참조하는 키워드 입니다.
        // 그런데 JFrame2는 객체가 아니라 타입이므로 객체처럼 사용할 수 없습니다.
        // 다만 클래스 이름은 정적 메서드나 정적 필드에 접근할 때 사용할 수 있습니다.
        this.setSize(400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame2 f1 = new JFrame2();
        f1.initDisplay();
    }
}
