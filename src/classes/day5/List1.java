package classes.day5;

import java.util.ArrayList;
import java.util.List;

public class List1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list instanceof ArrayList<String>);

        // 다형성 클래스 정의
        List<String> list2 = new ArrayList<>();
        System.out.println(list2 instanceof ArrayList<String>);
        System.out.println(list2 instanceof List<String>);

        // List는 인터페이스이며, 구현체 클래스를 가지고 있습니다.
        // 인터페이스는 추상 메서드만 가지고 있어서, 오른쪽에 사용이 불가합니다.
        // 반드시 구현체 클래스가 추상메서드를 구현해야 올 수 있습니다. // 벡터도 올 수 있음.
    }
}
