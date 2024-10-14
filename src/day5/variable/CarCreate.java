package day5.variable;

public class CarCreate {

    // CarType 열거형 정의
    public enum CarType {
        ELECTRIC, PETROL, HYBRID
    }

    // 멤버변수(전역변수)
    private String name;
    private String color;
    private int year;
    private int oil;
    private CarType type;

    // 생성자
    private CarCreate(String name, String color, int year, int oil, CarType type) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.oil = oil;
        this.type = type;
    }

    // 클래스 객체 반환을 위한 정적 팩토리 메서드 생성
    public static CarCreate createE(String name, String color, int year, int oil) {
        return new CarCreate(name, color, year, oil, CarType.ELECTRIC);
    }


    public static void main(String[] args) {
        CarCreate ecar = new CarCreate("테슬라", "RED", 2024, 70, CarType.ELECTRIC);
        System.out.println(ecar);
        System.out.println(ecar.name);
        System.out.println(ecar.type);
        System.out.println(ecar.color);

        ecar = CarCreate.createE("테슬라", "BLACK", 2023, 90);
        System.out.println(ecar.color);

    }
}
