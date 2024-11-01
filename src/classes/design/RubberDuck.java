package classes.design;

// 부모클래스로 Duck을 선언
public class RubberDuck extends Duck {

    // 생성자 선언
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
    }

    // 오버라이드
    @Override
    public void display() {
        System.out.println("I'm a rubber duck");
    }
}
