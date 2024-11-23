package mvc_Board;

import java.util.List;
import java.util.Map;

public class BoardController {
    BoardLogic bLogic = new BoardLogic();

    public static final String _ALL = "selectAll";
    public static final String _ONE = "selectOne";
    public static final String _INS = "insert";
    public static final String _UPD = "update";
    public static final String _DEL = "delete";

    public BoardVO send(BoardVO pbvo){
        BoardVO rpvo = new BoardVO();

        String command = pbvo.getCommand();
        System.out.println("Command : " + command);

        if(_INS.equals(command)) {
            System.out.println("글 등록");
            rpvo = bLogic.boardInsert(pbvo);
        }
        else if(_UPD.equals(command)) {
            System.out.println("글 수정");
            rpvo = bLogic.boardUpdate(pbvo);
        }
        else if(_DEL.equals(command)) {
            System.out.println("글 삭제");
            rpvo = bLogic.boardDelete(pbvo);
        }
        else if(_ONE.equals(command)) {
            System.out.println("글 상세보기");

            Map<String, Object> rmap = bLogic.boardDetail(pbvo.getB_no());
            int b_no = Integer.parseInt(rmap.get("b_no").toString());
            int b_hit = Integer.parseInt(rmap.get("b_hit").toString());

            rpvo.setB_no(b_no);
            rpvo.setB_title(rmap.get("b_title").toString());
            rpvo.setB_writer(rmap.get("b_writer").toString());
            rpvo.setB_content(rmap.get("b_content").toString());
            rpvo.setB_hit(b_hit);
        }
        return rpvo;
    }

    // 전체 조회
    public List<Map<String, Object>> boardListAll(BoardVO pbvo) {
        System.out.println("글 전체보기");
        List<Map<String, Object>> bList = bLogic.boardList(pbvo);
        return bList;
    }
}
