package day3.variable;

public class B {
    public static void main(String[] args) {
        int i = 1;
        double avg = 0.5;

        // double이 타입크기가 크므로 int 타입 변수를 할당할 수 있습니다.
        // 반대로 타입크기가 작은데, 큰 타입 변수를 할당할 수 는 없습니다.
        i = (int) avg;

        // 실수 0.5는 담을 수 없고, 0만 담을 수 있습니다.
        // 반올림이 아닌 정수자리수에 있는 값만 저장되는 원리입니다.
        System.out.println((int) avg);

        // i가 double 변수에 할당되었으므로 정수에서 실수로 형변환 발생
        // 0은 실수형인 0.0이 됩니다.
        avg = i;
        System.out.println(avg);
    }
}
