package sqlConnect;

import sqlConnect.DBConnectionMgr;
import sqlConnect.DeptDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUnitTest {
    DBConnectionMgr dbMgr = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public DBUnitTest() {
        dbMgr = DBConnectionMgr.getInstance();
        conn = dbMgr.getConnection();
        dbTest();
    }
    public void dbTest(){
        System.out.println(conn);
        //select count(deptno) from dept -> 4
        String query = "SELECT deptno, dname FROM dept";
        List<DeptDTO> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(query);
            //executeQuery()는 select일때 사용함, 리턴타입이 ResultSet
            //조회결과를 읽어온다. - 커서가 필요하다.
            //open....cursor....fetch...close
            rs = pstmt.executeQuery();//executeUpdate():int- INSERT, UPDATE, DELETE
            DeptDTO dto = null;
            while(rs.next()){//4바퀴 반복한다.
                dto = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
                list.add(dto);
            }
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new DBUnitTest();
    }
}
