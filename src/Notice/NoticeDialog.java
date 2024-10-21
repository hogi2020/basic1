package Notice;

import day4.variable.N;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeDialog extends JDialog implements ActionListener {
    NoticeMain nm = null;

    public NoticeDialog() {}
    public NoticeDialog(NoticeMain nm) {
        this.nm = nm;       // 이 코드를 적지 않으면 다른 메소드에서 nm 사용 시 NullPointerException 발생함.
    }

    public void initDisplay() {
        this.setTitle("");
        this.setSize(500, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        NoticeDialog nd = new NoticeDialog();
        nd.initDisplay();
    }
}
