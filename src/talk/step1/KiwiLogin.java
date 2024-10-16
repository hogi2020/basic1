package talk.step1;

// 키위톡 로그인 화면 입니다.
// 로그인을 먼저 해야 대화를 할 수 있습니다.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// implements는 인터페이스 구현을 의미합니다.
// ActionListener는 인터페이스로 이벤트가 발생했을 때, 실행할 동작을 정의합니다.
// 버튼을 클릭하거나 특정 작업을 수행할 때 발생한 이벤트 소스를 지원하기 위해 사용합니다.
// actionPerformed는 추상메소드로 정의되어 있습니다.
public class KiwiLogin implements ActionListener {
    // 선언부
    JFrame frame = new JFrame();

    // JPanel 속지의 배치를 동서남북중앙으로 배치해주는 BorderLayout 설정함
    // setLayout() 메소드가 있음.
    JPanel jp_north = new JPanel();
    // JLabel은 JPanel에 West에 붙이고, JTextField는 JPanel의 Center에 붙임
    JLabel jlb_nickName = new JLabel("닉네임");
    JTextField jtf_nickName = new JTextField("");      // North

    JPanel jp_south = new JPanel();
    JButton jbtn_login = new JButton("Login");    // South
    JButton jbtn_join = new JButton("회원가입");   // Center

    // 생성자는 반환 타입이 없습니다. 반환 타입이 있다면 메소드 입니다.
    // 디폴트 생성자는 생략할 수 있지만 생성자는 외부의 메소드를 호출할 수 있습니다.
    public KiwiLogin() {
        // initDisplay();
    }

    // 화면그리기 메소드 선언
    public void initDisplay() {
        // North 레이아웃
        jp_north.setLayout(new BorderLayout());
        jp_north.setLayout(new GridLayout(1, 2));
        jp_north.add("West", jlb_nickName);
        jp_north.add("Center", jtf_nickName);

        // South 레이아웃
        jp_south.setLayout(new BorderLayout());
        jp_south.setLayout(new GridLayout(1, 2));
        jp_south.add(jbtn_login);
        jp_south.add(jbtn_join);

        // 이벤트 소스(login)와 이벤트 핸들러 클래스(Action..를 구현한 클래스)
        jbtn_login.addActionListener(this);
        jtf_nickName.addActionListener(this);
        frame.add("North", jp_north);
        // frame.add("Center", jbtn_join);
        frame.add("South", jp_south);
        // frame.add("South", jbtn_login);
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

            // 실행창 생성
            String nickName = jtf_nickName.getText();
            jtf_nickName.setText("");
            KiwiTalk kt = new KiwiTalk(nickName);
            kt.initDisplay();

            // 로그인 창 종료
            frame.dispose();

        } else if ("회원가입".equals(command)) {

        }
    }
} //////////// end of KiwiLogin
