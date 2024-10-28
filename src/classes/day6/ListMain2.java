package classes.day6;

import java.util.ArrayList;
import java.util.List;

public class ListMain2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.size());

        list.add("A");      // list.get(0)-A
        list.add("B");      // list.get(1)-B
        list.add("C");      // list.get(2)-C
        System.out.println(list.size());

        boolean isOk = list.remove("B");
        System.out.println(isOk);
        System.out.println(list);

        String result = list.remove(0);
        System.out.println(result);
        System.out.println(list.isEmpty());
    }
}
