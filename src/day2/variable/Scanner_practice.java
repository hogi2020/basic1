package day2.variable;

import java.util.Scanner;

public class Scanner_practice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = Integer.parseInt(scanner.next());

        switch (value) {
            case 10:
                System.out.println(value + "는 10입니다.");
                break;
            case 15:
                System.out.println(value + "는 15입니다.");
                break;
            case 20:
                System.out.println(value + "는 20입니다.");
                break;
            case 30:
                System.out.println(value + "는 30입니다.");
                break;
        }
    }
}
