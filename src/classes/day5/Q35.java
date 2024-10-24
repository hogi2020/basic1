package classes.day5;

public class Q35 {

    public static void main(String[] args) {
        Object obj = new String("Hello");
        System.out.println(obj);

        // 캐스트 연산자 ()
        String msg = (String) obj;

        obj = new int[3];
        System.out.println(obj);

        // Object 타입에 원시형 타입을 담을 수 있다. - AutoBoxing

        obj = 3;
        System.out.println(obj);
        // 선언부와 생성부가 다른 타입이 올 수 있다.
        // 선언부와 생성부가 다를 떄 다형성이 성립된다.



    }
}
