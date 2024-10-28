package ojmServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class OjmProtocol implements Runnable {
    // 클라이언트 소켓, 입출력 스트림 선언
    private Socket clientSocket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    String msg = null;

    private OjmClient oc = null;


    // 생성자 생성
    public OjmProtocol(OjmClient oc) {
        this.oc = oc;
        connectToServer();
    }


    // 서버 연결 메소드
    public void connectToServer() {
        try {
            clientSocket = new Socket("localhost", 3000);
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            System.out.println("서버에 연결되었습니다....");

            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // run 메소드 생성
    @Override
    public void run() {
        try {
            while((msg = (String) in.readObject()) != null) {
                System.out.println("수신메세지 | " + msg);
                oc.displayMsg(msg);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    
    // 클라이언트-서버 메세지 전송 메서드
    public void sendMsg(String msg) {
        try {
            out.writeObject(msg);
            // 메모리 임시공간(버퍼)은 일정 크기가 차면 그 때 출력되는데, flush()를 통해 지연 없이 즉시 출력되도록 할 수 있습니다.
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 채팅창 목록 업데이트
    public void updateRoomList(String[] rooms) {
        oc.updateRoomList(rooms);
    }
}

