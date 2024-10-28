package classes.day6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMain extends JFrame implements ActionListener {
    JDialogMain jdmain = new JDialogMain(this);
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    public JFrameMain() {
        initDisplay();
    }
    public void initDisplay(){
        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        this.setSize(500,400);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JFrameMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
