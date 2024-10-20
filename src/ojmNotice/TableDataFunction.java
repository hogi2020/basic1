package ojmNotice;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class TableDataFunction {
    NoticeEdit edit = new NoticeEdit(this);
    NoticeMain nm = null;

    public TableDataFunction() {}
    public TableDataFunction(NoticeMain nm) {
        this.nm = nm;
    }

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
    public void addData(int no, String title, String author) {
        nm.table_model.addRow(new Object[]{no, title, author, insetDate()});
    }


    // 수정 메소드
    public void updData(int no, String title, String name) {
        // 테이블 행 개수 가져오기
        int rowCount = nm.table_model.getRowCount();

        // 값이 일치하는 행의 인덱스를 반환하여 수정
        for (int row = 0; row < rowCount; row++) {
            if (nm.table_model.getValueAt(row, 0).equals(no)) {
                nm.table_model.setValueAt(title, row, 1);
                nm.table_model.setValueAt(name, row, 2);
                nm.table_model.setValueAt(insetDate(), row, 3);
            }
        }
    }


    // 삭제 메소드
    public void delData(int no) {
        // 테이블 행 개수 가져오기
        int rowCount = nm.table_model.getRowCount();

        // 값이 일치하는 행의 인덱스를 반환하여 삭제
        for (int row = 0; row < rowCount; row++) {
            if (nm.table_model.getValueAt(row, 0).equals(no)) {
                nm.table_model.removeRow(row);
                edit.dispose();
                break;
            }
            else if (row == rowCount-1) {
                JOptionPane.showMessageDialog(nm, "일치하는 번호의 행이 없습니다.");
            }
        }
    }
}
