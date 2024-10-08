package day2.variable;
/*
    1) 변수 선언
    - 변수 선언하기 : 타입(int | String | float | double) 변수명
    - 변수 초기화 하기 : 타입을 선언하지 않고, 초기값을 저장합니다.
    - 자바에서는 변수 선언과 초기화를 분리해서 작성할 수 있습니다.

    2) 주의사항
    - 문법적으로 발생하는 오류와 정상 작동하는 코드에 대해서 익숙해져야 합니다.
    - 컴파일 타입 에러를 잡아야 합니다. = 디버깅을 해야 합니다.
    2-1) syntax 타입 변수명
    - 전역변수에서는 변수 선언과 초기화를 분리할 수 없다. (불가능)
    - 지역변수에서는 변수 선언과 초기화를 분리할 수 있다. (가능)
    - 전역변수에서는 변수 선언만 할 수 없습니다. (불가능)
    - 지역변수에서는 변수 선언만 할 수 있습니다. (가능)

    3) 원시형 타입과 참조형 타입
    - 원시형은 값을 저장, 참조형은 주소를 저장 (RAM | stack, heap)
    - heap은 객체와 변수를 저장하는 메모리 | 값을 저장하는 메모리
    - stack은 실행되는 메소드를 저장하는 메모리 메소드 실행이 끝나면 해제 | 주소를 저장하는 메모리
*/


public class login {
    // 변수, 메소드 선언부
    // 프로그래밍이란? 입력(변수), 처리(메소드 : 기본제공 | 사용자정의), 출력
    // 자바가 기본제공하는 메소드는 JVM에 들어있습니다.

    // 사용자가 정의하는 메소드
    public String loginAction(String mem_id, String mem_pw) {
        return "토마토";
    }

    // 아이디 중복검사 메소드 | 논리연산 타입 boolean
    boolean isIDCheck(boolean mem_id) {
        return false;
    }

    public static void main(String[] args) {
        String mem_id = "tomato";       // 변수 선언
        String mem_pw = "123";          // 변수 선언
        mem_id = "kiwi";                // 덮어씌우기 : OverWhite

        String[] name = {"아", "야", "어", "여"};
        System.out.println(name);       // 배열을 호출하면 주소가 출력
        // [Ljava.lang.String;@b4c966a
        
        System.out.println(name[0]);    // 배열의 값을 출력하면 값이 출력
        // 아
    }
}
