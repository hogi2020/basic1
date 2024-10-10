package day3.variable;

// Pride는 Object 클래스를 상속하는 자식클래스로 정의되었습니다.
// 클래스를 상속할 때는 extends를 사용합니다.
// 기본적으로 Object 클래스는 default로 상속받고 있습니다.
// Pride 클래스를 인스턴스화하면 부모클래스인 Object가 제공하는 toString()을 호출할 수 있습니다.
public class Pride extends Object {


    public String toString() {
        return "나는 프라이드 자동차 입니다.";
    }

    public static void main(String[] args) {

        // instance here
        // 인스턴스화에서 선언된 변수이므로 인스턴스 변수라고 합니다.
        // 이 때 호출할 수 있는 변수는 전역변수만 가능합니다.
        Pride herCar = new Pride();

        // toString()는 재정의 하였습니다.
        // 부모클래스가 제공하는 toString()이 아니라, java안에서 구현한 메소드가 호출됩니다.
        // 이 코드에서는 toString()가 구현되어 있어서 주소번지가 출력되지 않고,
        // 대신에 return값이 출력됩니다.
        System.out.println(herCar);
        System.out.println(herCar.toString());

        // instance here
        // toString() 메서드는 객체의 문자열 표현을 반환하는 메서드

        Object object = new Object();
        String str2 = object.toString();
        System.out.println(str2 + " 주소지");
    }
}
