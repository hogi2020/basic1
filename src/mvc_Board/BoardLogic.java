package mvc_Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardLogic {
    BoardDAO dao = new BoardDAO();

    public BoardVO boardInsert(BoardVO pbvo) {
        System.out.println("Board Insert called");
        BoardVO rbvo = new BoardVO();
        return rbvo;
    }
    public BoardVO boardUpdate(BoardVO pbvo) {
        System.out.println("Board Update called");
        BoardVO rbvo = new BoardVO();
        return rbvo;
    }
    public BoardVO boardDelete(BoardVO pbvo) {
        System.out.println("Board Delete called");
        BoardVO rbvo = new BoardVO();
        return rbvo;
    }

    // 상세보기
    public Map<String, Object> boardDetail(int b_no) {
        System.out.println("Board Detail called : " + b_no);
        Map<String, Object> map = new HashMap<String, Object>();
        map = dao.boardDetail(b_no);
        return map;
    }
    // 전체보기
    public List<Map<String,Object>> boardList(BoardVO pbvo){
        System.out.println("Board List called");
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list = dao.boardList(pbvo);
        System.out.println("BoardLogic boardList() "+list.size());//0
        return list;
    }
}
