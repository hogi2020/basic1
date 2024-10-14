package day5.variable;

public class Oper1 {
    public static void main(String[] args) {
        Oper1 o1 = new Oper1();
        System.out.println(o1);

        int i = 1;
        int j = i + 2;  // 1+2=3이 j 변수에 초기화
        j += 2;         // += 먼저 앞에 변수와 뒤에 2를 더하고 대입

        // 변수 뒤에 ++가 있으면, 먼저 k를 변수 m에 대입하고 다음에 ++이 반영됩니다.
        // 먼저 1을 증가시키고, 그 다음에 대입하세요.
        int k = 1;
        int m = k++;
        System.out.println("k값은 " + k);
        System.out.println("m값은 " + m);

        // 감소 연산자
        // 변수 앞에 ++이 있으면, k = k + 1이 연산된 후에 m = k에 반영됩니다.
        int x = 3;
        int y = --x;
        System.out.println("x값은 " + x);
        System.out.println("y값은 " + y);
    }
}
