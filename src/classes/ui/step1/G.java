package classes.ui.step1;

public class G {
    public static void main(String[] args) {
        // 모든 클래스의 부모가 Object 클래스라서
        // 대입연산자 오른쪽에 더 큰 타입이 오는 것은 불법
        // 그래도 하고싶으면 Casting() 연산자를 쓰면된다.
        String s = "Hello";
        Object obj = null;

        s = (String) obj;
        System.out.println("OverRiding | " + s);

        int i = 1;
        double d = 5.33445;

        i = (int) d;
        System.out.println("int OverRiding | " + i);
    }
}
