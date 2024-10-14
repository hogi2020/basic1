package day5.variable;

public class Oper4 {
    public static void main(String[] args) {

        // for (선언+초기화, 조건식, 값 증감)
        for(int i = 1; i <= 3; i++) {
            System.out.println("단일변수 for문 " + i);
        }

        // 배열 값을 반환하는 for문 생성
        int[] nums = {1, 2, 3};
        for(int n : nums) {
            System.out.println("배열변수 for문 " + n);
        }

        // for문과 if문을 활용한 코드
        int sum1 = 0; int sum2 = 0;

        int m = 0;
        for(int k = 1; m <= 10; k++) {

            m += 2;

            if(k % 2 == 0) {
                sum1 += k;
            } else {
                sum2 += k;
            }
        }
        System.out.println("짝수의 합 | " + sum1);
        System.out.println("홀수의 합 | " + sum2);
    }
}
