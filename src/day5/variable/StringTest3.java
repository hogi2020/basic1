package day5.variable;

public class StringTest3 {
    public static void main(String[] args) {
        // String은 클래스 중에서 유일하게 new를 사용하지 않고도 객체를 만들 수 있습니다.
        String s1 = "Hello";
        String s2 = "Hello5";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
