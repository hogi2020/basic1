package classes.day3;

import javax.swing.*;
import java.awt.*;

public class TimeView extends JFrame {
    private Thread run;

    JLabel jlb = new JLabel("현재시간", JLabel.CENTER);
    TimeClient1 tc1 = new TimeClient1(jlb);

    Font f = new Font("굴림체", Font.BOLD, 50);

    public TimeView() {
        initDisplay();
    }

    public void initDisplay() {
        jlb.setFont(f);
        this.add("Center", jlb);
        this.setSize(500, 200);

        run = new Thread(tc1);
        run.start();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TimeView();

    }
}
