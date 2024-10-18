package classes.ui;

public class B1 {

    // B2클래스에서 파라미터 B1을 갖는 생성자는 없다.
    // 그래서 에러 입니다.
    B2 b2 = new B2(this);   // this는 B1 타입입니다.

    public B1() {
        System.out.println("B1");
    }

    public static void main(String[] args) {
        new B1();
    }

}
