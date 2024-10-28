package classes.day6;

class Parents3 {
    Parents3() {
        System.out.println("Parent3");
    }
}

class Child3 extends Parents3 {
    Child3(String str) {
        System.out.println(str);
    }
}

public class PC3Main {
    public static void main(String[] args) {

        // 자바에서는 생성부의 이름으로 객체가 생성되므로
        // p가 Parents타입 이더라도 자손의 메서드가 호출됩니다.
        // 이 때 부모의 m메소드는 쉐도우 메소드가 됩니다.
        // 클래스를 다운캐스팅해도 주소번지는 동일합니다.
        Parents3 p = new Child3("hello3");
        System.out.println(p);

        Child3 c = (Child3) p;  // p를 자식 타입으로 다운캐스팅
        System.out.println(c);

        Parents3 p2 = (Parents3) c; // c를 부모 타입으로 업캐스팅
        System.out.println(p2);
    }
}

/*
자손 클래스의 생성자가 호출될 때, 부모클래스의 생성자가 먼저 호출 됩니다.
디폴트 생성자는 파라미터를 따로 정해주지 않아도 되니까. 자동으로 제공할 수 있습니다.
파라미터가 있는 생성자를 호출하더라도 부모의 디폴트 생성자가 호출되었습니다.
 */
