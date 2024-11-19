package inheritance.step01;

public class Student01 extends Person01 {
    private Major01 major;

    public Student01(String firstName, String lastName) {
        // super는 부모 클래스의 생성자를 호출하는데 사용
        super(firstName, lastName);
    }

    public Major01 getMajorOrNull() {
        return this.major;
    }

    public void setMajor(Major01 major) {
        this.major = major;
    }
}
