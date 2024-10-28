package ojmServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.CopyOnWriteArrayList;

public class OjmChatRoom {
    // 선언부
    private String name;
    private CopyOnWriteArrayList<ObjectOutputStream> outs;

    // 생성자
    public OjmChatRoom(String name) {
        this.name = name;
        this.outs = new CopyOnWriteArrayList<>();
    }

    // 클라이언트 입장 메소드
    public void addClient(ObjectOutputStream out) {
        outs.add(out);
        broadcast(name + ": 새로운 사용자가 입장했습니다.", null);
    }

    // 클라이언트 삭제 메소드
    public void removeClient(ObjectOutputStream out) {
        outs.remove(out);
        broadcast(name + ": 사용자가 퇴장하였습니다.", null);
    }

    // 브로드 캐스트
    public void broadcast(String msg, ObjectOutputStream sender) {
        for (ObjectOutputStream out : outs) {
            if (out != sender) {
                try {
                    out.writeObject(msg);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
