package day1.variable;

public class variable1 {
    // 전역 변수 영역
    // 변수를 선언만 할 수 있지만, 초기화만 분리해서 작성할 수 없습니다.
    // 변수를 선언할 때는 초기화도 같이 진행해야 합니다.
    // 전역변수와 지역변수의 이름은 같습니다.
    // 클래스 안에는 변수와 함수를 선언할 수 있습니다.
    String name = "이성계";

    void a() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        // 지역 변수 영역
        // 메소드 내부에서는 선언과 초기화를 분리해서 작성할 수 있습니다.
        // 자바의 변수는 기본적으로 하나의 값만 가질 수 있습니다.
        // 다만 String[] 배열 선언을 통해 다수의 값을 가질 수 있습니다.
        String name;
        name = "홍길동";
        name = "김유신";
        System.out.println(name);  // 지역변수 호출

        // 전역변수를 굳이 main 메소드 내부에서 호출하려면 클래스를 인스턴스화 하면 됩니다.
        // 클래스가 인스턴스화 되어야 힙 메모리에 클래스가 로딩되어 지역변수 내부에서 사용할 수 있습니다.
        // 그리고 해당 클래스가 소유하고 있는 변수를 호출할 수 있게 됩니다.
        // 참조형 변수는 값이 아니라 메모리 주소를 받습니다.
        // 전역변수는 인스턴스변수명(v1) 다음에 닷트연산자(.)를 통해서 변수를 호출할 수 있습니다.
        variable1 var1 = new variable1();
        System.out.println(var1.name);
    }
}
