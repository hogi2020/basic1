package classes.design;

public class WoodDuck extends Duck {

    public WoodDuck() {
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("I'm a wood duck");
    }
}
