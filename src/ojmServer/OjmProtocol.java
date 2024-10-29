package ojmServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;


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


    // 서버 연결
    public void connectToServer() {
        try {
            clientSocket = new Socket("localhost", 3000);
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            System.out.println("Connect to Server.....");

            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // 프로토콜에 따른 입력스트림 처리
    @Override
    public void run() {
        try {
            while((msg = (String) in.readObject()) != null) {
                System.out.println("수신메세지 | " + msg);
                String[] strList = msg.split(":", 2);

                // 입력 스트림을 통한 RoomList 업데이트 진행
                if (strList[0].equals("RoomList")) {
                    oc.updateRoomList(strList[1].split(","));

                // 그룹창 입장
                } else if (strList[0].equals("JOINED")) {
                    oc.displayMsg(msg);

                // 메세지 출력
                } else {
                    oc.displayMsg(msg);
                }

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


    
    // 클라이언트-서버 출력스트림 메서드
    public void sendMsg(String msg) {
        try {
            out.writeObject(msg);
            // 메모리 임시공간(버퍼)은 일정 크기가 차면 그 때 출력되는데, flush()를 통해 지연 없이 즉시 출력되도록 할 수 있습니다.
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

