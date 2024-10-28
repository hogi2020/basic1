package classes.day6;

//import model.vo.Tomato_Member;
import java.util.ArrayList;
import java.util.List;

public class ListMain3 {
    public static void main(String[] args) {
        List<Tomato_Member> list = new ArrayList<>();

        Tomato_Member tomato = new Tomato_Member();
        tomato.setMem_id("toma");
        tomato.setMem_pw("ddd");
        tomato.setMem_nick("ccc");
        tomato.setMem_name("aaa");

        list.add(tomato);
        System.out.println(tomato == list.get(0));
        // System.out.println(tomato.getMem_id());

        // 프로젝트 진행 시, 서비스 구현시에 멤버변수를 변경하는 것은
        // 상태값을 변경하는 경우도 많아서 주의해야 합니다.
        // 클래스의 인스턴스 변수로 변수의 값을 직접 변경하는 것은 대체로 피하는 것이 좋다.
        // 사이드이팩트 발생되는 것을 주의
        System.out.println(tomato);  // 멤버변수에 private를 썻다. - 캡슐화
    }
}
