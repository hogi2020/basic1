package classes.day3;

import classes.day2.RandomGame;

import java.util.Random;

public class RandomGame1 {
    // 생성자를 최대한 활용하기 - 초기화
    // 채번하기
    // 1) 메소드로 구현하는 방법
    // 2) 생성자에서 하는 방법
    // 재사용성이 우수한 쪽은 어디인가요?
    // 문제제기 - 만일 깊은 복사를 결정했다면, 인스턴스화가 여러번 발생됨.
    // 주소번지가 바뀐다. -> 같은 타입의 클래스가 동시에 heap 영역에 존재함.
    // 그 때마다 새로운 숫자가 채번된다면 정답이 계속 바뀌어도 되는건가요?
    // 권장하는 방법은 채번하기 구현은 사용자 정의 메소드로 처리합니다.
    // 만일 새게임 버튼이 있다면... 가정해보기
    // 새게임 버튼이 눌릴때마다 채번하는 메소드가 호출되어야 한다.
    // 이것이 화면을 그리는 것과 무관하게 독립적으로 처리되어야 하지 않을까?

    public RandomGame1() {
        initDisplay();
    }

    public void initDisplay() {
        System.out.println("Display");
    }

    public void nanSu() {
        System.out.println("nansu");
        Random rand = new Random();
        rand.nextInt(10);       // 채번된 숫자가 정답이다.
    }

    // 여러분은 클래스를 설계할 때, 지역변수로 할지, 멤버변수로 할지 결정할수도 있습니다.
    // 기초인가? 아닐 때로 많았습니다.
//    public String 판정 (int userNumber) {
//        String account = null;
//
//        if(정답 < userNumber) {
//            account = "낮춰라";
//        }
//        else if(정답 > userNumber) {
//            account = "높여라";
//        }
//        else if(정답 == userNumber) {
//            account = "정답";
//        }
//    }

    public static void main(String[] args) {
        // 컴퓨터가 채번한 숫자는 반드시 멤버변수로 해야 합니다.
        RandomGame1 rg = new RandomGame1();
        System.out.println(rg);

        rg = new RandomGame1();
        System.out.println(rg);

        rg = new RandomGame1();
        System.out.println(rg);
    }
}
