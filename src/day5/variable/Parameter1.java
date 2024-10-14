package day5.variable;

public class Parameter1 {

    public A methodA() {

        // 리턴 타입에도 new를 쓸 수 있습니다.
        return new A();
    }

    public static void main(String[] args) {
        Parameter1 p = new Parameter1();
        System.out.println(p.methodA());
    }
}
