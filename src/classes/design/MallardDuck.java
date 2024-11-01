package classes.design;

public class MallardDuck extends Duck {

    // 생성자 안에 메소드 실행
    public MallardDuck() {

        // 선언부와 생성부가 다르다.
        // 호출하는 메소드는 fly() 메소드로 동일하다.
        // 3가지 오리 모두 fly() 호출할 수 있지만 청둥오리는 날고 있어요.
        // 고무오리, 나무오리는 나는 날지 못합니다.
        flyBehavior = new FlyWithWings();   // 타입은 FlyBehavior
    }

    @Override
    public void display() {
        System.out.println("나는 청둥오리 입니다.");
    }
}
