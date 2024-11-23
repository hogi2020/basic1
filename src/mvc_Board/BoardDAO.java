package mvc_Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDAO {

    /**
     * 글 삽입하기
     * INSERT INTO mvc_board
     * values(seq_board_no.nextval, '글제목', '작성자', '내용', 0, '2024-11-20')
     *
     * @param pbvo
     * @return int
     */
    public int boardInsert(BoardVO pbvo) {
        System.out.println("Board Insert called");
        int result = -1;
        return result;
    }

    /**
     * 글 수정하기
     * UPDATE mvc_board
     * SET b_title=?, b_content=?, b_date = to_char(sysdate, 'YYYY-MM-DD')
     * WHERE b_no = ?;
     *
     * @param pbvo
     * @return int
     */
    public int boardUpdate(BoardVO pbvo) {
        System.out.println("Board Update called");
        int result = -1;
        return result;
    }

    /**
     * 글 삭제하기
     * DELETE FROM mvc_board WHERE b_no = ?;
     * DELETE FROM mvc_board WHERE b_title = '%'||?||'%';
     *
     * @param pbvo
     * @return int
     */
    public int boardDelete(BoardVO pbvo) {
        System.out.println("Board Delete called");
        int result = -1;
        return result;
    }

    /**
     * 글 상세보기
     * SELECT * FROM mvc_board
     * WHERE b_no = ?;
     *
     * @param pbvo
     * @return Map
     */
    public Map<String, Object> boardDetail(int b_no) {
        System.out.println("Board Detail called");

        Map<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("b_no", b_no);
        rmap.put("b_title", "글제목1");
        rmap.put("b_writer", "강감찬");
        rmap.put("b_content", "글 내용");

        return rmap;
    }

    /**
     * 글 전체보기
     * SELECT * FROM mvc_board
     * WHERE b_title LIKE '%'||?||'%' AND b_no > 5
     *
     * @param pbvo
     * @return List
     */
    public List<Map<String, Object>> boardList(BoardVO pbvo) {
        System.out.println("Board boradList called");
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> rmap = new HashMap<>();
        rmap.put("b_no", 1);
        rmap.put("b_title", "글제목1");
        rmap.put("b_writer", "강감찬");
        list.add(rmap);

        rmap = new HashMap<>();
        rmap.put("b_no", 2);
        rmap.put("b_title", "글제목2");
        rmap.put("b_writer", "이성계");
        list.add(rmap);

        return list;
    }






}
