package classes.database;

import model.vo.Notice1030;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Table2 extends JFrame implements ActionListener {
    JButton jbtn_sel = new JButton("조회");
    String[] headers = {"번호","제목","작성자"};
    DefaultTableModel dtm = new DefaultTableModel(headers, 0);
    JTable table = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(table,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    public Table2() {
        initDisplay();
    }
    public void initDisplay(){
        jbtn_sel.addActionListener(this);
        this.add("North", jbtn_sel);
        this.add("Center", jsp);
        this.setSize(500,400);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Table2();
    }
    public List<Notice1030> getNoticeList(){
        List<Notice1030> nList = new ArrayList<>();

        com.util.DBConnectionMgr dbMgr = com.util.DBConnectionMgr.getInstance();
        Connection conn = dbMgr.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        System.out.println(conn);

        StringBuilder sql = new StringBuilder();
        sql.append("select n_no, n_title, n_writer from Notice1030");

        try {
            // 객체 주입 후, 파라미터에 String 타입이 들어감. (StringBuilder는 타입이 달라서 못 들어감)
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();

            Notice1030 nvo = null;
            while(rs.next()) {
                nvo = new Notice1030();
                nvo.setN_no(rs.getInt("n_no"));
                nvo.setN_title(rs.getString("n_title"));
                nvo.setN_writer(rs.getString("n_writer"));
                nList.add(nvo);
            }
        } catch(SQLException e) {
            System.out.println(sql.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return nList;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == jbtn_sel){
            List<Notice1030> nList = getNoticeList();
            for(int i=0;i<nList.size();i++){
                Notice1030 nvo = nList.get(i);
                Vector<Object> oneRow = new Vector<>();
                oneRow.add(nvo.getN_no());
                oneRow.add(nvo.getN_title());
                oneRow.add(nvo.getN_writer());
                dtm.addRow(oneRow);
            }
        }
    }
}
