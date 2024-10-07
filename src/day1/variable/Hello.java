package day1.variable;
// 참조형 타입(Reference Type)은 class, array, interface 등으로 만들어진 사용자 정의 타입을 의미
// 원시형 타입(Primate Type)은 숫자, 문자, boolean 등을 포함합니다.

// 클래스 선언은 대문자로 시작됩니다.
// 접근제한자가 public이니까.. 누구나 사용해도 괜찮아!
// JVM이 제공하는 class가 있습니다. String, System(Local PC - 윈도우,MAC - OS(Operating System))
// Hello는 변수와 메소드를 소유할 수 있습니다.
// 클래스 명은 Hello이고, Hello class 타입이라고도 합니다.
// 클래스는 .java 파일로 생성하고 컴파일 되면 확장자가 .class로 변환됩니다.
public class Hello {

    // 전역변수 선언 영역


    // 단축키는 main을 활용해서 출력 가능, 메인 메소드의 원형입니다.
    // public - 접근제한자라고 합니다. access modifier
    // void - Return값이 없는 메소드를 호출할 때 사용하는 식별자
    // ()괄호가 있으면 메소드(method), {} 중괄호는 범위(Scope)
    // main 메소드 안에 String[] 문자열 배열이 "args"라는 이름으로 선언되었습니다.
    // main 메소드 안에 String[] args를 선언하는 이유는 외부 입력을 유연하게 처리하기 위함 입니다.
    // 메소드 뒤에 변수 선언이 가능하고, 매개변수(파라미터, 인자)를 입력합니다.
    // 중괄호 안은 선언 입니다. 호출이 아닙니다.
    // 메소드 호출이라는 용어는 메서드를 실행할 때 사용됩니다.
    // 자바에서는 클래스 내부에서 선언된 함수를 메서드라고 부릅니다.
    // 메소드 선언 시, 파라미터 자리에 변수를 선언할 수 있습니다.
    // 파라미터 자리에 선언된 변수는 지역변수 입니다. 즉 String[] args는 지역변수 입니다.
    // 메소드의 파라미터 자리는 변수 선언만 가능하고 변수 초기화는 불가능 합니다.
    // 문법적으로 허용되는 코드와 허용되지 않는 코드를 적어보면 좋을 것 같습니다.
    public static void main(String[] args) {

        // 지역변수 선언 영역
        // 지역변수는 반드시 초기화를 해야 변수 사용이 가능합니다.
        // 변수 선언 전에 변수 호출을 먼저하면 에러가 발생합니다.
        // 변수를 선언할 때는 변수 타입을 선언하고 변수 초기화를 진행합니다.
        // String은 문자열을 담을 수 있는 타입입니다.
        String message;                     // 변수 선언만
        message = "Hello Java\n";           // 변수값 초기화

        // 메인 메소드 안에 선언된 변수는 모두 지역변수 입니다.(위치)
        // 해당 {} 안에서 변수를 사용할 수 있습니다.
        // 단축키 sout를 사용하면 변수 출력이 가능한 코드 출력이 가능합니다.
        // 자바에서는 문자열을 담을 수 있는 클래스를 제공합니다. - String 클래스

        System.out.println(message);        // 초기화된 변수값을 출력
        System.out.println("Hello World");  // 프린트문 안의 값 출력

    }  // end of main method
}  // end of Hello 클래스


/*
입력받은 값을 처리하고 출력하는 것이 프로그래밍 입니다.
api 중에 println(출력)을 배웠습니다. input(입력 - 파라미터)을 배웠습니다.
*/
