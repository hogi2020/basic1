package Notice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeMainTT extends JFrame implements ActionListener {
    // Notice main에서 입력 버튼을 누르면 actionPerformed 메소드가 호출되게하고
    // actionPerformed에서 if문으로 입력 버튼이 클릭되었을 때
    // ns.setTitle(늘려진 버튼에서 라벨을 읽어서 출력되도록 합니다.)
    NoticeSub ns = new NoticeSub();

    //JPanel은 단독으로 창을 출력할 수 없지만 JFrame안에
    //필요한 버튼들을 독립적인 레이아웃으로 배치할 수  있는 속지역할함
    JPanel jp_north = new JPanel();
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    JButton btn_del = new JButton("삭제");


    public void initDisplay(){
        // 이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스를 맴핑하기
        // 이 코드가 있어야 actionPerformed가 출력됩니다.
        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        btn_del.addActionListener(this);

        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp_north.add(btn_ins);
        jp_north.add(btn_upd);
        jp_north.add(btn_det);
        jp_north.add(btn_del);

        this.add("North", jp_north);
        this.setTitle("공지사항 - Main");
        this.setSize(600,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        NoticeMainTT nm = new NoticeMainTT();
        nm.initDisplay();
    }

    // 콜백 메소드의 파라미터 자리에 오는 클래스는 절대로
    // 개발자가 인스턴스화 하지 않습니다.
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object obj = e.getSource();

        // 부모창이 실행되면 자손 창도 일단 메모리에 로딩 됩니다.
        // 다만 화면에만 보이지 않도록 비활성화 합니다.
        if(obj == btn_ins) {
            ns.setTitle(btn_ins.getText());
            ns.setSize(500, 400);
            ns.setVisible(true);
        }
        else if(obj == btn_upd) {
            ns.setTitle(btn_upd.getText());
            ns.setSize(500, 400);
            ns.setVisible(true);
        }
        else if(obj == btn_det) {
            ns.setTitle(btn_det.getText());
            ns.setSize(500, 400);
            ns.setVisible(true);
        }
        else if(obj == btn_del) {
            ns.setTitle(btn_del.getText());
            ns.setSize(500, 400);
            ns.setVisible(true);
        }
    }
}
