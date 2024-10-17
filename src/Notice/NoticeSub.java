package Notice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeSub extends JFrame {
    JPanel jp_center = new JPanel();
    JPanel jp_south = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");


    public NoticeSub() {
        initDisplay();
    }//end of NoticeSub

    public void initDisplay(){
        jp_center.setBackground(Color.GREEN);
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp_south.add(btn_save);
        jp_south.add(btn_close);

        // this.setTitle("");
        this.add("Center", jp_center);
        this.add("South", jp_south);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//end of initDisplay()

    public static void main(String[] args) {
        NoticeSub ns = new NoticeSub();
        ns.initDisplay();
    }
}