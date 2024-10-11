package day4.variable;

public class K5 {
    // 선언부
    int a;
    int speed;

    // 생성자
    public K5() {
        System.out.println("K5 디폴트 생성자 입니다.");
    }

    // 사용자 정의 메소드
    // static 블록 | 잘 쓰지는 않음...ㅎ
    static {
        // K5가 전시장에 전시되어 있는 상태입니다.
        int speed = 0;
        System.out.println("static 블럭이 호출되었습니다.\n그러면 main()보다 먼저??");
    }  ////////////// end of static 블럭

    public void speedUp() {
        // speed는 지역변수라서 안되고
        speed = speed + 1;

        // a는 전역변수라서 가능합니다.
        a = a + 1;
    }

    // 메인 메소드
    public static void main(String[] args) {
        System.out.println("main() 호출되었습니다.");

        K5 k5 = new K5();
        k5.speedUp();
    }  ////////////// end of main
}  ///////////// end of K5