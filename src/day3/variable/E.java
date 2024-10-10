package day3.variable;

// static이 붙은 메소드 안에서는 static이 없는 변수를 사용할 수 없습니다.
// 이 말은 static이 없는 메서드 안에서는 사용할 수 있습니다.

public class E {

    // 변수 x는 전역변수이지만, static 붙지 않아서 hap 메소드 안에서 호출이 가능합니다.
    // 그러나 main 메소드 안에서는 호출이 불가 합니다.
    // 왜냐면 main 메소드 앞에는 static이 있으니까....

    // 왜 void 앞에 static을 넣으면 x값이 안 받아지는 거야????????
    static int x;
    static void hap (int i, int j) {
        System.out.println(x);
        System.out.println(i + j);
    }

    public static void main(String[] args) {

        System.out.println(x);
        hap(3, 4);


    }
}
