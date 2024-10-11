package day4.variable;

public class N {

    void methodA(N n) {
        System.out.println(n.toString());
    }//////////end of methodA

    void methodB(String msg) {
        System.out.println(msg.toUpperCase());
    }/////////end of methodB

    public static void main(String[] args) {
        N n = new N();

        String name = null;
        n.methodB(name);
    }/////////end of main
}
