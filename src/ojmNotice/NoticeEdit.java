package ojmNotice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeEdit extends JFrame implements ActionListener {
    Container cont = this.getContentPane();
    TableDataFunction tdf = new TableDataFunction();
    NoticeMain main = null;

    // NoticeMain 인스턴스를 받는 생성자
    public NoticeEdit() {}
    public NoticeEdit(NoticeMain main) {
        this.main = main;
        inDisplay();
    }


    // 멤버 변수 생성
    int item_no;
    int item_del;
    String item_title = null;
    String item_author = null;

    // 선언부 | Center - Panel, label
    JPanel pnl_edit_create = new JPanel(new GridLayout(3, 2));
    JPanel pnl_edit_delete = new JPanel(new GridLayout(1, 2));

    // 선언부 | Center - label, text
    JLabel label_no = new JLabel();
    JLabel label_title = new JLabel("  Title");
    JLabel label_author = new JLabel("  Author");
    JLabel label_delete = new JLabel("  삭제할 행 No. :");
    JTextField txt_no = new JTextField();
    JTextField txt_title = new JTextField();
    JTextField txt_author = new JTextField();
    JTextField txt_delete = new JTextField();

    // 선언부 | South 패널 인스턴스
    JPanel pnl_edit_s = new JPanel();
    JButton btn_save = new JButton("Save");
    JButton btn_cancel = new JButton("Cancel");


    // 공지사항 Edit창 커스텀 메소드
    public void customDisplay(String command) {
        this.setTitle(command);

        // 입력, 수정창 커스텀
        if (command.equals("입력") || command.equals("수정")) {
            cont.remove(pnl_edit_delete);
            this.add("Center", pnl_edit_create);
            this.setSize(300, 170);
            if ((command.equals("입력"))) {
                label_no.setText("  No.");
            } else {
                label_no.setText("  수정할 행 No. :");
            }
        }
        // 삭제창 커스텀
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
        boolean bool;

        // Cancel 버튼 동작 설정
        if (obj == btn_cancel) {
            this.dispose();
        }
        // 공란이 있을 경우 알림창 오픈
        else if (txt_no.getText().isEmpty() && txt_delete.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "공란이 있습니다.");
        }
        // Save 버튼 동작 설정
        else if (obj == btn_save) {
            System.out.println("Save 버튼을 눌렀습니다.");

            // 입력 & 수정 작업 진행
            if (this.getTitle().equals("입력") || this.getTitle().equals("수정")) {
                this.item_no = Integer.parseInt(txt_no.getText());
                this.item_title = txt_title.getText();
                this.item_author = txt_author.getText();

                // 입력 & 수정 작업 메소드 호출 | TableDataFuction
                if (this.getTitle().equals("입력")) {
                    tdf.addData(main.table_model, item_no, item_title, item_author);
                }
                else if (this.getTitle().equals("수정")) {
                    tdf.updData(main.table_model, item_no, item_title, item_author);
                }

                // 창 초기화
                txt_no.setText("");
                txt_title.setText("");
                txt_author.setText("");
                this.dispose();
            }
            // 삭제 작업 진행
            else if (this.getTitle().equals("삭제")) {
                this.item_del = Integer.parseInt(txt_delete.getText());
                bool = tdf.delData(main.table_model, item_del);
                txt_delete.setText("");

                // 삭제할 행이 없을 경우 알림
                if (bool) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "일치하는 번호가 없습니다.");
                }
            }
        }
    }
}