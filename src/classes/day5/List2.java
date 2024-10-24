package classes.day5;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class A {

}

public class List2 {

    public static void main(String[] args) {
        List<A> list = new ArrayList<A>();
        System.out.println(list.size());
        A a = new A();
        list.add(a);
        a = new A();
        list.add(a);
        a = new A();
        list.add(a);
        System.out.println(list.size());

        // 자료구조 안에 있는 모듈을 출력할 때는 개선된 for문을 사용하세요.
        // 앞에는 제네릭 타입을 적는다. 뒤에는 자료구조 클래스가 온다.
        for (A a1 : list) {
            System.out.println(list);
        }

        JButton[] btns = new JButton[3];
        btns[0] = new JButton();
        btns[1] = new JButton();
        btns[2] = new JButton();

        for (JButton b : btns) {
            System.out.println(b);
        }
    }
}
