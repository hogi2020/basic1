package day4.variable;

class Param {
    int i;
}

// 참조형 변수를 클래스의 파라미터로 사용
public class TestParam {

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
