package jdbc.step2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleConnection01 {

    // 1. 드라이버 클래스를 메모리에 올립니다. - 제조사로부터 제공된 클래스다.
    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";

    // 2. 물리적으로 떨어져 있는 오라클 서버의 [드라이버 이름|IP주소|포트번호|SID이름] 업로드
    public static final String _URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";

    // 3. 계정이름
    public static final String _USER = "scott";

    // 4. 비번
    public static final String _PW = "tiger";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    // 생성자 생성
    public OracleConnection01() {}


    /// DeptDTO[] 배열 생성 메소드
    public DeptDTO[] getDeptList() {
        DeptDTO[] depts = null;
        DeptDTO dto = null;

        try {
            // JDBC 드라이버 클래스를 로드하여, 드라이버가 JVM 내에서 사용 가능하게함.
            Class.forName(_DRIVER);
            // DriverManager를 통해 데이터베이스에 연결을 시도합니다.
            // 성공적으로 연결이 이루어지면 conn 객체에 데이터베이스 연결이 저장됨.
            conn = DriverManager.getConnection(_URL, _USER, _PW);
            System.out.println(conn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // SQL문
        String sql = "SELECT deptno, dname, loc FROM dept";

        // SQL Query
        try {
            // Statement 객체 생성(SQL 문을 실행하고, 그 결과를 반환받는 객체)
            stmt = conn.createStatement();
            // executeQuery(sql)는 객체를 통해 SQL 쿼리를 실행하는 메소드
            rs = stmt.executeQuery(sql);

            depts = new DeptDTO[5]; // DTO[] 배열 객체 생성

            int i = 0;              // int i=0  객체 생성
            while (rs.next()) {
                dto = new DeptDTO(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc"));

                depts[i] = dto; // 바뀔때마다 배열에 치환을 한다.
                i += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts; // return 값
    }


    /// 메소드 오버로딩 : 동일 이름의 메소드를 정의할 때, 반드시 파라미터의 갯수이거나 타입이 달라야 함.
    public List<DeptDTO> getDeptList2() {
        List<DeptDTO> deptList = new ArrayList<>();
        DeptDTO dto = null;

        try {
            Class.forName(_DRIVER);
            conn = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println(conn);

        String sql = "SELECT deptno, dname, loc FROM dept";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                dto = new DeptDTO(rs.getInt("deptno")
                                , rs.getString("dname")
                                , rs.getString("loc"));
                deptList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptList;
    }


    public static void main(String[] args) {
        OracleConnection01 oc1 = new OracleConnection01();
        List<DeptDTO> list = oc1.getDeptList2();

        for (DeptDTO dto : list) {
            System.out.println(dto.deptno + " " + dto.dname + " " + dto.loc);
        }

    }

}
