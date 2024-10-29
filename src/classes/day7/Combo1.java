package classes.day7;

import javax.swing.*;

public class Combo1 extends JFrame {
    JPanel jp_north = new JPanel();
    JComboBox jcb1 = null;
    JComboBox jcb2 = new JComboBox();
    JComboBox jcb3 = new JComboBox(new String[] {"전체", "서울", "경기", "부산"});

    public Combo1() {
        jcb1 = new JComboBox();
        initDisplay();
    }

    // JVM과 App사이의 연결고리가 끊겨서 자원반납이 일어남.
    public void initDisplay() {
        //jcb3 = new JComboBox(new String[] );
        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Combo1();
    }
}
