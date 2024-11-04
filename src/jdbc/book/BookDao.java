package jdbc.book;

// MVC 패턴 - 가장 Normal 데이터와 관련된 것은 model 계층 입니다.
// CRUD, Select, Insert, Update, Delete

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    /***********************************************************
     * 도서 목록 조회 및 상세조회 구현
     * SELECT b_no, b_name, b_author, b_publish, b_info, b_img
     * FROM book152
     * [WHERE b_no=?] 1건 조회
     *
     * @param bvo
     * @return List<BookVO> : BookVO가 한 건만 담을 수 있다.
     * 한 건이면 bList.size()=1이면 한 건이다.
     * bList.size() > 1이면 여러 건이다.
     ***********************************************************/
    public List<BookVO> getBookList(BookVO bvo) {
        List<BookVO> bList = new ArrayList<>();

        return bList;
    }

    /**********************************************************
     * 도서 삭제 구현하기
     * DELETE FROM book152 WHERE b_no = ?
     *
     * @param bvo or int b_no;
     * @return int가 1이면 삭제 성공, 0이면 실패
     **********************************************************/
    // Delete
    public int bookDelete(BookVO bvo) {
        int result = -1;    // 1이면 삭제 성공, 0이면 삭제 실패, 그래서 초기값을 -1로 함.
        return result;
    }

    /**********************************************************
     * 도서 정보 수정하기
     * UPDATE book152 SET b_name = ?, b_author = ?, b_publish = ? WHERE b_no = ?
     *
     * @param bvo or int b_no;
     * @return int가 1이면 삭제 성공, 0이면 실패
     **********************************************************/
    // Update
    public int bookUpdate(BookVO bvo) {
        int result = -1;    // 1이면 삭제 성공, 0이면 삭제 실패, 그래서 초기값을 -1로 함.
        return result;
    }

    /**********************************************************
     * 도서 입력 구현하기
     * INSERT INTO book152 VALUES (b_no, b_name, b_author, b_publish, b_info, b_img);
     * 
     * @param bvo or int b_no;
     * @return int가 1이면 삭제 성공, 0이면 실패
     **********************************************************/
    // Insert
    public int bookInsert(BookVO bvo) {
        int result = -1;    // 1이면 삭제 성공, 0이면 삭제 실패, 그래서 초기값을 -1로 함.
        return result;
    }
}
