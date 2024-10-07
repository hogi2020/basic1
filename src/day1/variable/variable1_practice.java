package day1.variable;

public class variable1_practice {

    String[] strs = {"a", "b", "c"};

    public static void main(String[] args) {

        int numValue = 100;
        System.out.println(numValue);

        variable1_practice var1p = new variable1_practice();
        String[] strs_region = var1p.strs;

        // 배열에 값을 추가하기 위해서는 배열의 크기를 키워야 합니다.
        // 새로운 배열을 생성한 후, 배열을 새배열에 복사하고, 새배열에 값을 추가합니다.
        // System은 클래스, out은 입력장치 키워드, println 메소드, 세미콜론 호출
        String[] str_array_new = new String[strs_region.length + 1];
        System.arraycopy(strs_region, 0, str_array_new, 0, strs_region.length);
        str_array_new[str_array_new.length - 1] = "d";

        // 전역변수의 배열을 가진 클래스를 인스턴스화 하고,
        // 인스턴스화된 배열을 새롭게 str_array 변수에 초기값으로 선언합니다.
        // 배열의 길이를 통해 for 반복문을 이용하여 배열의 값들을 호출할 수 있습니다.
        for (String s : str_array_new) {
            System.out.println(s);
        }
    }
}
