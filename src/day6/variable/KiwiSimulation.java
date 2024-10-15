package day6.variable;

import java.awt.event.ActionListener;

public class KiwiSimulation {
    public static void main(String[] args) {
        KiwiLogin kl = new KiwiLogin();
        kl.frame.setTitle("외부에서 호출한 화면");
        kl.frame.setSize(300, 500);
        kl.frame.setVisible(true);

        // ActionListener는 추상 클래스입니다.
        // ActionListener kl = new KiwiLogin();

        // ()는 생성자이거나, 메소드이거나, 강제형변환자 이거나
        // 부모타입에 자손클래스에 구현된 동일한 메소드가 없어서
        kl.initDisplay();
    }

}
