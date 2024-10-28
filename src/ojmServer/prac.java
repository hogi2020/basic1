package ojmServer;

import java.util.concurrent.CopyOnWriteArrayList;

public class prac {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Object> coa = new CopyOnWriteArrayList<>();

        System.out.println(coa);
        for (int i=0; i < 10; i++) {
            System.out.println(i);

            coa.add(i);
        }

        for (int j=0; j<10; j++) {
            coa.remove(0);
        }

        System.out.println(coa);

    }
}
