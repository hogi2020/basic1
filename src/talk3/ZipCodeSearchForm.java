package talk3;

import sqlConnect.DBConnectionMgr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ZipCodeSearchForm  extends JDialog implements ActionListener {
    //선언부
    String zdo = null;
    //물리적으로 떨어져 있는 db서버와 연결통로 만들기
    Connection con 	= null;
    //위에서 연결되면 쿼리문을 전달할 전령의 역할을 하는 인터페이스 객체 생성하기
    PreparedStatement pstmt 	= null;
    //조회된 결과를 화면에 처리해야 하므로 오라클에 커서를 조작하기 위해 ResultSet추가
    ResultSet rs 		= null;
    JPanel jp_north = new JPanel();
    //insert here
    String zdos[] = {"전체","서울","경기","강원"};
    String zdos2[] = {"전체","부산","전남","대구"};
    Vector<String> vzdos = new Vector<>();//vzdos.size()==>0
    JComboBox jcb_zdo = new JComboBox(zdos);//West
    JComboBox jcb_zdo2 = null;//West
    JTextField jtf_search = new JTextField("동이름을 입력하세요.");//Center
    JButton jbtn_search = new JButton("조회");//East
    String cols[] = {"우편번호","주소"};
    String data[][] = new String[0][2];
    DefaultTableModel dtm_zipcode = new DefaultTableModel(data,cols);
    JTable jtb_zipcode = new JTable(dtm_zipcode);
    JTableHeader jth = jtb_zipcode.getTableHeader();
    JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    String zdos3[] = null;//오라클서버에 들어갔다가나오면 안다.
    //생성자
    public ZipCodeSearchForm() {
        zdos3 = getZdoList();
        jcb_zdo2 = new JComboBox(zdos3);//West
    }
    public String[] getZdoList(){
        DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
        con = dbMgr.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT '전체' zdo FROM dual");
        sql.append(" UNION ALL");
        sql.append(" SELECT zdo ");
        sql.append("FROM (");
       sql.append("         SELECT");
       sql.append("         distinct(zdo) zdo");
       sql.append("         FROM zipcode_t");
       sql.append("         ORDER BY zdo asc)");
       try {
           pstmt = con.prepareStatement(sql.toString());
           rs = pstmt.executeQuery();
           //멀티스레드에서 안전함. 읽기쓰기 속도가 ArrayList보다 느리다.
           Vector<String> v = new Vector<>();//벡터에 있는 내용을 배열에 복제하는 메소드제공
           String imsi = null;
           while(rs.next()){
               imsi = rs.getString("zdo");
               v.add(imsi);
           }
           zdos = new String[v.size()];
           v.copyInto(zdos);
       }catch(Exception e){
            e.printStackTrace();//예외상황이 발생하면 라인번호와 함께 에러메시지를 출력함.
       }
        return zdos;
    }
    //화면처리부
    public void initDisplay() {
        jtb_zipcode.requestFocus();
        jbtn_search.addActionListener(this);
        jtf_search.addActionListener(this);
        jp_north.setLayout(new BorderLayout());
        /*	*/
        //vzdos.copyInto(zdos2);
        for(int x=0;x<zdos2.length;x++) {
            vzdos.add(zdos2[x]);
        }
        for(String s:vzdos) {
            System.out.println("s===>"+s);
        }


        jp_north.add("West",jcb_zdo2);
        jp_north.add("Center",jtf_search);
        jp_north.add("East",jbtn_search);
        this.add("North",jp_north);
        this.add("Center",jsp_zipcode);
        this.setTitle("우편번호 검색");
        this.setSize(430, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ZipCodeSearchForm().initDisplay();
    }
}
