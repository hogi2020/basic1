package classes.database;

import model.vo.Notice1030;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Table1 extends JFrame implements ActionListener {
    JButton jbtn_sel = new JButton("조회");
    String[] headers = {"번호","제목","작성자"};
    DefaultTableModel dtm = new DefaultTableModel(headers, 0);
    JTable table = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(table,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    public Table1() {
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
        new Table1();
    }
    public List<Notice1030> getNoticeList(){
        List<Notice1030> nList = new ArrayList<>();
        Notice1030 no = new Notice1030();
        no.setN_no(1);
        no.setN_title("제목1");
        no.setN_writer("나신입");
        nList.add(no);
        no = new Notice1030();
        no.setN_no(2);
        no.setN_title("제목2");
        no.setN_writer("나초보");
        nList.add(no);
        no = new Notice1030();
        no.setN_no(3);
        no.setN_title("제목3");
        no.setN_writer("나일등");
        nList.add(no);
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
