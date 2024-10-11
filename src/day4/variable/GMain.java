package day4.variable;

class G {
    int i;      // 전역변수 선언, 초기값이 없으므로 0으로 자동설정
    static int j;

    void methodA() {
        // 변수 i는 전역변수이므로 G클래스 내부 어디든지 호출이 가능합니다.
        System.out.println(i);
        System.out.println(j);
    }
}
// 12-14-15-5(G.class)-7(0출력해줌)-8(method A가 끝나고)-나를 호출한 곳으로 이동-16-17
public class GMain {
    public static void main(String[] args) {
        // 인스턴스화된 코드를 JVM이 실행하면 heap 메모리에 상주합니다.
        G g = new G();
        g.methodA();
    }
}
