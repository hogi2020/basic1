package classes.day5;

public class Q28 {

    int x = 12;
    public void method(int x) {
        System.out.println(this.x);

        this.x = this.x + x;

        System.out.println(x);
        System.out.println(this.x);
    }

    // this는 static 메소드에서 사용할 수 없습니다.
    public static void main(String[] args) {
        Q28 q = new Q28();
        q.x = 10;
        q.method(5);
    }
}
