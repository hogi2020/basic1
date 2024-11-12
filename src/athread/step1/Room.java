package athread.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Room {
    List<KiwiServerThread> userList = new Vector<>();
    List<String> nameList = new Vector<>();
    String title;//단톡방이름
    String state;//방상태
    int max = 0;//최대 정원수
    int current = 0;//현재 인원
    public Room(){}
    public Room(String title, String state, int max){
        this.title = title;
        this.state = state;
        this.max = max;
    }

}
