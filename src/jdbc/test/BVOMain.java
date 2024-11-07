package jdbc.test;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
class BVO {
    private int age;
    private String name;
}

public class BVOMain {
    public static void main(String[] args) {
        BVO avo = new BVO(30, "강감찬");
        avo.setAge(50);
        avo.setName("이성계");
        System.out.println(avo.getAge());
        System.out.println(avo.getName());

        // 변수는 한 번에 하나만 기억할 수 있다.
        BVO bvo = BVO.builder().name("김유신").age(20).build();
        System.out.println(bvo.getAge());
        System.out.println(bvo.getName());
    }
}
