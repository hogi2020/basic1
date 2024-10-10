package day3.variable;

public class D {

    static int i;
    int j = 2;

    public static void main(String[] args) {
        System.out.println(i);
        D d = new D();

        // insert here
        System.out.println(d.j);    // 2 -> 3 (13번 라인실행화면)
        d.j = 3;
    }
}
