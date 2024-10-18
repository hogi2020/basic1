package classes.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XxxSub extends JDialog implements ActionListener {
    XxxMain main = null;

    // 선언부 | 남쪽에 붙일 버튼과 중앙에 들어올 입력폼을 구분하는 선으로 활용함
    JScrollPane jsp = new JScrollPane();
    JPanel jp_south = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");


    // 생성자 | 리턴타입이 있으면 생성자가 아니라 메소드가 됩니다.
    public XxxSub() {};
    public XxxSub(XxxMain main) {
        // 멤버변수
        // this는 Sub클래스의 인스턴스 입니다.
        // this.main은 Sub클래스 안에서 null로 선언된 Main 타입의 변수 입니다.
        // = main은 Main 클래스로부터 할당받은 주소번지를 Sub클래스의 main에 주소번지를 할당하는 것 입니다.
        this.main = main;   // XxxSub.main = XxxMain 클래스 주소
        initDisplay();
    }


    // 화면처리부
    public void initDisplay() {
        btn_save.addActionListener(this);
        btn_close.addActionListener(this);

        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp_south.add(btn_save);
        jp_south.add(btn_close);

        this.add("South", jp_south);
        this.add("Center", jsp);
        // this.setSize(400, 500);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    // 메인메소드 쓰면 안됨
    public static void main(String[] args) {
        new XxxSub(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        // 공지사항 글을 작성한 후 저장 버튼 누르면 DB에 저장하고
        // 현재 창은 닫고 부모창의 전체조회가 처리되도록 합니다.
        // 왜냐하면 새로운 글이 입력되었으니까. 추가된 글까지 출력하기
        if(obj == btn_save) {
            main.xxxList();
            this.dispose();
        }
        else if(obj == btn_close) {
            this.dispose();
        }

    }
}
