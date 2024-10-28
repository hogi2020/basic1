package classes.day6;

import java.util.ArrayList;
import java.util.List;
// 자바의 자료구조를 지원하는 컬렉션 프레임워크가 있습니다.
// java.util 입니다.

public class ListMain1 {

    public static void main(String[] args) {
        // 인터페이스는 단톡으로 인스턴스화 할 수 없다.
        // 반드시 구현체 클래스가 필요함.
        // List list = new List();
        // 리스트나 맵 활용해서 대체할 수 있습니다.

        // 제네릭을 포함하지 않은 경우 타입을 맞춰야 함.
        List list2 = new ArrayList();

        // 제네릭을 사용하면 별도로 타입을 맞추지 않아도 됩니다.
        List<String> list3 = new ArrayList<>();

        list2.add(0, "사과");
        list2.add("파인애플");

        for(Object str : list2) {
            System.out.println((String) str);
        }


        // 맨 앞에서 부터 차례대로 채웁니다.
        // add 메소드는 오버 로딩이 적용된 메소드 입니다.
        //
        list3.add("ghgh");
        list3.add("tyty");
        for(String str : list3) {
            System.out.println(str);
        }
    }
}
