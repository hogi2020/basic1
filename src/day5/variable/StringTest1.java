package day5.variable;

public class StringTest1 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;

        String s3 = new String("Hello");
        String s4 = new String("Hello");

        // String 객체를 만들 때, new를 사용하지 않으면
        // 기존에 같은 문자열이 메모리에 있는지 없는지 체크하고,
        // 만일 있다면 새로운 문자열을 생성하는 것이 아니라 기존에 주소번지를 갖는다.
        // (유일하게 원시형처럼 초기화 가능.)
        System.out.println("Answer1 | " + (s1 == s2));
        System.out.println("Answer2 | " + (s3 == s4));

        // s1이 가리키는 "Hello" 문자열과 s2가 가리키는 "Hello" 문자열 값이 같은지 확인
        System.out.println("Answer3 | " + s1.equals(s2));
        System.out.println("Answer4 | " + s3.equals(s4));

        // 주소번지는 다르다.
        System.out.println("Answer5 | " + (s1 == s4));
        System.out.println("Answer6 | " + (s2 == s4));
    }
}
