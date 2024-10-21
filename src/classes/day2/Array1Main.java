package classes.day2;

class Array1 {
    // 초기값은 0이 들어오는데, is[0]=0, is[1]=0, is[2]=0으로 저장됩니다.
    int[] is = new int[3];
}

public class Array1Main {
    Array1 a = new Array1();

    void print1() {
        for(int i=0; i<a.is.length; i++) {
            System.out.println(a.is[i]);    // 0, 0, 0
        }
    }

    public static void main(String[] args) {
        Array1Main a1m = new Array1Main();
        a1m.print1();
    }
}
