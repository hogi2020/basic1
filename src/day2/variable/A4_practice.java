package day2.variable;

public class A4_practice {

    public int avgs(int[] nums) {
        int sumNum = 0;
        for(int n : nums) {
            sumNum += n;
        }

        return sumNum;
    }


    public static void main(String[] args) {

        int[] ea = {1, 2, 3, 4, 5};

        // while문을 통한 합 출력
        int i = 0;
        while (i < ea.length) {
            System.out.println("현재 번호는 " + ea[i] + "입니다.");
            i++;
        }

        // out은 출력을 실행하는 변수
        // 클래스.변수.메소드;
        System.out.println();

        // 팩토리얼 수열 공식 사용
        int sumNum = 0;
        for (int n : ea) {
            sumNum += n;
        }
        System.out.println("배열값의 총합은 " + sumNum + "입니다.");

        // 평균 구하기
        A4_practice a4 = new A4_practice();

        int avgNum = a4.avgs(ea);
        System.out.println("평균값은 " + avgNum + " 입니다.");
    }
}
