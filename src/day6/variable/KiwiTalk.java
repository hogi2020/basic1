package day6.variable;

import javax.swing.*;

public class KiwiTalk {
    // 선언부
    String nickName = null;
    JFrame frame = new JFrame();

    // 파라미터가 없는 생성자를 디폴트 생성자라고 합니다.
    // 디폴트 생성자는 JVM이 대신 제공해줍니다.
    public KiwiTalk() {}
    public KiwiTalk(String nickName){   //nickName = apple
        System.out.println(nickName);   //지변 - apple
        this.nickName = nickName;
        System.out.println(this.nickName);      // 멤버변수 - null
    }

    // 화면 처리부
    public void initDisplay() {
        System.out.println("Kiwi Talk의 initDisplay호출 성공");
        frame.setTitle(nickName + "님의 대화창");
        frame.setSize(700, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 메인메소드는 없어도 괜찮습니다. KiwiLogin에서 main 메소드가 실행되므로
}
