package classes.day6;

class A {
    private int no = 0;

    public int getNo() {
        return no;
    }

    // 초기화 메서드
    public void setNo(int no) {
        this.no = no;   // 파라미터로 넘어오는 값을 멤버변수에 초기화하기
    }
}

public class Amain {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getNo());

        A a1 = new A();
        System.out.println(a1.getNo());

        a1.setNo(10);
        System.out.println(a1.getNo());
    }
}
