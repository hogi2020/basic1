package jdbc.book;

public class BookVOTest {
    public static void main(String[] args) {
        //BookVO book = new BookVO(1,"책제목5","강감찬","원출판","책소개5","5.png");
        BookVO book = new BookVO();
        book.setB_no(5);
        book.setB_name("책제목5");
        book.setB_author("강감찬");
        book.setB_publish("원출판");
        book.setB_info("책소개5");
        book.setB_img("5.png");
        System.out.println(book.getB_no());//0
        System.out.println(book.getB_name());//null
        System.out.println(book.getB_author());//null
        System.out.println(book.getB_publish());
        System.out.println(book.getB_info());
        System.out.println(book.getB_img());
    }
}
