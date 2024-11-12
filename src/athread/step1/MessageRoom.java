package athread.step1;

import javax.swing.*;

public class MessageRoom extends JDialog {
    KiwiClient kc = null;
    MessageRoom(KiwiClient kc){
        this.kc = kc;
    }
}
