package day5.variable;

// Access modifier(수정자) | 접근제한자, 접근제어자
class A {
    int i;  // 전역변수(멤버변수)를 선언하는 자리입니다.

    public int hap(int i, int j) {
        return i + j;
    }

    public static void main(String[] args) {
        // non-static 변수 i는 static 영역에서 사용이 불가함.
        A a = null;                 // 참조형일 때 사용하는 리터럴이 null 입니다.
        System.out.println(a);
        System.out.println(a.i);    // 컴파일 타입은 합법인데, 런타임시에는 에러 발생
    }
}
