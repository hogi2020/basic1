package mvc;

public class ControllerTest {
    public static void main(String[] args) {
        BoardController bc = new BoardController();
        BoardVO pbvo = new BoardVO();
        pbvo.setCommand("selectOne");

        BoardVO rbvo = bc.send(pbvo);
        System.out.println(rbvo.getResult());
        bc.getBoardList();
    }
}
