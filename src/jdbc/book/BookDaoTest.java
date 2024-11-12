package jdbc.book;

import javax.swing.*;
import java.awt.print.Book;
import java.util.List;

public class BookDaoTest {
    JFrame frame = new JFrame();
    BookDao bookDao = new BookDao();
    public int bookUpdate(BookVO pbvo) {//메소드 오버로딩이다.
        int result = -1;
        pbvo = new BookVO();
        pbvo.setB_name("제목8");
        pbvo.setB_author("저자8");
        pbvo.setB_publish("출판사8");
        pbvo.setB_no(8);
        result = bookDao.bookUpdate(pbvo);
        return result;
    }
    public int bookUpdate(int b_no, String b_name, String b_author, String b_publish) {
        int result = -1;
        return result;
    }
    public int bookDeleteTest(int b_no){
        int result = -1;
        result = bookDao.bookDelete(b_no);
        return result;
    }
    public void getBookListTest(){
        System.out.println("getBookListTest 호출 성공");
        BookVO pbvo = new BookVO();
        pbvo.setB_no(0);
        List<BookVO> bList = bookDao.getBookList(pbvo);
        //b_no가 0이면 where절이 추가되지 않아서 전체 조회가된다.- 4
        //b_no가 1이면 where절이 반영되니까 한 건이 조회 된다. - 1
        //b_no가 2이면 where절이 반영되니까 한 건이 조회 된다. - 1
        //b_no가 3이면 where절이 반영되니까 한 건이 조회 된다. - 1
        //b_no가 4이면 where절이 반영되니까 한 건이 조회 된다. - 0
        System.out.println(bList.size());
        System.out.println(bList);
        //System.out.println(bList.get(1).getB_no());
        //System.out.println(bList.get(2).getB_name());
        //System.out.println(bList.get(3).getB_author());
    }
    /*
    자바에서는 입력,수정,삭제시에 오토커밋이 일어나고 있다.
    그래서 rollback을 하더라도 이전 상태로 돌아갈 수 없다.
     */
    public static void main(String[] args) {
        BookDaoTest bdt = new BookDaoTest();
        int result = -1;
        result = bdt.bookUpdate(null);
        System.out.println("성공 여부 : "+result);
        /*
        result = bdt.bookDeleteTest(4);
        if(result == 1){
            JOptionPane.showMessageDialog(bdt.frame,"삭제성공하였습니다.");
            bdt.getBookListTest();
        }else{
            JOptionPane.showMessageDialog(bdt.frame,"삭제 실패 하였습니다.");
            //return; if문에서 return을 만나면 호출된 메소드를 탈출함.
        }
        result = -1;
        //BookVO pbvo = new BookVO(0,"책제목5","강감찬","원출판","책소개5","5.png");
        BookVO pbvo = new BookVO(0,"책제목5","강감찬","원출판","책소개5","5.png","전체","");
        result = bdt.bookDao.bookInsert(pbvo);
        if(result == 1){
            JOptionPane.showMessageDialog(bdt.frame,"입력 성공하였습니다.");
            bdt.getBookListTest();
        }else{
            JOptionPane.showMessageDialog(bdt.frame,"입력 실패 하였습니다.");
            return;
        }

         */
    }
}
/*
테스트 시나리오를 알고 있다.- 잘하는 사람 - 전체 구조 파악 - 업무 이해
화면이 없이도 파라미터와 리턴타입을 고려하여 테스트가 가능하다.
 */