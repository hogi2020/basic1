package ojmTalk.step1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OjmTalk implements ActionListener {
    // 선언부
    JFrame frame = new JFrame();
    String nickName;

    // 버튼 & 필드 & 패널 선언부
    JButton btn_send = new JButton("Send");
    JButton btn_exit = new JButton("Exit");
    JTextField txt_field = new JTextField();
    JTextArea txt_area = new JTextArea();
    JScrollPane jscroll = new JScrollPane(txt_area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_south = new JPanel();


    // 파라미터를 받는 해당 클래스의 생성자 구현
    // 생성자가 구현되면 자동으로 생성되는 디폴트 생성자가 생성되지 않으므로 직접 제공
    public OjmTalk() {}
    public OjmTalk(String nickName) {
        this.nickName = nickName;
    }


    // Talk 실행창 화면 구현
    public void inDisplay() {
        // south 패널 레이아웃 구성
        jp_south.setLayout(new BorderLayout());
        jp_south.add("East", btn_send);
        jp_south.add("Center", txt_field);

        // 실행창 레이아웃 구성
        frame.add("North", btn_exit);
        frame.add("Center", jscroll);
        // frame.add("Center", txt_area);
        frame.add("South", jp_south);

        // 배경색상 적용
        txt_area.setBackground(Color.GRAY);
        btn_send.setBackground(Color.GREEN);
        btn_exit.setBackground(Color.ORANGE);

        // 액션 리스너에 등록
        btn_send.addActionListener(this);
        btn_exit.addActionListener(this);
        txt_field.addActionListener(this);

        // 대화창 업데이트 진행
        frame.setTitle(nickName + "님의 대화창");
        frame.setSize(700, 500);
        frame.setVisible(true);

        // 창 종료 후, 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == txt_field || obj == btn_send) {
            String msg = txt_field.getText();

            txt_area.append(msg+"\n");      // 메세지와 함께 줄바꿈을 Area에 입력
            txt_field.setText("");          // 텍스트 필드창 초기화
            txt_field.requestFocus();       // 텍스트 필드창 포커스
        }
        else if(obj == btn_exit) {
            // 자바 가상머신과 연결된 연결고리를 삭제
            System.exit(0);
        }
    }
}
