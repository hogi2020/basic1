package ojmNotice;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class NoticeMain extends JFrame implements ActionListener {
    NoticeEdit ne = new NoticeEdit();

    // 선언부
    JPanel pnl_crud = new JPanel();
    JButton btn_create = new JButton("입력");
    JButton btn_read = new JButton("상세");
    JButton btn_update = new JButton("수정");
    JButton btn_delete = new JButton("삭제");
    JButton btn_repaint = new JButton("새로고침");

    // 선언부 | 테이블 관련 인스턴스
    String[] colName = {"No.", "Title", "Author", "Date"};
    DefaultTableModel table_model = new DefaultTableModel(colName, 0);
    JTable table_main = new JTable(table_model);

    JScrollPane table_scroll = new JScrollPane(table_main);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();


    // 공시자항 메인창 실행 메소드
    public void inDisplay() {

        // 패널 레이아웃
        pnl_crud.add("Center", btn_create);
        pnl_crud.add("Center", btn_read);
        pnl_crud.add("Center", btn_update);
        pnl_crud.add("Center", btn_delete);
        pnl_crud.add("East", btn_repaint);
        btn_repaint.setBackground(Color.ORANGE);

        // 테이블 컬럼 너비 조절 | Column Width
        table_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);   // 자동 창 크기 조절 off
        table_main.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_main.getColumnModel().getColumn(1).setPreferredWidth(220);
        table_main.getColumnModel().getColumn(2).setPreferredWidth(70);
        table_main.getColumnModel().getColumn(3).setPreferredWidth(135);

        // 테이블 가운데 정렬
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_main.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_main.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table_main.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_main.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        this.add(table_scroll, BorderLayout.CENTER);

        // 액션 리스너 등록
        btn_create.addActionListener(this);
        btn_read.addActionListener(this);
        btn_update.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_repaint.addActionListener(this);

        // 기본 레이아웃
        this.add("North", pnl_crud);
        this.setTitle("공지사항");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addData(String no, String title, String author, String date) {
        table_model.addRow(new Object[]{no, title, author, date});
    }
    public void delData(int no) {
        table_model.removeRow(no);
    }

    // 동작 구현 블록
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        // 날짜 갱신
        ne.now = new Date();
        ne.date_format = ne.formatter.format(ne.now);
        ne.txt_date.setText(ne.date_format);

        // 기능별 Edit 창 실행
        if (obj == btn_create) {
            ne.setTitle(btn_create.getText());
            ne.setVisible(true);
        }
        else if (obj == btn_read) {
            ne.setTitle(btn_read.getText());
            ne.setVisible(true);
        }
        else if (obj == btn_update) {
            ne.setTitle(btn_update.getText());
            ne.setVisible(true);
        }
        else if (obj == btn_delete) {
            ne.label_no.setText("삭제할 행 번호(위치):");
            ne.setTitle(btn_delete.getText());
            ne.setVisible(true);
        }

        // Edit save 버튼 클릭 시, Table에 입력값 저장
        if (ne.save_obj == "Save") {
            System.out.println("Save 버튼이 클릭되었습니다.");

            // 기능 동작 구현
            if (ne.getTitle() == "입력") {
                addData(ne.item_no, ne.item_title, ne.item_author, ne.item_date);
            } else if (ne.getTitle() == "삭제") {
                delData(Integer.parseInt(ne.item_no) - 1);
            }
            ne.save_obj = null;
        }
    }

    // 메인 메소드
    public static void main(String[] args) {
        NoticeMain nm = new NoticeMain();
        nm.inDisplay();
    }
}
