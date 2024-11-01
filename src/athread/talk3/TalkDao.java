package athread.talk3;


import sqlConnect.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TalkDao {

    DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
    Connection conn = dbMgr.getConnection();

    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;


    public String login(String user_id, String user_pw) {

        String mem_nick = null;
        StringBuilder idCheck = new StringBuilder();
        StringBuilder sql_login = new StringBuilder();
        int status = 2;

        try {
            idCheck.append("select");
            idCheck.append("    NVL((select 1 from dual");
            idCheck.append("        where exist (select mem_name from tomato_member");
            idCheck.append("            where mem_id = ?)");
            idCheck.append("    ), -1) isID");
            idCheck.append("    from dual");    // SQL문 세미클론 입력하면 안되~~~~!
            pstmt1 = conn.prepareStatement(idCheck.toString());
            pstmt1.setString(1, user_id);
            rs = pstmt1.executeQuery();

            if (rs.next()) {
                status = rs.getInt("isID");
            }
            if (status == 1) {
                sql_login.append("select mem_nick from tomato_member");
                sql_login.append("where mem_id=?");
                sql_login.append("and mem_pw=?");
                pstmt2 = conn.prepareStatement(sql_login.toString());
                pstmt2.setString(1, user_id);
                pstmt2.setString(2, user_pw);
                rs = pstmt2.executeQuery();

                if(rs.next()) {
                    mem_nick = rs.getString("mem_nick");
                } else {
                    mem_nick = "비밀번호가 맞지 않습니다.";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mem_nick;
    }
}
