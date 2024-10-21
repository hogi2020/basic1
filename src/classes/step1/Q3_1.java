package classes.step1;

public class Q3_1 {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;

        if((++i == j) && (++i < j--)) {    // 비교할 때는 2, 2 | 결과를 출력할 때는 2, 1
        // if((i) && (j)) {
           System.out.println("참일 때 i: " + i + ", j: " + j);
        } else {
           System.out.println("거짓일 때 i: " + i + ", j: " + j);
        }

    }
}
