package day2.variable;

public class A3 {
    // 사용자가 정의한 메소드 입니다.
    // 선언부 - 전역 변수 선언
    // 지변은 아래 메소드가 호출될 때, 결정됩니다. -> call by value
    // 가상머신이 실행하는 순서대로 클론코딩 해보는 것은 동의합니다.
    int hap(int i, int j) {     // 파라미터 자리에 변수 선언이 가능합니다. | 지변이다.
        return i + j;
    }
    
    // main 메소드 > 클래스 객체 생성 > 객체의 메소드 실행 > result 변수 선언 
    // > 클래스 내 메소드 실행 > 메소드 결과 return > result 변수 초기화 > 출력
    public static void main(String[] args) {
        // 인스턴스화된 클래스 객체를 heap 메모리에 로딩(할당)
        // 클래스를 heap 메모리에 로딩할 때는 예약어 new를 사용
        A3 a3 = new A3();

        // 인스턴스화된 클래스 객체명 + 클래스 내 메소드 명 + (파라미터 입력) = 호출
        // 메소드 호출할 때는 세미콜론;
        int result = a3.hap(3, 4);
        System.out.println(result);
    }
}
