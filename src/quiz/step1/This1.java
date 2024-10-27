package quiz.step1;


class M {
    This1 this1 = null;
    // 인스턴스화를 멤버위치에서 하는 것은 위험하다.
    // This1 this2 = new THis1(); // 핑퐁 왔다갔다한다. 재귀호출
    // This1 this2 = new This1();

    public M(This1 this1) {
        System.out.println("M1: 멤버" + this.this1);
        this.this1 = this1;
        System.out.println(this.this1);
    }
}

public class This1 {
    M m = new M(this);

    public static void main(String[] args) {
        This1 t1 = new This1();
        System.out.println(t1);
        t1 = new This1();
        System.out.println(t1);
    }
}
