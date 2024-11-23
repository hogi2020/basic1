package mvc_Board;

import lombok.Data;

// getter & setter 단축키 : Alt + Insert
// lombok을 통해 getter & setter 생성
@Data
public class BoardVO {
    // 테이블 구조
    private int b_no;
    private String b_title;
    private String b_writer;
    private String b_content;
    private int b_hit;
    private String b_date;

    // 요청할 DML Command 저장
    private String command;

    // 오라클 서버 DML 요청에 대한 반환값 저장 (성공 1, 실패 0)
    private int result = -1;
}
