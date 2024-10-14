package day5.variable;

public class StringTest2 {
    public static void main(String[] args) {
        String s1 = "Hello";

        System.out.println(s1 + " World");
        System.out.println(s1);     // String은 불변이므로 Hello만 출력됨

        String s2 = "haha";
        s2 = s2.replace('h', 'j');
        System.out.println(s2);
    }
}

/*
String은 연속된 문자열을 표현하는 클래스형 입니다.
클래스는 언제나 참조형
연속된 문자(char, Character)를 저장하는 메모리를 할당합니다.
위 데이터를 처리할 수 있는 각종 메소드 지원함(equals)
-----------------------------------------------------

Java의 String은 immutable 입니다. 즉 변경 불가하다. 원본이 안바뀐다는 의미입니다.

생각해 볼 문제,
SQL의 select문 처럼 문장을 길게 쓸 때 String = ""을 사용하면 메모리 누수가 생기는 건 아닌가?
 */