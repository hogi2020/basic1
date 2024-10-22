package classes.day2;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Runtime extends JFrame implements Runnable {

    private JLabel timeLabel;
    private Thread run;

    public Runtime() {
        // JFrame 설정
        setTitle("Real Time Clock");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 시간을 보여줄 JLabel
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel);

        // Thread 생성
        run = new Thread(this);
        run.start(); // run.start()로 시간 갱신 스레드 시작

        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            // 현재 시간 가져오기
            String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());

            // JLabel에 현재 시간 설정
            timeLabel.setText(currentTime);

            // 1초마다 갱신
            try {
                Thread.sleep(1000);  // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 실시간 시계 애플리케이션 실행
        new Runtime();
    }
}
