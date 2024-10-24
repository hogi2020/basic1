package classes.day5;

public class Q27 {

    public static void parse(String str) {
        float f = 1;

        try {
            f = Float.parseFloat(str);
        } catch(NumberFormatException e) {
            f = 0;
        } finally {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        // 실수형을 초기화할 때, f 리터럴을 붙이지 않으면 double이 됩니다.
        Q27.parse("3.14f");
    }
}
