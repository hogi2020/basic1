package day2.variable;

public class A4 {
    // 선언부
    // 여기에서 선언하면 전역변수 입니다.
    int i;

    // 사용자 정의 메소드 선언


    // main 메소드가 가장 먼저(순서) 실행됩니다.
    // main 메소드가 있으면 .exe 파일로 만들어 실행할 수 있습니다.
    public static void main(String[] args) {
        // 이 안에서 선언되는 변수는 모두 지변 입니다.
        int i;
        i = 1;

        // println 괄호안에 사용된 변수 i는 호출입니다.
        // 에러를 해결하기 위해 변수를 초기화하거나, 상수 값을 입력합니다.
        // 변수이름 앞에 int 타입을 적으면 변수 선언입니다.
        // 단 예외가 있는데, 전역변수는 가능합니다.
        System.out.println(i);    //호출은 사용하기 입니다.

        // 전역변수가 초기화되지 않으면 defult로 0 혹은 null이 입력됩니다.
        // int는 0, String은 null
        A4 a4 = new A4();
        a4.i = 1;

        System.out.println(a4.i);

    }   //////////// end of main
}   //////////// end of A4