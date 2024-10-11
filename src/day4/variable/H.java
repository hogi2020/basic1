package day4.variable;

public class H {
    // 전역변수 : 멤버변수
    int i = 1;      // global variable (=member variable)
    public static void main(String[] args) {

        // 인스턴스화를 3번 하였으므로 H타입의 클래스가 3개 생성되었습니다.
        // 3개의 클래스는 heap 메모리에 상주합니다.
        // 전역변수는 인스턴스 변수에 따라서 서로 다른 값을 초기화 할 수 있습니다.
        H h1 = new H();
        h1.i = 2;
        H h2 = new H();
        h2.i = 3;
        H h3 = new H();
        h3.i = 4;
        H h4 = new H();
        h4.i = 5;

        System.out.println(h1 + ",\t" + h1.i);
        System.out.println(h2 + ",\t" + h2.i);
        System.out.println(h3 + ",\t" + h3.i);
        System.out.println(h4 + ",\t" + h4.i);

    }
}
