package day2.variable;

import java.util.Scanner;

// 첫번째 답안지와 두번째 답안지 중에서 어떤 것이 더 좋은거야?
// -> 코드의 양은 늘어나더라도 코드의 복잡도는 증가되지 않도록 작성해보세요!
public class Scanner2Sol1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 명령프롬프트(터미널)에서 사용자가 입력한 값을 읽어볼 수 있습니다.
        System.out.println("0부터 9사이의 숫자를 입력해줘");
        int first = scanner.nextInt();
        System.out.println("첫번째 입력 받은 숫자: " + first);

        System.out.println("한번 더 0부터 9사이의 숫자를 입력해줘");
        int second = scanner.nextInt();
        System.out.println("두번째 입력 받은 숫자: " + second);

        // parseInt는 JVM안에 있는 메소드 입니다.
        System.out.println("두 수의 합은: " + (first + second));

        System.out.println(scanner.next() + scanner.next());
    }
}
