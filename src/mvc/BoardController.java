package mvc;

/*
1. 일반화 / 특정화 관점에서 이해하는 방법
2. 기능의 관점에서 이해하는 방법
- 공통(DBConnectionMgr, Person) 클래스를 만들고
- 그로부터 상속받은 상태와 기능을 재활용해보기
* */

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardController {
    public static final String _ALL = "selectAll";  // 리턴타입 - List<Map<>>, List
    public static final String _ONE = "selectOne";  // Map
    public static final String _INS = "inset";  // int
    public static final String _UPD = "update"; // int
    public static final String _DEL = "delete"; // int


    public BoardVO send(BoardVO pbvo) {
        String command = pbvo.getCommand();

        if(_INS.equals(command)) {      // 등록
            System.out.println("글 등록 메세지 호출 성공");

        }else if(_UPD.equals(command)) {    // 수정
            System.out.println("글 수정 메세지 호출 성공");

        }else if(_DEL.equals(command)) {    // 삭제
            System.out.println("글 삭제 메세지 호출 성공");

        }else if(_ONE.equals(command)) { // 상세보기
            System.out.println("글 상세보기 메세지 호출 성공");

        }

        return new BoardVO();
    }

    // 전체 조회 구현하기
    public List<Map<String, Object>> getBoardList() {
        System.out.println("전체 조회 호출 성공");
        return new ArrayList<>();
    }
}
