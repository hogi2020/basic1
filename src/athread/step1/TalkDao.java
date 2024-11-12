package athread.step1;

import com.util.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TalkDao {
    //Spring싱글톤 지원
    DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();//싱글톤패턴
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public int memberInsert(String mem_id, String mem_pw, String nickname, String mem_name, String birthday, String mem_hp){
        int result = -1;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into talk_member(mem_id, mem_pw, nickname, mem_name, birthday, mem_hp) values(?,?,?,?,?,?)");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_id);
            pstmt.setString(2, mem_pw);
            pstmt.setString(3, nickname);
            pstmt.setString(4, mem_name);
            pstmt.setString(5, birthday);
            pstmt.setString(6, mem_hp);
            result = pstmt.executeUpdate();
            if(result == 1){
                System.out.println("정상적으로 처리되었습니다.");
            }else{
                System.out.println("회원가입 실패하였습니다.");
            }
        }catch(SQLException se){//부적합한 식별자, 테이블 또는 뷰가 존재하지 않습니다.
            //쿼리문의 디버깅은 토드와 같은 오라클 전용 프로그램을 사용한다.
            System.out.println(sql.toString());
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return result;
    }//end of memberInsert
    //메소드 설계하기 - 리턴타입과 파라미터 타입을 결정할 수 있다.
    public boolean memIdCheck(String p_id){
        StringBuilder sql = new StringBuilder();
        sql.append("select mem_id from talk_member where mem_id=?");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, p_id);
            rs = pstmt.executeQuery();
            if(rs.next()){//rs.next()가 참이면 입력한 아이디가 존재한다.
                if(rs.getString("mem_id")!=null){
                    return true;//입력 받은 아이디가 존재합니다.
                }else{
                    return false;//입력 받은 아이디가 존재하지 않습니다.
                }
            }
        } catch(SQLException se) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void main(String[] args) {
        TalkDao dao = new TalkDao();
        System.out.println(dao.memIdCheck("apple"));
    }
}
