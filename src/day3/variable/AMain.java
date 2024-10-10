package day3.variable;

public class AMain {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);

        // 변수 a에 A클래스를 재정의하면 위의 값과 다른 값이 됩니다.
        a = new A();
        System.out.println(a);

        // 주소번지는 16진수로 저장됩니다.
        String hex = "A@4e50df2e";
        System.out.println();

        // A 파일을 A_main 파일에서 실행
        String str_addr = a.str("주소는 ", hex);
        System.out.println(str_addr);
        System.out.println("A클래스의 i값은 " + a.i);
    }
}
