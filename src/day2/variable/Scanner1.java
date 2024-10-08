package day2.variable;

import java.util.Scanner;

public class Scanner1 {

    String next() {
        return "안녕";
    }
    int nextInt() {
        return 1;
    }

    public static void main(String[] args) {

        // 외부 입력값을 받는 Scanner
        Scanner scanner = new Scanner(System.in);

        // next()의 return 타입은 String 입니다.
        // 만약 정수형으로 변환하려면 Integer.parseInt를 사용해야 합니다.
        String first = scanner.next();
        int number = Integer.parseInt(first);
        System.out.println(number);

        // 클래스를 인스턴스화해서 클래스의 메소드를 호출하였습니다.
        Scanner1 scanner1 = new Scanner1();
        int a = scanner1.nextInt();
        System.out.println("안녕");       // 문자열 상수를 사용
        System.out.println(a);           // 변수를 사용
    }
}
