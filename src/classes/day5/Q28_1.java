package classes.day5;

public class Q28_1 {
    int i = 1;
    Q28_1 q = null;

    void m(int i, Q28_1 q) {
        System.out.println(q);

        q = new Q28_1();
        System.out.println(q);
        System.out.println(this.q);
        System.out.println(this);
    }

    public static void main(String[] args) {
        Q28_1 q = new Q28_1();
        System.out.println(q);
        q.m(1, q);
    }
}
