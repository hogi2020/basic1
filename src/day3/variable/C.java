package day3.variable;

public class C {

    static int num = 0;
    // 메소드 선언하기
    // return 타입 메소드 이름(파라미터...){}
    /***************************************************
     * 두 수의 합을 구하는 메소드 구현
     * 자바가 제공하는 메소드가 아니라, 사용자가 정의한 메소드 입니다.
     * 파라미터의 갯수를 정했고, 파라미터의 타입을 정했습니다.
     * return 타입도 정해져 있습니다. (int + int = int, int + double = double)
     * 재사용성을 높이는 코드를 작성하는 첫 단계가 메소드 중심의 코딩을 전개하는 것
     * @param i는 정수형입니다. - 실수형은 불가합니다.
     * @param j는 정수형입니다. - 실수형은 불가합니다.
     * @return 타입은 정수입니다. 왜냐하면 파라미터 타입이 둘 다 int 이니까.
     ****************************************************/
    static int hap(int i, int j) {
        return i + j + num;
    }

    public static void main(String[] args) {
        // 내 안에 선언된 메소드이더라도 main메소드 안에서 호출하려면
        // 인스턴스화를 해야 합니다.
        C c = new C();
        System.out.println(c.hap(4, 5));
    }
}
