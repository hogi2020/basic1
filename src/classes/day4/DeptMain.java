package classes.day4;
// 오라클에서 생성된 테이블을 자바의 클래스로 설계함.
// 오라클에서 컬럼명은 변수로 이해해보자.
// Value Object 역할을 수행하는 클래스로 설계하였습니다.
// 하나의 클래스에 여러개의 변수를 선언할 수 있습니다.
// 서로 관련이 있는 하나의 로우를 담을 수 있는 클래스 입니다.
// 객체 배열을 사용할 수 있습니다. - n개의 로우도 담을 수 있습니다.
// 단 고정형이다. 는 단점 - 한번 크기를 정하면 변경이 불가합니다.
// Value Object의 역할을 수행하는 클래스는 List나 Map의 제네릭으로 사용할 수 있습니다.
// 초기화 문제
class Dept {

    private int deptno = 0;//10;              // 클래스 안에서만 접근 허용
    private String dname = null;//"ACCOUNTING";  // String dname 선언
    private String loc = null;//"NEW YORK";      // String loc 선언

    // 생성자
    // 생성자 활용하기
    // 나는 생성자를 통해서 멤버변수의 초기화를 할 수 있습니다.
    // 나는 여러가지의 생성자를 재정의하여 상황에 따라 선택하여 호출할 수 있습니다.
    // 나는 this를 사용해야 하는 이유에 대해 말할 수 있습니다.
    Dept() {}
    Dept(String dname) {this.dname = dname;}
    Dept(int deptno, String dname, String loc) {}


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
        Dept d = new Dept("apple");
        System.out.println(d.getDeptno());
        System.out.println(d.getDname());
        System.out.println(d.getLoc());
    }
}
