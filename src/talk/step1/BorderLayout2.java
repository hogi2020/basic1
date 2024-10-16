package talk.step1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// BorderLayout1은 이벤트 처리를 담당하는 클래스의 역할을 같이 하고 있습니다.
// 여기서는 일부러 분리하여 처리해본다. this 대신에 인스턴스 변수를 씁니다.
// this를 쓸 때와 인스턴스 변수를 쓸 때를 보여주는 거니까 구분할 수 있습니다.
class BorderLayout2Event implements ActionListener{

    // 이벤트 처리를 담당할 클래스를 나누지 않고, 직접 하나의 클래스에 구현하였습니다.
    // actionPerformed라는 메소드를 구현하고 있는 클래스를 이벤트 핸들러 클래스

    // 코드 블록에서 한 부분을 변경했을 때, 이와 관련된 변수가 사용되는 부분을 모두 변경해야 합니다.
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed 호출 성공");
        Object obj = e.getSource();
        JButton btn = (JButton) obj;

        // instanceof는 타입 검사를 위한 논리 연산자 입니다.
        if(obj instanceof JButton) {
            System.out.println("너는 JButton 타입 입니다.");
        }
    }
}

public class BorderLayout2 extends BorderLayout2Event{
    JButton jbtn_north = new JButton("North");
    JButton jbtn_south = new JButton("South");
    JButton jbtn_west = new JButton("West");
    JButton jbtn_east = new JButton("East");
    JButton jbtn_center = new JButton("Center");



    JFrame frame = new JFrame();
    JPanel jp = new JPanel();

    public void initDisplay() {

        // JPanel 속지는 디폴트가 FlowLayout 이라서, 화면 왼쪽에서부터 오른쪽으로 차례대로 배치됨
        // setLayout 메소드를 활용해서 강제로 BorderLayout으로 설정함.
        jp.setLayout(new BorderLayout());

        jp.add("North", jbtn_north);
        jp.add("South", jbtn_south);
        jp.add("West", jbtn_west);
        jp.add("East", jbtn_east);
        jp.add("Center", jbtn_center);

        jbtn_north.addActionListener(this);
        System.out.println("initDisplay 호출 성공");
        jp.setBackground(new Color(8, 40, 196));
        frame.add("Center", jp);
        frame.setSize(400, 300);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BorderLayout2 bi = new BorderLayout2();
        bi.initDisplay();
    }

}
