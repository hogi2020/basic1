package day3.variable;

public class F {

    static int x = 1;

    public static void main(String[] args) {
        System.out.println(x);

        F f = new F();

        // 같은 변수에 대해서 초기화를 여러번 할 수 있다.
        // 변수는 한 번에 하나만 담을 수 있다.
        // 전역변수는 인스턴스 변수, 변수명으로 호출이 가능하다.
        // 전역변수는 인스턴스 변수, 변수명으로 초기화를 다시 할 수도 있다.
        f.x = 10;
        System.out.println(f.x);
        f.x = 20;
        System.out.println(f.x);
    }
}
