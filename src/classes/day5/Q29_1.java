package classes.day5;

public class Q29_1 {

    // 배열 기호가 앞에 오면 뒤에 선언된 변수도 배열입니다.
    // 배열 기호가 뒤에 오면 앞에 변수는 배열이고, 뒤에 변수는 배열이 아닙니다.
    // 멤버 변수로 배열을 선언하면 초기화를 생략해도 된다. 그래서 null 출력되었습니다.
    int a1[], b1;
    int []a2, b2;

    public static void main(String[] args) {
        Q29_1 q = new Q29_1();
        System.out.println(q.a1 + " " + q.b1);
        System.out.println(q.a2 + " " + q.b2);
    }
}
