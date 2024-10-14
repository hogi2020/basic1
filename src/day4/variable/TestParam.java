package day4.variable;

class Param {
    int i;
}

// 참조형 변수를 클래스의 파라미터로 사용
public class TestParam {

    // 클래스 타입 선언과 인스턴스화를 분리해서 사용 가능
    // 파라미터에 클래스 타일을 선언하고, 메소드 영역 안에 인스턴스화 진행 가능
    // 메서드를 호출할 때는 값만 사용합니다.
    // 이미 메소드의 파라미터 작성 시 변수가 선언되었기 때문입니다.
    void effectParam(Param p) {
        p = new Param();
        p.i = 100;
        System.out.println("sub i는 " + p.i);
    }

    public static void main(String[] args) {
        TestParam tp = new TestParam();
        Param p = new Param();

        p.i = 500;
        tp.effectParam(p);
        System.out.println("main i는 " + p.i);
    }
}

/*
main의 i와 sub i가 같은 값을 출력하고 있습니다.
main 메소드에서 인스턴스화된 파라미터를 넘겨주었습니다.
(참고, 얕은 복사와 깊은 복사)

이 예제에서는 main메소드에서 500이었지만, main에서 출력전에 effectParam() 먼저 호출함
그 메소드 내부에서 i값을 다시 p.i=100으로 변경하였습니다.
 */