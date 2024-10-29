package classes.day7;

import java.util.Vector;


class A {

}

public class List2 {
    public static void main(String[] args) {
        Vector<A> v = new Vector<>();
        v.add(new A());
        v.add(new A());
        v.add(new A());
        v.size();

        Object a1 = v.get(0);
        Object a2 = v.get(1);
        Object a3 = v.get(2);

        System.out.println(a1 == v.get(0));  //true
        System.out.println(a2 == v.get(1));  //true
        System.out.println(a3 == v.get(2));  //true
    }
}
