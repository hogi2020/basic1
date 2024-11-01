package classes.design;

public abstract class Duck {

    public FlyBehavior flyBehavior;

    public Duck() {
        System.out.println("Duck Constructor");
    }

    public abstract void display();

    public void swimming() {
        System.out.println("나는 물위에 뜹니다.");
    }
}

/*
추상 클래스 & 인터페이스
추상클래스와 인터페이스 모두 단독으로 인스턴스화 할 수 없다.


 */