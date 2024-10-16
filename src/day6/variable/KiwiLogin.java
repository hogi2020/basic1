package day6.variable;

// 키위톡 로그인 화면 입니다.
// 로그인을 먼저 해야 대화를 할 수 있습니다.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// implements는 인터페이스 구현을 의미합니다.
// ActionListener는 인터페이스로 이벤트가 발생했을 때, 실행할 동작을 정의합니다.
// 버튼을 클릭하거나 특정 작업을 수행할 때 발생한 이벤트 소스를 지원하기 위해 사용합니다.
// actionPerformed는 추상메소드로 정의되어 있습니다.
public class KiwiLogin implements ActionListener {
    // 선언부
    JFrame frame = new JFrame();
    JTextField jtf_nickName = new JTextField("");      // North
    JButton jbtn_login = new JButton("Login");    // South
    JButton jbtn_join = new JButton("회원가입");   // Center

    // 생성자는 반환 타입이 없습니다. 반환 타입이 있다면 메소드 입니다.
    // 디폴트 생성자는 생략할 수 있지만 생성자는 외부의 메소드를 호출할 수 있습니다.
    public KiwiLogin() {
        // initDisplay();
    }

    // 화면그리기 메소드 선언
    public void initDisplay() {
        // 이벤트 소스(login)와 이벤트 핸들러 클래스(Action..를 구현한 클래스)
        jbtn_login.addActionListener(this);
        jtf_nickName.addActionListener(this);
        frame.add("North", jtf_nickName);
        frame.add("South", jbtn_login);
        frame.add("Center", jbtn_join);
        frame.setTitle("키위톡 로그인");
        frame.setSize(300, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // 메인 메소드
    public static void main(String[] args) {
        KiwiLogin login = new KiwiLogin();
        login.initDisplay();

    } //////////// end of main

    // actionPerformed는 callback 메소드 입니다.
    // 개발자가 호출하는 메소드가 아닙니다.
    // 그럼 언제 호출되죠? 이벤트 소스가 이벤트 발생을 느끼면 자동으로 호출해줌
    // 누가 JVM이 언제 이벤트가 감지 되었을 때 개발자를 대신해서 호출해줄께
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object source = e.getSource();
        System.out.printf("%s, %s\n", command, source.toString());

        if ("Login".equals(command)) {
            System.out.println(source == jbtn_login);
            frame.dispose();

        } else if (jtf_nickName == source) {
            System.out.println("사용자가 입력한 닉네임 : " + jtf_nickName.getText());
            String nickName = jtf_nickName.getText();
            jtf_nickName.setText("");
            KiwiTalk kt = new KiwiTalk(nickName);
            kt.initDisplay();
            frame.dispose();

        } else if ("회원가입".equals(command)) {

        }
    }
} //////////// end of KiwiLogin
