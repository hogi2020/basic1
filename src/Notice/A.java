package Notice;

import javax.swing.*;

public class A {
    public void methodA(JFrame frame) {
        System.out.println("methodA");
        System.out.println(frame);
    }

    public static void main(String[] args) {
        A a = new A();
        a.methodA(null);
    }
}
