package inheritance.step01;

public class StudentTest {
    public static void main(String[] args) {
        Person01 person1 = null;
        person1 = new Student01("John", "Smith");
        System.out.println(person1 instanceof Person01);
        System.out.println(person1 instanceof Student01);
    }
}
