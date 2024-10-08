package day2.variable;

// 문제풀이
// 답안지를 두 가지로 작성해봅니다.
import java.util.Scanner;

public class Scanner2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 명령프롬프트(터미널)에서 사용자가 입력한 값을 읽어볼 수 있습니다.
        System.out.println("0부터 9사이의 숫자를 입력해줘");
        String first = scanner.next();
        System.out.println("첫번째 입력 받은 숫자: " + first);

        System.out.println("한번 더 0부터 9사이의 숫자를 입력해줘");
        String second = scanner.next();
        System.out.println("두번째 입력 받은 숫자: " + second);

        // parseInt는 JVM안에 있는 메소드 입니다.
        int i_first = Integer.parseInt(first);
        int i_second = Integer.parseInt(second);

        System.out.println("두 수의 합은: " + (first + second));
        System.out.println("두 수의 합은: " + (Integer.parseInt(first) + Integer.parseInt(second)));
    }
}
