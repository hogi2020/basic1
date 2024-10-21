package classes.step1;

class Some {
    SomeObject so = null;

    // 생성자
    public Some(SomeObject so) {
        this.so = so;
        System.out.println(so + "Some 생성자가 호출되었습니다.");
    }
    public Some(int a) {
        System.out.println(a + "Some 생성자가 호출되었습니다.");
    }
}

public class SomeObject {
    // 선언부
    // 클래스와 클래스 사이에 관계가 있습니다.
    Some some = new Some(this);     // 얕은복사, 깊은복사

    // 생성자 - 메소드 활용 (선언과 호출 유사 - 다른점은 리턴이 없다는 점)
    public SomeObject() {
        System.out.println("SomeObject 생성자가 출력되었습니다.");
    }

    // 사용자 정의 메소드
    void method() {}

    // 메인 메소드
    public static void main(String[] args) {
        SomeObject so = new SomeObject();
        System.out.println(so);
    }
}
