package classes.day2;

import java.util.Random;

public class Array2 {
    int randNum;
    int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        Array2 a2 = new Array2();
        Random rand = new Random();

        for(int i=0; i<3; i++) {
            a2.randNum = rand.nextInt(20);

            for(int num : a2.nums) {
                if(num == a2.randNum) {
                    System.out.println(a2.randNum + "은 배열에 포함된 숫자입니다.");
                }
            }
        }
    }

}
