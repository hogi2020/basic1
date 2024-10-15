package day5.variable;
/*
7566 - scott - 1900.56
7499 - tiger - 2700
7390 - king - 3100
 */
public class EmpSimulation {
    public static void main(String[] args) {

        // 같은 이름의 변수명이지만, 주소번지 값은 다릅니다.
        Emp emp = new Emp();
        System.out.println(emp);
        emp.empno = 7566;
        emp.ename = "scott";
        emp.salary = 1900.56;
        System.out.println(emp.empno);
        emp = null;
        // null로 객체를 초기화
        // 기존에 참조되던 객체가 candidate 상태가 됨.
        // 명시적으로 사용한 지원에 대해서 반납처리하는 것을 권장합니다.

        emp = new Emp();
        System.out.println(emp);
        emp.empno = 7499;
        emp.ename = "tiger";
        emp.salary = 2700;
        System.out.println(emp.empno);
        emp = null;

        emp = new Emp();
        System.out.println(emp);
        emp.empno = 7390;
        emp.ename = "king";
        emp.salary = 3100;
        System.out.println(emp.empno);
    }
}