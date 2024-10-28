package classes.day6;

class Parents1 {
    Parents1() {
        System.out.println("Parent1");
    }
}

class Child1 extends Parents1 {
    Child1(String str) {
        System.out.println(str);
    }
}

public class PCMain {
    public static void main(String[] args) {
        // Parents1 p1 = new Parents1();
        Child1 c1 = new Child1("hogi");
        // Parents1 p2 = new Child1();
    }
}

/*
자손 클래스의 생성자가 호출될 때, 부모클래스의 생성자가 먼저 호출 됩니다.
디폴트 생성자는 파라미터를 따로 정해주지 않아도 되니까. 자동으로 제공할 수 있습니다.
파라미터가 있는 생성자를 호출하더라도 부모의 디폴트 생성자가 호출되었습니다.
 */
