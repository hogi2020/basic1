package ojmNotice;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeMain extends JFrame implements ActionListener {
    NoticeEdit ne = new NoticeEdit();

    // 선언부
    JPanel pnl_crud = new JPanel();
    JButton btn_create = new JButton("입력");
    JButton btn_read = new JButton("상세");
    JButton btn_update = new JButton("수정");
    JButton btn_delete = new JButton("삭제");


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

        // 테이블 레이아웃 | Column Width, Column Center, add
        table_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_main.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_main.getColumnModel().getColumn(1).setPreferredWidth(220);
        table_main.getColumnModel().getColumn(2).setPreferredWidth(70);
        table_main.getColumnModel().getColumn(3).setPreferredWidth(135);

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

    // 동작 구현 블록
    @Override
    public void actionPerformed(ActionEvent e) {
        // 액션 인스턴스
        Object obj = e.getSource();

        // Edit창 실행
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
            ne.setTitle(btn_delete.getText());
            ne.setVisible(true);
        }

        // Edit save 버튼 클릭 시, Table에 입력값 저장
        if (ne.save_obj == "Save") {
            System.out.println("Save 버튼이 클릭되었습니다.");
            addData(ne.item_no, ne.item_title, ne.item_author, ne.item_date);
            ne.save_obj = null;
        }
    }


    // 메인 메소드
    public static void main(String[] args) {
        NoticeMain nm = new NoticeMain();
        nm.inDisplay();
    }
}
