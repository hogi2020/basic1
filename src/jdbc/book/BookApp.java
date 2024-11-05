package jdbc.book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
BookDialog에서 수정이나 입력일 때 insert가 1이거나 또는 update도 1이면 성공
이 때 BookApp의 도서 목록 페이지를 새로고침 한다. - 요구사항이 있다면....
BookApp 의 메소드를 BookDialog에서 호출해야 한다.
이 때 부모창의 주소원본을 가져한다.
 */
public class BookApp extends JFrame implements ActionListener {
    BookDialog bd = new BookDialog(this);
    JMenuBar mb = new JMenuBar();
    JMenu jm_file = new JMenu("File");
    JMenuItem jmi_dbcon = new JMenuItem("DB연결");
    JSeparator se_file = new JSeparator();
    JMenuItem jmi_exit = new JMenuItem("Exit");
    JMenu jm_edit = new JMenu("Edit");
    JMenuItem jmi_all = new JMenuItem("전체조회");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_det = new JMenuItem("상세보기");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_del = new JMenuItem("삭제");
    String imgPath = "src\\image\\book\\";
    JToolBar jtBar = new JToolBar();
    JButton btn_all = new JButton("전체조회");
    JButton btn_ins = new JButton("입력", new ImageIcon(imgPath + "new.gif"));
    JButton btn_det = new JButton("상세보기", new ImageIcon(imgPath + "detail.gif"));
    JButton btn_upd = new JButton("수정", new ImageIcon(imgPath + "update.gif"));
    JButton btn_del = new JButton("삭제", new ImageIcon(imgPath + "delete.gif"));
    public BookApp() {
        initDisplay();
    }
    public void refreshData(){
        System.out.println("새로고침 호출");
    }
    //입력일 때 호출 - 입력 버튼 | 입력 메뉴 아이템
    public void insertActionPerformed(){
        System.out.println("입력 버튼 | 입력 메뉴 아이템");
        bd.set("입력", true);
    }
    //상세보기일 때  호출 - 상세보기버튼 | 상세보기 메뉴 아이템
    public void detailActionPerformed(){
        System.out.println("상세보기버튼 | 상세보기 메뉴 아이템");
    }
    //수정일때 호출 - 수정버튼 | 수정 메뉴 아이템 일때
    public void updateActionPerformed(){
        System.out.println("수정버튼 | 수정 메뉴 아이템 일때");
    }
    //삭제 일때 호출 - 삭제버튼 | 삭제 메뉴 아이템 일때
    public void deleteActionPerformed(){
        System.out.println("삭제버튼 | 삭제 메뉴 아이템 일때");
    }

    public void initDisplay(){

        btn_ins.addActionListener(this);
        jmi_ins.addActionListener(this);
        btn_det.addActionListener(this);
        jmi_det.addActionListener(this);
        btn_upd.addActionListener(this);
        jmi_upd.addActionListener(this);
        btn_del.addActionListener(this);
        jmi_del.addActionListener(this);
        btn_all.addActionListener(this);
        jmi_all.addActionListener(this);
        jm_file.add(jmi_dbcon);
        jm_file.add(se_file);
        jm_file.add(jmi_exit);
        jm_edit.add(jmi_all);
        jm_edit.add(jmi_ins);
        jm_edit.add(jmi_det);
        jm_edit.add(jmi_upd);
        jm_edit.add(jmi_del);
        mb.add(jm_file);
        mb.add(jm_edit);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(mb);//메뉴바는 배치하는 것이 아니고 this에 직접 붙임
        jtBar.add(btn_all);
        jtBar.add(btn_ins);
        jtBar.add(btn_det);
        jtBar.add(btn_upd);
        jtBar.add(btn_del);
        this.add("North", jtBar);
        this.setSize(700, 500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        //13번의 멤버는 언제 생성이 되는가? 내 자신 객체를 생성할 때 초기화 및 생성됨
        BookApp ba = new BookApp();
        //20이 실행(new포함)되면
        //A a  = null, a = new A();
        //선언부  a는 주소번지 할당이 되기 전임. null.toString();
        //a = new A()했을 때 주소번지 생성됨.
        //13번에서 this는 20번 ba주소번지와 같은 값을 가진다.
        //디폴트 생성자는 없을 때 자동으로 생성해(누가? JVM) 주지만
        //파라미터를 갖는 생성자는 파라미터를 예측할 수가 없어서 대신 못해줌
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //서로 같은 역할을 하는 메뉴아이템과 버튼에 대해서 하나의 메소드로 설계해본다. - 학습목표
        if(obj == btn_all || obj == jmi_all){
            refreshData();
        }
        if(obj == btn_ins || obj == jmi_ins){
            insertActionPerformed();
        }
        if(obj == btn_upd || obj == jmi_upd){
            updateActionPerformed();
        }
        if(obj == btn_del || obj == jmi_del){
            deleteActionPerformed();
        }
        if(obj == btn_det || obj == jmi_det){
            detailActionPerformed();
        }
    }
}
/*
메뉴바 추가하기
툴바 추가하기
같은 메뉴를 메뉴바와 툴바에 모두 추가하여서 메소드 재사용성 구현 실습
같은 메뉴

이벤트 처리를 담당하는 클래스로 설계하기 - ActionListener

삭제는 BookApp.java처리한다.
상세조회, 수정, 입력은 BookDialog.java처리한다.
이 중에서 수정하기와 상세조회는 오라클 서버를 경유해야 한다.
왜냐면 기존에 있는 정보를 수정하거나 상세조회하는 것이므로 조회결과를
화면에 출력해야 한다.
입력은 오라클 서버를 경유하지 않고 BookDialog화면에서 새로 입력받은
정보를 오라클 서버에 입력하는 것이다.(INSERT문)
BookDialog.java와 BookDao.java사이에서 처리가 진행된다.
BookDialog.java에서 BookDao의 메소드를 호출할 때 사용자가 입력한 값을
파라미터로 넘겨야 하는데 컬럼의 갯수만큼 넘기는 것보다는 BooVO주소번지를
하나 넘겨서 그 안에 선언된 멤버변수값을 insert문에 넣는 것이 더 나은 방법이다.
BookDialog에서는 BookDao의 인스턴스화를 해야 한다.
BookDialog에서 BookDao의 메소드를 호출한다.
 */