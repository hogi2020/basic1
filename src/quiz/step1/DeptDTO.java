package quiz.step1;

public class DeptDTO{
    int deptno;
    String dname;
    String loc;
    DeptDTO(int deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
class DeptMain {
    public static void main(String[] args) {
        DeptDTO[] depts = new DeptDTO[3];
        DeptDTO dto = new DeptDTO(10,"총무부","인천");
        System.out.println(dto);
        //주소번지가 언제 바뀌나요?
        depts[0] = dto;
        System.out.println(depts[0].deptno);//10
        System.out.println(depts[0]==depts[1]);//true
        System.out.println(depts[1]==depts[2]);//true
        //여기는 계속 같은 번지가 유지되고 있다.
        dto = new DeptDTO(20,"영업부","서울");
        //여기서 바뀐다.
        depts[1] = dto;
        System.out.println(depts[1].deptno);//20
        System.out.println(depts[1].dname);//영업부
        System.out.println(depts[1].loc);//서울
        System.out.println(dto.deptno);//20
        System.out.println(dto.dname);//영업부
        System.out.println(dto.loc);//서울
        //System.out.println(depts[1].deptno);//20
        dto = new DeptDTO(30,"개발부","부산");
        //여기서 바뀐다.
        depts[2] = dto;
        System.out.println(depts[2].deptno);//30
        System.out.println(depts[2].dname);//30
        System.out.println(depts[2].loc);
        System.out.println(dto.deptno);//30
        System.out.println(dto.dname);//30
        System.out.println(dto.loc);//30
    }
}
