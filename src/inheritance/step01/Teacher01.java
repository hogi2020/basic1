package inheritance.step01;

public class Teacher01 extends Person01 {
    private Department01 department01;

    public Teacher01 (String firstName, String lastName, Department01 department) {
        super(firstName, lastName);
        this.department01 = department;
    }

    public void setDepartment01(Department01 department) {
        this.department01 = department;
    }

    public Department01 getDepartmentOrNull() {
        return this.department01;
    }


}
