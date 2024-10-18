package classes.ui;

public class B2 {
    
    // B1 b1 = null;
    // B1 b1 = new B1(); 깊은 복사가 발생하여 복사본이 만들어짐
    
    public B2(B1 b1) {
        System.out.println("B2 디폴트 생성자 호출");
    }
}
