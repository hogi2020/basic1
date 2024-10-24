package classes.day5;

public class Q27_1 {



    public static void main(String[] args) {
        int deptnos[] = null;
        // index 값은 0부터 입니다.
        // index 값 관리를 잘 해야 합니다. - 초보

        try {
            deptnos = new int[3];
            System.out.println(deptnos[3]);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("");
        }
    }
}
