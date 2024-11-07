package jdbc.book;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
//그러나 본인의 경우 상황에 따라 사용하지 않고 공부하기
public class BookVO {
    private int b_no;
    private String b_name;//책제목5
    private String b_author;//강감찬
    private String b_publish;//원출판
    private String b_info;//책소개5
    //여기서 파일 업로드 처리는 하지 않습니다. 그래서 이미지 이름만 저장
    private String b_img;//5.png

}
