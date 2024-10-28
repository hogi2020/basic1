package classes.day6;

/*
자바의 특징 - 재사용성과 이식성을 높임
부모타입과 생성자 타입이 다른 경우 - 다형성이 가능함.
p1.n(); | p2.n();
부모 타입에는 없는 메소드를 과연 자식 타입에서 호출할 수 있나?
자손 타입으로 부모에도 있고, 자손에도 있는 메소드를 호출한다면
과연 어떤 메소드가 호출될까요?

오버라이드된 부모클래스의 메서드는 쉐도우 메소드가 됩니다.
부모 타입의 인스턴스 변수라면 Parent가 호출됩니다.
 */


public class Parent4 {
    void m() {
        System.out.println("Parent4.m()");
    }
}


class Child4 extends Parent4 {
    @Override
    void m() {
        System.out.println("Child4.m()");
    }
    void n() {
        System.out.println("Child4.n()");
    }
}


class Child4Main extends Parent4 {
    public static void main(String[] args) {
        Parent4 p4 = new Parent4();
        p4.m();
        // 부모 타입으로 선언된 변수로 자식클래스의 메소드 호출은 불가합니다.
        // p4.n();
        // 상속 받을 때는 자손 클래스를 상속 받는 것이 더 누릴 수 있는 벼눗와 메소드가 많습니다.

        // 인터페이스 변수명 = new 구현체 클래스()
        // 추상클래스 변수명 = new 구현체 클래스()
        // 구현체클래스 변수명 = new 구현체 클래스()
        Parent4 p42 = new Child4();
        // 선언부와 생성부의 타입이 다를 경우, 다형성을 누릴 수 있습니다.
        // 다형성을 통해 자식 클래스에서 오버라이딩된 메서드를 호출할 수 있습니다.
        // p42.n(); // 사용불가.....

    }
}