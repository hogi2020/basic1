package quiz.step1;

public class Q3 {
    public static void main(String[] args) {
        int x= 5;
        boolean b1 = true;      // true or "true"
        boolean b2 = false;     // false.boolean 디폴트값은 false 입니다.

        // && 그리고, || 또는, ! 부정,
        // &가 1개일 때와 2개일 때의 차이
        if((x == 4) && !b2) {
            System.out.print("1 ");
        } else {
            System.out.print("2 ");
        }

        if ((b2 = true) && b1) {
            System.out.print("3 ");
        }
    }

}
