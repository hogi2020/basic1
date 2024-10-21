package Notice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeMain extends JFrame implements ActionListener {
    // 선언부 - 인스턴스화.this(NoticeMain과 JFrame도 포함됨) 사용
    //NoticeDialog nd = new NoticeDialog(this);

    // 생성자 - 이 클래스에 main()이 있고, 멤버에서 NoticeDialog 인스턴스화 하므로,
    // NoticeDialog() 생성자의 역할이 더 중요합니다.
    // NoticeMain에서 NoticeDialog 클래스를 인스턴스화 하기 때문입니다.
    // 양쪽 클래스 모두가 서로를 필요로 하더라도 순환구조가 아닌 한쪽에서만 인스턴스화를 하고,
    // 생성자 파라미터의 NoticeMain을 넣어서 원본이 전달되도록 합니다.
    // NoticeDialog에서는 절대로 null을 초기화 한 뒤, 생성자의 파라미터(this로 넘어온)로 원본을 초기화하여 사용합니다.
    public NoticeMain() {}


    // 화면 처리 구현
    public void initDisplay() {                 // 웹 어플리케이션이라면, html, React.js, Vue.js, Angular.js
        this.setTitle("Notice");                // 브라우저 인터프리터 역할(JVM)
        this.setSize(500, 600);     //
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
