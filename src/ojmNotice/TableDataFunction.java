package ojmNotice;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class TableDataFunction {

    // 날짜 입력 메소드
    public String insetDate() {
        // long 타입으로 현재 시간 반환
        // System.currentTimeMillis() 시스템 시간에 기반한 밀리초 단위의 시간값을 반환
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(System.currentTimeMillis());

        // 생성된 객체를 초기화하고, 가비지 컬렉션을 요청하여 객체 삭제
        simpleDateFormat = null;

        return currentTime;
    }


    // 입력 메소드
    public void addData(DefaultTableModel dtm, int no, String title, String author) {
        dtm.addRow(new Object[]{no, title, author, insetDate()});
    }


    // 수정 메소드
    public void updData(DefaultTableModel dtm, int no, String title, String name) {
        // 테이블 행 개수 가져오기
        int rowCount = dtm.getRowCount();

        // 값이 일치하는 행의 인덱스를 반환하여 수정
        for (int row = 0; row < rowCount; row++) {
            if (dtm.getValueAt(row, 0).equals(no)) {
                dtm.setValueAt(title, row, 1);
                dtm.setValueAt(name, row, 2);
                dtm.setValueAt(insetDate(), row, 3);
            }
        }
    }


    // 삭제 메소드
    public boolean delData(DefaultTableModel dtm, int no) {
        // 테이블 행 개수 가져오기
        int rowCount = dtm.getRowCount();
        boolean bool = false;

        // 값이 일치하는 행의 인덱스를 반환하여 삭제
        for (int row = 0; row < rowCount; row++) {
            if (dtm.getValueAt(row, 0).equals(no)) {
                dtm.removeRow(row);
                bool = true;
                break;
            }
        }
        return bool;
    }
}
