package day5.variable;

import day3.variable.C;

class Z {
    int i;
}

class Cat {
    int j;
}

public class StringTest7 {
    public static void main(String[] args) {
        // 외부 클래스의 변수를 사용하려면 인스턴스화 합니다.
        Z z = new Z();
        System.out.println("출력값은 " + z);  // 주소번지가 출력됨

        // z클래스는 주소번지가 출력되는데, 일반적임
        // 이에 반해서 String은 클래스임에도 불구하고 문자열이 출력됩니다.
        String s = new String("출력값은 " + "안녕하세요");
        System.out.println(s);

        Cat cat = new Cat();
        System.out.println("출력값은 " + cat.j);

    }
}
