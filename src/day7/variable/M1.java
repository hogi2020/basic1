package day7.variable;

public class M1 {

    // 생성자는 클래스 명을 갖고, 반환 타입이 없습니다.
    // 생성자는 인스턴스화할 때 호출됩니다.
    // 디폴트 생성자는 JVM에서 자동 생성하지만, 생성자를 만들면 디폴트 생성자는 직접 입력해야 합니다.
    public void M1() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        M1 m1 = new M1();
        String s1 = new String("Hello");
        System.out.println("M1 | " + m1);

        m1 = null;          // 객체를 null로 초기화
        System.out.println("M1 | " + m1);
        //m1.toString();    // 예외(Exception-디버깅, 문제해결)가 발생하면 프로그램이 멈춤

        m1 = new M1();
        System.out.println("M1 | " + m1);
        System.gc();        // 가비지 컬렉터를 호출하는 코드
    }
}
