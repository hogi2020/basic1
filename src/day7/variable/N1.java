package day7.variable;

public class N1 {
    void methodA() {
        System.out.println("this N1 | " + this);
    }

    public static void main(String[] args) {
        N1 n1 = new N1();
        System.out.println("main N1 | " + n1);
        n1.methodA();

        n1 = null;
        n1 = new N1();
        System.out.println("remain N1 | " + n1);
    }
}
