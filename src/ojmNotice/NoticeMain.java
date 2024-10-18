package ojmNotice;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeMain extends JFrame implements ActionListener {
    NoticeEdit edit = new NoticeEdit(this);

    // 선언부
    JPanel pnl_crud = new JPanel();
    JButton btn_create = new JButton("입력");
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


    // 입력 메소드
    public void addData(int no, String title, String author, String date) {
        table_model.addRow(new Object[]{no, title, author, date});
    }
    // 삭제 메소드
    public void delData(int no) {
        table_model.removeRow(no);
    }


    // 동작 구현 블록
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        // 기능별 Edit 창 실행
        if (obj == btn_create) {
            edit.setTitle(btn_create.getText());
            edit.setVisible(true);
        }
        else if (obj == btn_update) {
            edit.setTitle(btn_update.getText());
            edit.setVisible(true);
        }
        else if (obj == btn_delete) {
            edit.setTitle(btn_delete.getText());
            edit.setVisible(true);
        }

    }

    // 메인 메소드
    public static void main(String[] args) {
        NoticeMain nm = new NoticeMain();
        nm.inDisplay();
    }
}
