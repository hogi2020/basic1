package day5.variable;

import java.util.Scanner;

public class StringTest5 {
    public static void main(String[] args) {
        // 레퍼런스 변수에 null값을 주면 가비지컬렉션에서 객체를 없애주고, 값은 0으로 변경됩니다.
        String mem_id = "tomato";
        String user_id = null;

        // 파라미터에 System.in은 로컬 컴퓨터에서 입력받은 값을 기다리게 됩니다.
        Scanner sc = new Scanner(System.in);    //  Scanner 객체가 생성됩니다.
        System.out.println("아이디를 입력하세요!");
        // sc.nextLine()이 실행되면 입력 대기 상태로 들어갑니다.
        // 로컬 컴퓨터에 문자열을 입력하면 String 객체가 생성됩니다.
        user_id = sc.nextLine();

        /*
        문자열 변수에 저장되어 있는 건 값이 아닌 메모리 주소입니다.
        따라서 == 가 비교하는 대상은 주소를 비교하고, 그 주소에 있는 실제값을 비교하는 것이 아닙니다.
         */
        String msg = (mem_id.equals(user_id)) ? "주소번지가 같습니다.":"주소번지가 다릅니다.";
        System.out.println(msg);
    }
}
