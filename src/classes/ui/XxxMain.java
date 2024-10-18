package classes.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XxxMain extends JFrame implements ActionListener {
    XxxSub sub = new XxxSub(this);

    // 선언부
    JPanel jp_north = new JPanel();
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    JButton btn_del = new JButton("삭제");
    JButton btn_sel = new JButton("전체조회");
    JButton btn_exit = new JButton("종료");

    // 테이블 그리기
    String[] cols = {"번호", "제목", "작성자"};
    DefaultTableModel dtm = new DefaultTableModel(cols, 3);
    JTable jtable = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(jtable);


    // 생성자
    public XxxMain() {
        initDisplay();
    }


    // 화면처리부
    public void initDisplay() {
        // 액션 리스너를 this에 등록
        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        btn_del.addActionListener(this);
        btn_sel.addActionListener(this);
        btn_exit.addActionListener(this);

        // 추가
        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp_north.add(btn_ins);
        jp_north.add(btn_upd);
        jp_north.add(btn_det);
        jp_north.add(btn_del);
        jp_north.add(btn_sel);
        jp_north.add(btn_exit);
        this.add("North", jp_north);
        this.add("Center", jsp);

        // 윈도우 처리
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 메인메소드
    public static void main(String[] args) {
        new XxxMain();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        // 입력 버튼 눌렀을 때,
        if(obj == btn_ins) {
            sub.setTitle(btn_ins.getText());
            sub.setSize(400, 600);
            sub.setVisible(false);
        }

        // 수정 버튼 눌렀을 때,
        // 상세보기 버튼 눌렀을 때,
        // 삭제 버튼 눌렀을 때,
        // 전체조회 버튼 눌렀을 때,

    }
}
