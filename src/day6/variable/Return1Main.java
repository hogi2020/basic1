package day6.variable;
/*
관전포인트
리턴 타입의 종류 | int double String + Sub1 -> this
 */

class Sub1 {
    // Deprecated 메세지 출력됨 - 앞으로는 더이상 지원하지 않음. API에서 빠질 수 있음
    // 같은 위치인데 static이 있으면 전역변수(global variable)
    // 인스턴스를 하고 사용하는 변수가 멤버변수(member variable)
    int i = 1;          // non-static 변수는 멤버변수
    void methodX() {    // 멤버 메소드이다. 인스턴스.methodX() 호출 가능
        System.out.println(i);
    }   // end of methodX()
}       // end of Sub1

public class Return1Main {

    int methodA() {
        return 1;
    }
    double methodB() {
        // return (double) 2;  // 2가 아니라 2.0이래
        return 2;       // double보다 작은 타입은 자동형전환이 일어남
    }
    String methodC() {
        return "hello";
    }
    Sub1 methodD() {
        return new Sub1();
    }
    Sub1 methodE() {
        Sub1 sub = new Sub1();
        return sub;
    }

    public static void main(String[] args) {
        // insert here
        Return1Main m = new Return1Main();
        Sub1 sub1 = m.methodD();
        Sub1 sub2 = m.methodE();

        System.out.println(sub1.i);
        System.out.println(sub2.i);

        // 같은 타입이지만, 서로 다른 객체라서 똑같이 i를 출력하더라도
        // 어떤 때는 1을 어떤 때는 10을 출력할 수 있습니다.
        // 다른 사람들의 주문을 구분할 수 있고 서로 다른 상태값을 유지하는 것이다.
        // 조건문 실행문이 1줄이면, {} 중괄호를 생략할 수 있습니다.
        if (sub1 == sub2) System.out.println("주소번지가 같습니다.");
        else System.out.println("주소번지가 다릅니다.");

        if (sub1.i == sub2.i) System.out.println("값이 동일합니다.");
        else System.out.println("값이 상이합니다.");
    }
}
