package day5.variable;

import java.util.Scanner;

public class StringTest5 {
    public static void main(String[] args) {
        String mem_id = "tomato";
        String user_id = null;

        // 파라미터에 System.in은 로컬 컴퓨터에서 입력받은 값을 기다리게 됩니다.
        Scanner sc = new Scanner(System.in);    //  Scanner 객체가 생성됩니다.
        System.out.println("아이디를 입력하세요!");

        user_id = sc.nextLine();        // sc.nextLine()이 실행되면 입력 대기 상태로 들어갑니다.
        System.out.println("사용자가 입력한 아이디는 " + user_id + " 입니다.");

        /*
        문자열 변수에 저장되어 있는 건 값이 아닌 메모리 주소입니다.
        따라서 == 가 비교하는 대상은 주소를 비교하고, 그 주소에 있는 실제값을 비교하는 것이 아닙니다.
         */
        if (mem_id == user_id) {
            // 조건이 참일 때 실행되는 블록입니다.
            System.out.println("주소번지가 같습니다.");
        } else {
            // 조건이 참이 아닐 때 실행되는 블록입니다.
            System.out.println("주소번지가 다릅니다.");
        }
    }
}
