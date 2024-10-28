package classes.day6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
    Connection conn;

    PreparedStatement pstml;

    ResultSet rs;

    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    //물리적으로 떨어져 있는 오라클 서버의 드라이버 이름과 IP 주소, 포트번호, SID이름
    //thin-멀티티어에서 사용함-동시에 많은사람이 접속할 때 방식, oci발식
    public static final String _URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
    //계정이름
    public static final String _USER = "scott";
    //비번
    public static final String _PW = "tiger";

    public DBConnect() {}



}
