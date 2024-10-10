package day3.variable;

// 접근제한자가 default면 동일 패키지 내에서 사용이 가능합니다.
class A {

    // 전역변수는 외부의 다른 클래스에서 호출할 수 있습니다.(재사용성)
    // 지역변수는 외부의 다른 클래스에서 호출할 수 없습니다.
    int i;

    public String str(String sPlus, String addr) {
        String s = " 입니다.";
        return sPlus + addr + s;
    }
}
