package day4.variable;

class Member {
    int age;
    String name;
    String addr;
}

public class MemberMain {
    public static void main(String[] args) {
        Member m1 = new Member();
        m1.age = 20;
        m1.name = "홍길동";
        m1.addr = "서울시 금천구 가산동";

        Member m2 = new Member();
        m2.age = 30;
        m2.name = "강감찬";
        m2.addr = "서울시 마포구 공덕동";

        Member m3 = new Member();
        m3.age = 40;
        m3.name = "이순신";
        m3.addr = "서울시 중구 순화동";

        System.out.println(m1.age + " | " + m1.name + " | " + m1.addr);
        System.out.println(m2.age + " | " + m2.name + " | " + m2.addr);
        System.out.println(m3.age + " | " + m3.name + " | " + m3.addr);

    }
}
