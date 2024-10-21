package classes.day2;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {

    int com = -1;

    // 멤버
    public RandomGame() {
        Random r = new Random();
        com = r.nextInt(10);
    }

    // 단위 테스트와 통합 테스트를 하는 사람
    // 테스트 시나리오를 적어내는 개발자들. - 해본자.
    // 게임 진행하기
    public void goGame() {
        System.out.println("0부터 9사이의 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
    }

    public void nansuPrint(Random r) {
        for(int i=0; i<10; i++) {
            System.out.println(r.nextInt());
        }
    }

    public static void main(String[] args) {
        RandomGame rg = new RandomGame();
        rg.goGame();
    }
}
