package day6.variable;

import javax.swing.JFrame;

public class NullPointer {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s);              // null 출력
        System.out.println(s.toString());   // NullPointerException 발생

        // JVM이 자동으로 찾을 수 있는 패키지는 java.lang 폴더 뿐입니다.
        JFrame jf = null;                   // JFrame 타입의 변수만 선언된 상태
        System.out.println(jf);
        System.out.println(jf.toString());  // NullPointerException 발생
    }
}
