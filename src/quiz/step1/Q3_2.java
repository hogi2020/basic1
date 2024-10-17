package quiz.step1;

public class Q3_2 {

    public static void main(String[] args) {

        int x = 2;
        int y = ++x;

        if((x++ < y--) & (++x >= ++y)) {
  //    if((x++ < y--) & (++x >= ++y)) {
            System.out.println("참일 때 : x-" + x + ", y-" + y);
        } else {
            System.out.println("참일 때 : x-" + x + ", y-" + y);
        }

    }




}
