package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleConnection {
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
    public OracleConnection() {

    }
    public DeptDTO[] getDeptList(){
        DeptDTO[] depts = null;
        DeptDTO dto = null;
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL,_USER,_PW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT deptno, dname, loc FROM dept";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            depts = new DeptDTO[4];
            int i =0;
            while(rs.next()){
                dto = new DeptDTO(rs.getInt("deptno")
                        , rs.getString("dname"), rs.getString("loc"));
                System.out.println(dto);//주소번지가 4번 바뀐다.
                depts[i] = dto;//바뀔때마다 배열에 치환을 한다.
                i = i + 1;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return depts;//depts.length=4
    }

    public DeptDTO[] getDeptList3(){
        DeptDTO[] depts = null;
        DeptDTO dto = null;
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL,_USER,_PW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT deptno, dname, loc FROM dept";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(rs.next());//true
            rs.next();
            while(rs.next()){
                System.out.println(rs.getInt("deptno")+" "
                        +rs.getString("dname")+" "
                        +rs.getString("loc"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return depts;//depts.length=4
    }

    //메소드 오버로딩 : 같은 이름의 메소드를 정의할 때 반드시 파라미터의 갯수 이거나 타입이 달라야 한다.
    public List<DeptDTO> getDeptList2(){
        List<DeptDTO> deptList = new ArrayList<>();
        DeptDTO dto = null;
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL,_USER,_PW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT deptno, dname, loc FROM dept";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                dto = new DeptDTO(rs.getInt("deptno")
                        , rs.getString("dname")
                        , rs.getString("loc"));
                deptList.add(dto);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return deptList;//deptList.size()=4
    }

    public static void main(String[] args) {
        OracleConnection oc = new OracleConnection();
        //DeptDTO[] dto = oc.getDeptList3();
        List<DeptDTO> list = oc.getDeptList2();
        System.out.println(list.get(0) instanceof DeptDTO);//true
        for(int i=0;i<list.size();i++){
            DeptDTO dto = list.get(i);
            System.out.println(dto.deptno+" "
                    +dto.dname+" "
                    +dto.loc);
        }
        /*
        System.out.println(dto);//null출력
        for(DeptDTO d : dto){
            System.out.println(d.deptno+" "+d.dname+" "+d.loc);
        }
        */
    }
}
/*
Java API를 활용하여 오라클 서버에 접속하는 코드를 작성해 봅니다.
1. 오라클 회사가 제공하는 드라이버 클래스(ojdbc6.jar)를 로딩한다.
 */