package classes.step1;

public class IF1 {
    public static void main(String[] args) {
        int jumsu = 90;
        if (jumsu <= 100 && jumsu >= 90) {
            System.out.println("A학점");
        }
        else if (jumsu < 90 && jumsu >= 80) {
            System.out.println("B학점");
        }
        else if (jumsu < 80 && jumsu >= 70) {
            System.out.println("C학점");
        }
        else {
            System.out.println("F학점");
        }
    }
}
