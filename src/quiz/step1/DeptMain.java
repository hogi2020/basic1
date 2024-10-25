package quiz.step1;


class DeptDTO {
    int deptno;
    String dname;
    String loc;

    DeptDTO(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

}

public class DeptMain {

    public static void main(String[] args) {
        DeptDTO[] depts = new DeptDTO[3];

        DeptDTO dto = new DeptDTO(10, "총무부", "인천");
        depts[0] = dto;
        depts[1] = dto;
        depts[2] = dto;
        System.out.println(dto);

        depts[0] = dto;
        System.out.println(depts[0].deptno);
        System.out.println(depts[0] == depts[1]);
        System.out.println(depts[1] == depts[2]);

        dto = new DeptDTO(20, "영업부", "서울");
        // 여기서 바뀐다.
        depts[1] = dto;
        dto = new DeptDTO(30, "개발부", "부산");
        // 여기서 바뀐다.
        depts[2] = dto;
        System.out.println(depts[2].deptno);
        System.out.println(depts[2].dname);
        System.out.println(depts[2].loc);
        System.out.println(dto.deptno);
        System.out.println(dto.dname);
        System.out.println(dto.loc);
    }
}
