package ojmNotice;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeEdit extends JFrame implements ActionListener {
    NoticeMain main = null;

    // 멤버 변수 생성
    int item_no;
    String item_title = null;
    String item_author = null;
    int item_del;

    // 선언부 | Center-label 패널 인스턴스
    JPanel pnl_edit_create = new JPanel(new GridLayout(3, 2));
    JPanel pnl_edit_delete = new JPanel(new GridLayout(1, 2));
    JLabel label_no = new JLabel("  No.");
    JLabel label_title = new JLabel("  Title");
    JLabel label_author = new JLabel("  Author");
    JLabel label_delete = new JLabel("  삭제할 행 번호");

    // 선언부 | Center-text
    JTextField txt_no = new JTextField();
    JTextField txt_title = new JTextField();
    JTextField txt_author = new JTextField();
    JTextField txt_delete = new JTextField();

    // 선언부 | South 패널 인스턴스
    JPanel pnl_edit_s = new JPanel();
    JButton btn_save = new JButton("Save");
    JButton btn_cancel = new JButton("Cancel");

    public NoticeEdit() {}
    public NoticeEdit(NoticeMain main) {
        this.main = main;
        inDisplay();
    }


    // 에디터창 커스텀 Display
    Container cont = this.getContentPane();
    public void customDisplay(String command) {

        this.setTitle(command);

        if (command.equals("입력") || command.equals("수정")) {
            cont.remove(pnl_edit_delete);
            this.add("Center", pnl_edit_create);
            this.setSize(300, 170);
        }
        else if (command.equals("삭제")) {
            cont.remove(pnl_edit_create);
            this.add("Center", pnl_edit_delete);
            this.setSize(300, 110);
        }
        cont.revalidate();
        cont.repaint();
        this.setVisible(true);
    }


    // 공지사항 Edit창 실행 메소드
    public void inDisplay() {

        // 패널 레이아웃
        pnl_edit_create.add(label_no);
        pnl_edit_create.add(txt_no);
        pnl_edit_create.add(label_title);
        pnl_edit_create.add(txt_title);
        pnl_edit_create.add(label_author);
        pnl_edit_create.add(txt_author);

        pnl_edit_delete.add(label_delete);
        pnl_edit_delete.add(txt_delete);

        pnl_edit_s.add("Center", btn_save);
        pnl_edit_s.add("Center", btn_cancel);

        // 액션 리스너 등록
        btn_save.addActionListener(this);
        btn_cancel.addActionListener(this);

        // 기본 레이아웃
        this.add("South", pnl_edit_s);
        this.setLocationRelativeTo(null);   // 생성창 위치 가운데
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    // 동작 구현 블록
    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        // this.item_no = Integer.parseInt(txt_no.getText());   //null로 인해 오류
        this.item_title = txt_title.getText();
        this.item_author = txt_author.getText();

        // Cancel, Save 버튼 동작 설정
        if (obj == btn_cancel) {
            this.dispose();
        }
        else if (txt_no.getText().isEmpty() && txt_delete.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "공란입니다.");
        }
        else if (obj == btn_save) {
            System.out.println("Save 버튼을 눌렀습니다.");

            if (this.getTitle().equals("입력")) {
                this.item_no = Integer.parseInt(txt_no.getText());
                this.item_title = txt_title.getText();
                this.item_author = txt_author.getText();
                main.addData(item_no, item_title, item_author);
                txt_no.setText("");
                txt_title.setText("");
                txt_author.setText("");
                this.dispose();
            }
            else if (this.getTitle().equals("삭제")) {
                this.item_del = Integer.parseInt(txt_delete.getText());
                try {
                    main.delData(item_del);
                    txt_delete.setText("");
                    this.dispose();
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(this, "삭제할 행이 없습니다. 다시 입력해주세요.");
                }
            }
        }
    }

    // Edit 창 실행 메소드
    public static void main(String[] args) {
        NoticeEdit notE = new NoticeEdit();
        notE.inDisplay();
    }
}
