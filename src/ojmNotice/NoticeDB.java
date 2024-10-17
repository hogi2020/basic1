package ojmNotice;

public class NoticeDB {
    // 2차원 배열 컬럼명 설정
    String[] colName = {"No.", "Title", "Author", "Date"};

    // 2차원 배열 데이터 초기값
    String[][] data = {
            {"1", "Sample", "hogi", "2024-10-17 10:26:00"},
            {"2", "Sample2", "hogi", "2024-10-17 10:39:00"}
    };

    // 2차원 배열 데이터 오버라이드 메소드
    public String[][] array_Over() {
        return data;
    }
    public String[][] array_Over(String[][] new_array) {
        data = new_array;
        return data;
    }
}
