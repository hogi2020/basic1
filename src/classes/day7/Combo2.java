package classes.day7;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Combo2 extends JFrame implements ItemListener {
    JComboBox combo = new JComboBox(new String[]{"전체"});
    JMenuBar jmb = new JMenuBar();
    JMenu jm = new JMenu("Edit");
    JMenuItem jmi_db = new JMenuItem("DB테스트");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_det = new JMenuItem("상세보기");
    JMenuItem jmi_del = new JMenuItem("삭제");
    JSeparator jsep = new JSeparator();
    JMenuItem jmi_exit = new JMenuItem("종료");
    public Combo2(){
        initDisplay();
    }
    public void initDisplay(){
        jm.add(jmi_db);
        jm.add(jmi_ins);
        jm.add(jmi_upd);
        jm.add(jmi_det);
        jm.add(jmi_del);
        jm.add(jsep);
        jm.add(jmi_exit);
        jmb.add(jm);
        this.setJMenuBar(jmb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add("North", combo);
        this.setSize(500,300);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Combo2();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
