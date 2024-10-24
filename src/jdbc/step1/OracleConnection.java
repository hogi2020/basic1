//package jdbc.step1;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

//public class OracleConnection {
//    // _DRIVER는 패키지 경로를 의미합니다.
//    // 드라이버 클래스는 제조사에서 제공된 클래스 입니다.
//    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
//
//    // 물리적으로 떨어져있는 오라클 서버의 /드라이버 이름/thin 방식/IP 주소/포트번호/SID 이름;
//    // 동시에 많은 사람이 접속할 때, 사용하는 방식
//    public static final String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
//    // 계정이름
//    public static final String _USER = "scott";
//    // 패스워드
//    public static final String _PW = "tiger";
//
//    // 생성자
//    Connection conn = null;
//    Statement stmt = null;
//    ResultSet rs = null;
//    public OracleConnection() {
//        try {
//            Class.forName(_DRIVER);
//            System.out.println("접속 성공");
//            conn = DriverManager.getConnection(_URL, _USER, _PW);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(conn);
//        String sql = "SELECT deptno, dname, loc FROM dept";
//
//        try {
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//            while(rs.next()) {
//                System.out.println(rs.getInt("deptno")+" "
//                        + rs.getInt("deptno")+" "
//                        + rs.getInt("deptno")+" "
//                );
//            };
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 메인 메소드
//    public static void main(String[] args) {
//        new OracleConnection();
//    }
//}


/*
Java API를 활용하여, 오라클 서버에 접속하는 코드를 작성해봅시다. (Test)
1. 오라클 회사가 제공하는 드라이버 클래스(ojdbc6.jar)를 로딩합니다.
2.

드라이버 위치
D:\workSpaceJava\basic1\src\jdbc\lib\ojdbc6\oracle\jdbc\driver [OracleDriver.class]
 */