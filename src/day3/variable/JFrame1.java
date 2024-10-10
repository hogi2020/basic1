package day3.variable;

import javax.swing.*;

public class JFrame1 {
    public static void main(String[] args) {
        // JFrame은 UI를 담당하는 클래스이며,
        // JVM이 정의한 UI에 대한 default 값을 가지고 있습니다.
        // frame은 참조형 변수입니다.
        JFrame frame = new JFrame();

        // 원시형 변수는 호출하면 값, 참조형 변수는 주소번지를 출력합니다.
        System.out.println(frame);
        System.out.println(frame.toString());

        // String 클래스를 인스턴스화하여 호출
        String s = new String("이순신");
        System.out.println(s);
    }
}
