package day5.variable;

public class StringTest4 {
    public static void main(String[] args) {
        // String은 한번 생성된 문자열은 수정할 수 없습니다.
        // StringBuilder는 수정 가능한 가변 객체로 문자열을 수정할 수 있습니다.
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb1 == sb2);

        sb1.append(" World");       // append는 기존 문자열에 문자열을 추가하는 메소드
        System.out.println("After " + sb1);

        // String은 불변으로 객체가 3번 생성됩니다.
        // 결국 메모리가 낭비되고 처리 시간이 낭비될 수 있습니다.
        String query = "SELECT ename, empno";
        query = query + " FROM emp";
        query = query + " WHERE salary > 3000";

        // 반면 StringBuilder는 가변으로 1개의 객체가 생성됩니다.
        StringBuilder query1 = new StringBuilder();
        query1.append("SELECT ename, empno");
        query1.append(" FROM emp");
        query1.append(" WHERE salary > 3000");

        System.out.println(query);
        System.out.println(query1);
    }
}
