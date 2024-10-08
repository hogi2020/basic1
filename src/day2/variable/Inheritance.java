package day2.variable;

import javax.xml.namespace.QName;

class Animal {
    String type = "동물";

    public void eat() {
        System.out.println("먹습니다.");
    }
}

// 동일 파일 내 접근제한자는 유일해야 하므로
// Animal과 Dog의 접근제한자는 defult로 해야 합니다.
// 이유는 java 컴파일러가 소스 파일을 찾고 관리하는 방식 때문입니다.
// 파일 이름과 클래스의 이름이 일치하지 않으면 컴파일 시 오류가 발생합니다.
class Dog extends Animal{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(name + "은/는 " + type + "입니다.");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Dog myDog = new Dog("리트리버");
        myDog.display();
    }
}
