package jdbc.book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookApp extends JFrame implements ActionListener {

    // 생성자
    public BookApp() {}

    // 윈도우 레이아웃
    public void initDisplay() {

    }

    // 동작 처리
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // 메인 메소드
    public static void main(String[] args) {

    }
}



/*
메뉴바를 추가하기
툴바 추가하기

같은 메뉴를 메뉴바와 툴바에 모두 추가하여서 메소드에 대한 재사용성 구현 실습
같은 메뉴
이벤트 처리를 담당하는 클래스로 설계하고 - ActionListener
삭제는 BookApp.java 처리한다.
상세조회, 수정, 입력은 BookDialog.java 처리합니다.
이 중에서 수정하기와 상세조회는 오라클 서버를 경유해야 합니다.
왜냐하면 기존에 있는 정보를 수정하거나 상세조회하는 것이므로 조회 결과를 화면에 출력해야 한다.
입력은 오라클 서버를 경유하지 않고, BookDialog 화면에서 새로 입력받은 정보를 오라클 서버에 입력하는 것이다.
(INSERT 문)
BookDialog.java에서 BookDao의 메소드를 호출할 떄 사용자가 입력한 값을
파라미터로 넘겨야 하는데 컬럼의 갯수만큼 넘기는 것보다는 BookVO 주소번지를
하나 넘겨서 그 안에 선언된 멤버변수값을 insert문에 넣는 것이 더 나은 방법입니다.
BookDialog에서는 BookDao의 인스턴스화를 해야합니다.
BookDialog에서 BookDao의 메소드를 호출해야 합니다.

jar 파일은 프로젝트 스트럭처에 넣습니다.
JDBC API(레거시 시스템) - 반복되는 코드가 많다.
DB 연동하기 실습 & CRUD 구현하기 & myBatis(CRUD 중점) - Spring(Hibernate)
 */
