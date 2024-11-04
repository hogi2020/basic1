package jdbc.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor


public class BookVO {
    private int b_no;
    private String b_name;
    private String b_author;
    private String b_publish;
    private String b_info;
    // 여기서 파일 업로드 처리는 하지 않습니다. 그래서 이미지 이름만 저장
    private String b_img;
}
