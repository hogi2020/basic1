package day4.variable;

public class Casting1 {
    public static void main(String[] args) {
        int i = 1;          // 정수형
        double pi = 3.14;   // 실수형

        // ctrl + / 를 사용하면 코드를 주석처리 할 수 있습니다.
        // casting 연산자를 () 형변환 연산자라고 합니다.
        i = (int) pi;
        System.out.println(i);

        // int(정수) < double(실수)
        // 대입연산자 기준으로 오른쪽에 왼쪽보다 더 큰 타입이 오면 안됨.
        // 강제 형변환 연산자를 사용하면 문제를 해결할 수 있다.
        i = (int) 5.1;
        System.out.println(i);


    }
}
