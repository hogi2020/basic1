package day2.variable;


import javax.swing.JFrame;

// java.lang 패키지 안에 있는 클래스는 JVM이 찾을 수 있지만,
// java.lang이 아닌 패키지에 있는 클래스는 패키지명을 추가해야 합니다.
// 1단계 - main 메소드 안에서만 코딩을 전개하기
// 2단계 - main 메소드 안에 코딩을 가급적 줄여 나가보세요

public class JFrame1 {
    public static void main(String[] args) {
        // JFrame은 창을 관리하는 클래스 입니다.
        JFrame jFrame = new JFrame();

        String title = "전자계산기";
        jFrame.setTitle(title);

        // setSize는 창의 크기를 설정하는 메소드 입니다.
        jFrame.setSize(500, 300);

        // setVisible은 창을 화면에 표시하는 메소드 입니다.
        // 윈도우 창은 메모리를 통해 동작하므로 직접 인터럽트를 설정합니다.
        jFrame.setVisible(true);
    }
}
