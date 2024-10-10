package day3.variable;

public class Return1 {

    void hap(int i, int j) {
        int result = i + j;
        System.out.println(result);
    }
    int hap1(int i, int j) {
        return i + j;
    }
    String hap2(int i, int j) {
        return i + j + "원/개";
    }
    String hap3(int i, int j) {
        return i + j + "원";
    }

    public static void main(String[] args) {
        Return1 r = new Return1();

        System.out.println("단가표");
        System.out.println("=====================");
        System.out.println("사과 | 단가 | " + r.hap2(40, 50));
        System.out.println("=====================");

        // hap 메소드는 클래스 안에서 프린트문이 있으므로 출력이 가능합니다.
        r.hap(3, 5);
    }
}
