package jdbc.step2;

class A {

}

public class AMain {

    public static void main(String[] args) {
        A[] as = new A[5];

        System.out.println(as.length);

        for (A a1 : as) {
            System.out.println(a1);
        }

        A a = new A();
        System.out.println(a);
        as[0] = a;
        System.out.println(as[0]);
        as[0] = new A();
        System.out.println(as[0]);
    }
}
