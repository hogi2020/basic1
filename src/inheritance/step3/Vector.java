package inheritance.step3;

public class Vector {

    private int x;  // 0
    private int y;  // 0

    // 생성자 호출을 통해서 멤버변수의 초기화가 가능함.
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int setX(int x) {
        return this.x = x;
    }

    public int setY(int y) {
        return this.y = y;
    }
}
