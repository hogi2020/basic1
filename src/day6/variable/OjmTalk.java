package day6.variable;

import javax.swing.*;

public class OjmTalk {
    // 선언부
    JFrame frame = new JFrame();
    String nickName;


    // 파라미터를 받는 해당 클래스의 생성자 구현
    // 생성자가 구현되면 자동으로 생성되는 디폴트 생성자가 생성되지 않으므로 직접 제공
    public OjmTalk() {}
    public OjmTalk(String nickName) {
        this.nickName = nickName;
    }

    // Talk 실행창 화면 구현
    public void inDisplay() {
        frame.setTitle(nickName + "님의 대화창");
        frame.setSize(700, 500);
        frame.setVisible(true);

        // 창 종료 후, 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
