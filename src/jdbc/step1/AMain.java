package jdbc.step1;
class A{

}
public class AMain {
    public static void main(String[] args) {
        A[] as = new A[5];
        System.out.println(as.length);//NullPointerException- 5
        for(A a1:as){
            System.out.println(a1);//5번 출력 - null
        }
        //System.out.println(null.length);
        A a = new A();
        System.out.println(a);//주소번지와 as[0]주소번지가 같다.
        as[0] = a;
        System.out.println(as[0]);
        as[0] = new A();
        System.out.println(as[0]);//여기서는 주소번지가 달라요.
    }
}
