package ojmNotice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeEdit extends JFrame implements ActionListener {
    String item_no = null;
    String item_title = null;
    String item_author = null;
    String item_date = null;
    String save_obj = null;

    // 선언부 | 날짜
    Date now = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date_format = formatter.format(now);

    // 선언부 | Center-label 패널 인스턴스
    JPanel pnl_edit_l = new JPanel(new GridLayout(4, 2));
    JLabel label_no = new JLabel("No.");
    JLabel label_title = new JLabel("Title");
    JLabel label_author = new JLabel("Author");
    JLabel label_date = new JLabel("Date");

    // 선언부 | Center-text
    JTextField txt_no = new JTextField();
    JTextField txt_title = new JTextField();
    JTextField txt_author = new JTextField();
    JTextField txt_date = new JTextField(date_format);  // 선언부|날짜의 가공데이터 사용

    // 선언부 | South 패널 인스턴스
    JPanel pnl_edit_s = new JPanel();
    JButton btn_save = new JButton("Save");
    JButton btn_cancel = new JButton("Cancel");

    public NoticeEdit() {
        inDisplay();
    }

    // 공지사항 Edit창 실행 메소드
    public void inDisplay() {

        // 패널 레이아웃
        pnl_edit_l.add(label_no);
        pnl_edit_l.add(txt_no);
        pnl_edit_l.add(label_title);
        pnl_edit_l.add(txt_title);
        pnl_edit_l.add(label_author);
        pnl_edit_l.add(txt_author);
        pnl_edit_l.add(label_date);
        pnl_edit_l.add(txt_date);
        pnl_edit_s.add("Center", btn_save);
        pnl_edit_s.add("Center", btn_cancel);

        // 액션 리스너 등록
        btn_save.addActionListener((this));
        btn_cancel.addActionListener(this);

        // 기본 레이아웃
        this.add("Center", pnl_edit_l);
        this.add("South", pnl_edit_s);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    // 동작 구현 블록
    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        this.item_no = txt_no.getText();
        this.item_title = txt_title.getText();
        this.item_author = txt_author.getText();
        this.item_date = txt_date.getText();

        // Save 버튼 동작 설정
        if (obj == btn_save) {
            System.out.println("Save가 실행됩니다.");

            // 입력란이 공란이면 입력 요청창 활성화
            if (item_no.equals("") || item_title.equals("") || item_author.equals("")) {
                JOptionPane.showMessageDialog(this, "공란이 있습니다.");
                txt_no.requestFocus();
                return;
            } else {
                System.out.println("Save 객체가 할당되었습니다.");
                this.save_obj = btn_save.getText();
            }
        }

        // Cancel 버튼 동작 설정
        if (obj == btn_cancel) {this.dispose();}
    }

    // Edit창 실행 메소드
    public static void main(String[] args) {
        NoticeEdit notE = new NoticeEdit();
        notE.inDisplay();
    }
}
