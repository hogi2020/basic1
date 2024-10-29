package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleConnection2 {
    //드라이버 클래스를 메모리에 올린다. - 제조사로 부터 제공된 클래스다
    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    //물리적으로 떨어져 있는 오라클 서버의 드라이버 이름과 IP 주소, 포트번호, SID이름
    //thin-멀티티어에서 사용함-동시에 많은사람이 접속할 때 방식, oci발식
    public static final String _URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
    //계정이름
    public static final String _USER = "scott";
    //비번
    public static final String _PW = "tiger";
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    public OracleConnection2() {
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL,_USER,_PW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT empno, ename, deptno FROM emp";
        try {
             stmt = con.createStatement();
             rs = stmt.executeQuery(sql);
             while(rs.next()){
                 System.out.println(rs.getInt("empno")+" "
                                          +rs.getString("ename")+" "
                                          +rs.getInt("deptno"));
             }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args) {
        new OracleConnection2();
    }
}
/*
Java API를 활용하여 오라클 서버에 접속하는 코드를 작성해 봅니다.
1. 오라클 회사가 제공하는 드라이버 클래스(ojdbc6.jar)를 로딩한다.
 */