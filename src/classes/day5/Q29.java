package classes.day5;

import org.w3c.dom.ls.LSOutput;

//class Q29 {

//    public static void main(String[] args) {
//        Q29 q29 = new Q29();
//
//        String a1[], b1;
//
//
//        int []a3, b3 = null;
//        int []a5, b5 = new int[]{1, 2, 3, 4, 5};
//        a5 = new int[]{1, 2, 3, 4, 5};
//
//        System.out.println(a5[3]);
//        System.out.println(b5[3]);
//    }
//}



class Animal {}
class Dog extends Animal {}

public class Q29 {
    public static void main(String[] args) {
        Animal animal;
        animal = new Dog();

        if (animal instanceof Dog) {
            System.out.println("animal은 Dog의 인스턴스입니다.");
        } else {
            System.out.println("animal은 Dog의 인스턴스가 아닙니다.");
        }
    }
}