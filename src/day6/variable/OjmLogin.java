package day6.variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// OjmLogin 클래스에 이벤트 발생 시, 동작 구현을 위해 ActionListener를 상속
public class OjmLogin implements ActionListener {
    // 선언부
    JFrame frame = new JFrame();
    JButton btn_login = new JButton("Login");
    JButton btn_regi = new JButton("회원가입");
    JTextField txt_nickName = new JTextField("");


    // 로그인 화면 구성 메소드
    public void inDisplay() {
        // 로그인 윈도우 레이아웃
        frame.setTitle("OjmTalk Login");
        frame.setSize(300, 500);
        frame.setVisible(true);

        // 버튼과 텍스트 박스 추가
        frame.add("South", btn_login);
        frame.add("Center", btn_regi);
        frame.add("North", txt_nickName);

        // addActionListener를 통해 JTextField 컴포넌트에 액션 리스너를 추가합니다.
        // this는 현재 클래스가 ActionListener 인터페이스를 구현하고 있다는 것을 나타냅니다.
        btn_login.addActionListener(this);
        btn_regi.addActionListener(this);
        txt_nickName.addActionListener(this);

        // 창 종료 후, 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//////////end of inDisplay


    // 메인 메소드
    public static void main(String[] args) {
        OjmLogin wlogin = new OjmLogin();
        wlogin.inDisplay();
    }//////////end of main


    // 이벤트 동작 구현 블록
    @Override   // @Override는 현재 메서드가 상위 클래스 또는 인터페이스의 메서드를 재정의하고 있다는 것을 나타냅니다.
    public void actionPerformed(ActionEvent e) {
        // 발생 이벤트에 대한 인스턴스 생성
        String command = e.getActionCommand();  // 이벤트에 대한 명령 문자열을 반환
        Object source = e.getSource();          // 이벤트가 발생한 객체 반환

        // 인스턴스 값을 통한 동작 처리
        if ("Login".equals(command)) {
            String nickName = txt_nickName.getText();   // 지역변수 선언 및 초기화

            // 등록된 닉네임 검사 및 후속 진행
            if ("hogi".equals(nickName)) {
                OjmTalk otalk = new OjmTalk(nickName);  // OjmTalk 클래스 가져오기 | Talk 실행창
                otalk.inDisplay();                      // 실행창 실행
                frame.dispose();                        // 실행창 실행 시, Login 화면 닫기
            } else {
                System.out.println(nickName + "은 등록되지 않은 닉네임 입니다.");
            }////////////// end of 닉네임 검사 if문

        } else if ("회원가입".equals(command)) {
            System.out.println("회원가입 버튼을 누르셨습니다.");
        }
    }//////////////end of actionPerformed
}//////////// end of OjmLogin
