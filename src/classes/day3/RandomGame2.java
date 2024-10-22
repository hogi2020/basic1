package classes.day3;

import java.util.Random;
import java.util.Scanner;

public class RandomGame2 {
    int com = -1;

    public RandomGame2() {
        // 채번하는 메소드를 생성자에서 호출하지 않습니다.
        // 왜냐하면 메소드의 재사용성이 떨어짐. 생성자가 호출될 때, 함수도 호출됨
        // 메소드 설계에서는 파라미터 타입과 갯수를 결정할 수 있어야 합니다.
        // nanSu();
    }

    public void init() {        // 초기화, 새게임
        nanSu();
    }

    public void initDisplay() {
        System.out.println("initDisplay");
    }

    public void nanSu() {
        System.out.println("nansu");
        Random rand = new Random();
        // 타입을 붙이면 지역변수, 타입을 빼면 멤버변수
        com = rand.nextInt(10);       // 채번된 숫자가 정답이다.
    }


    // time line을 알고있습니다.
    public String account (int userNumber) {
        String result = null;

        if(com < userNumber) {
            result = "낮춰라";
        }
        else if(com > userNumber) {
            result = "높여라";
        }
        else if(com == userNumber) {
            result = "정답";
        }

        return result;
    }


    public static void main(String[] args) {
        // 컴퓨터가 채번한 숫자는 반드시 멤버변수로 해야 합니다.
        RandomGame2 rg = new RandomGame2();
        System.out.println("0~9사이의 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int userNumber = -1;

        for (int i=0; i<3; i++){
            userNumber = sc.nextInt();
            String result = rg.account(userNumber);
            System.out.println(result);

            if(i==2) {
                System.out.println("3번의 기회를 모두 사용하였습니다. 정답은 "+rg.com+" 입니다.");
            }
        }

    }
}
