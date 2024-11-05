package jdbc.book;
/*
BookApp과 BookDialog사이의 관계가 있다.
static이 아니라 생성자의 파라미터에 this를 넘겨서 두 클래스 관계를 맺는다.
- 입력에서 저장 누르거나 수정에서 저장 눌렀을
INSERT INTO book152 VALUES(1,'자바의정석','도우출판사','도서설명','1.png')
- 반환값이 int이다. 1이면 입력 성공, 0이면 입력 실패
- 입력 성공 일때 화면 흐름도(Flow Chart) BookDialog창은 닫히고
한 건이 추가되었으므로 BookApp화면을 열어서 추가된 건이 반영되도록
부모창의 새로고침 메소드를 호출한다.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookDialog extends JDialog implements ActionListener {
    BookApp ba = null;
    JPanel jp_south = new JPanel();
    JButton jb_save = new JButton("저장");
    JButton jb_close = new JButton("닫기");
    BookDialog(BookApp ba){
        System.out.println(ba);//null출력되니까. 이러면 메소드 호출이 불가함
        this.ba = ba;
        initDisplay();
    }
    public void set(String title, boolean isView){
        this.setTitle(title);//입력 or 수정 or 상세보기
        this.setVisible(isView);
    }
    public void initDisplay(){
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jb_save.addActionListener(this);
        jb_close.addActionListener(this);
        jp_south.add(jb_save);
        jp_south.add(jb_close);
        this.add("South", jp_south);
        this.setSize(500, 700);
        this.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == jb_save){
            ba.refreshData();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookDialog(null);
    }
}
