package day6.variable;

class Dept {
    int deptno;
    String dname;
    String loc;
}

public class DeptMain {

    void effectParam(Dept dept) {
        // dept = new Dept();
        dept.deptno = 789;
        dept.dname = "scott";
        dept.loc = "USA";

        // main에서 출력되기 전에 먼저 출력됨 - 순서, 위치
        System.out.println("sub deptno : " + dept.deptno);
        System.out.println("sub dname : " + dept.dname);
    }

    public static void main(String[] args) {
        DeptMain deptm = new DeptMain();
        Dept dept = new Dept();

        dept.deptno = 500;
        deptm.effectParam(dept);
        System.out.println("sub deptno : " + dept.deptno);
    }
}
