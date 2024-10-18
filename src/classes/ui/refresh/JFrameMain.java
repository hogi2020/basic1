package classes.ui.refresh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMain extends JFrame implements ActionListener {
    // 선언부
    JTextArea jta = new JTextArea();
    JButton refresh = new JButton("Refresh");

    // 생성자
    public JFrameMain() {
        initDisplay();
    }


    // 뷰 메소드
    public void initDisplay() {
        // 아래 문장이 있어야 actionPerformed 메소드가 호출됩니다.
        refresh.addActionListener(this);
        this.add("Center", jta);
        this.add("South", refresh);
        this.setSize(500, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // 메인 메소드
    public static void main(String[] args) {
        // 인스턴스 변수를 선언하지 않고, 생성부만 작성하였습니다.
        // 왜냐하면 initDisplay() 메소드를 호출하려고 인스턴스화를 하는 건데
        // 생성자 안에서 호출하는 방법으로 진행해 보려고 합니다.
        new JFrameMain();
    }

    // 동작 구현
    // 메소드 선언 파에 @Override를 붙인 건 부모클래스나 인터페이스이거나
    // 또는 추상클래스가 정의한 메소드를 재정의하는 경우에 붙입니다.
    // 이 경우 선언부를 절대로 훼손하면 안됩니다.
    // 부모클래스에서 정의된 메소드를 자식클래스에서 재정의하는 것(Override)
    @Override
    public void actionPerformed(ActionEvent e) {
        // 콜백메소드(or Main)내에서는 보통 인스턴스화를 하지 않습니다.
        // 왜냐하면 내가 제어할 수 있는 메서드가 아니라서,
        // 또한 addActionListener가 발동될 때마다 인스턴스화가 계속 일어난다.
        Object obj = e.getSource();
        
        if(obj == refresh) {
            System.out.println("refresh 버튼 클릭!");
            // 처음에 그려진 화면에서 필요없는 컴포넌트 삭제할 때 사용
            Container cont = this.getContentPane();
            
            if(jta != null) {
                cont.remove(jta);
                cont.remove(refresh);
            }

            JPanel1 jp1 = new JPanel1();
            this.add("Center", jp1);
            cont.revalidate();
        }
    }
}
