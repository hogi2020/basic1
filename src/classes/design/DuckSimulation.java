package classes.design;

public class DuckSimulation {

    public static void main(String[] args) {

        Duck herDuck = new RubberDuck();
        herDuck.flyBehavior.fly();  // 메소드 이름이 같다.

        Duck himDuck = new MallardDuck();
        himDuck.flyBehavior.fly();  // 메소드 이름이 같다.

    }
}