package day4.variable;

class K {
    int i;
}

public class KMain {
    public static void main(String[] args) {
        // new 뒤에 나온 K()가 생성자이고, ;은 호출을 의미합니다.
        // 전역변수는 생성자가 있기 때문에 초기화를 생략할 수 있습니다.
        K k = new K();   // 생성자를 호출합니다.
        System.out.println(k.toString());

        // null이 초기값이 되면서 생성된 객체가 없어짐
        // 다음 코드에서 객체를 다시 생성
        k = null;

        // k가 null이 되어 참조할 값이 없어진 상태로
        // NullPointerException이 발생합니다.
        System.out.println(k);
        k = new K();
        System.out.println(k.toString());
    }

}
