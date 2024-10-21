package classes.day2;

public class For2 {

    public static void main(String[] args) {
        int hap = 0;

        for(int i=0; i<5; i++) {

            if(i%2 != 0) {
                hap += i;
            }
        }
        System.out.println(hap);
    }
}
