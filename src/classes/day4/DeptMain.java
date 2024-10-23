package classes.day4;
// 오라클에서 생성된 테이블을 자바의 클래스로 설계함.
// 오라클에서 컬럼명은 변수로 이해해보자.

class Dept {
    // 생성자
    Dept() {}

    // 생성자 활용하기
    // 나는 생성자를 통해서 멤버변수의 초기화를 할 수 있습니다.
    // 나는 여러가지의 생성자를 재정의하여 상황에 따라 선택하여 호출할 수 있습니다.
    // 나는 this를 사용해야 하는 이유에 대해 말할 수 있습니다.
    Dept(int deptno, String dname, String loc) {

    }

    private int deptno = 10;              // 클래스 안에서만 접근 허용
    private String dname = "ACCOUNTING";  // String dname 선언
    private String loc = "NEW YORK";      // String loc 선언


    // getter and setter // 생성 --> getter & setter
    // 데이터를 읽고 쓰는 함수를 생성
    public int getDeptno() {
        return deptno;
    }
    public String getLoc() {
        return loc;
    }
    public String getDname() {
        return dname;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}


public class DeptMain {
    public static void main(String[] args) {
        Dept d = new Dept();
        System.out.println(d.getDeptno());
        System.out.println(d.getDname());
        System.out.println(d.getLoc());
    }
}
