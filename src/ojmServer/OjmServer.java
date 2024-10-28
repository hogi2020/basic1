package ojmServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class OjmServer implements Runnable {
    // 선언부
    final int PORT = 3000;
    ConcurrentHashMap<String, OjmChatRoom> chatRooms;
    ConcurrentHashMap<ObjectOutputStream, String> clientRooms;
    OjmClientHandler och;

    // 생성자
    public OjmServer() {
        chatRooms = new ConcurrentHashMap<>();
        clientRooms = new ConcurrentHashMap<>();
    }

    public void start() {
        // 서버 포트 지정
        try(ServerSocket ss = new ServerSocket(PORT)) {
            System.out.println("Ready to Server.....");

            // 클라이언트 소켓 Accept 반복문
            while (true) {
                Socket clientSocket = ss.accept();
                new Thread(new ClientHandler(clientSocket, this)).start();
            }
        } catch (IOException e) {
            System.out.println("서버 지작 중 오류 발생: " + e.getMessage());
        }
    }


    public ChatRoom geChatRoom(String roomName) {
        return chatRooms.computeIfAbsent(roomName, k -> new ChatRoom(roomName));
    
    }


    public void createRoom(String, roomName) {
        if.chatRooms.containsKey(roomName) {
            chatRooms.put(roomName, new ChatRoom(roomName));
        }
    }

    Socket socket = null;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;
    String msg = null;

    /// 선언부 | 클라이언트의 PrintWriter를 저장하는 리스트 생성
    private List<ObjectOutputStream> clientWriters;


    // 생성자 | Socket 멤버변수에 할당
    public OjmServer() {}
    public OjmServer(Socket socket, List<ObjectOutputStream> clientWriters) {
        this.socket = socket;
        this.clientWriters = clientWriters;
    }


    /// 메세지를 모든 클라이언트에 브로드캐스트
    /// synchronized는 자바의 동기화 메커니즘 중 하나로,
    /// 공유자원에 여러 스레드가 동시에 접근하는 것을 방지 하기위해 하나의 스레드만 접근할 수 있도록 하는 기능
    /// 그래서 List를 사용할 때는 동기화 관련 메서드를 사용하는 것이 좋습니다.
    private void broadcast(String msg) {
        synchronized (clientWriters) {
            for (ObjectOutputStream out : clientWriters) {
                try {
                    out.writeObject(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(clientWriters.size());
            }
        }
    }


    // 스레드 동작 시, 구현 메소드
    @Override
    public void run() {
        try (
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            this.out = out;
            clientWriters.add(out);
            System.out.println("클라이언트 접속");

            while((msg = (String) in.readObject()) != null) {
                System.out.println("메세지 정상 출력 | " + msg);
                /// 브로드캐드 메소드를 통해서 모든 클라이언트에게 메세지 전송
                broadcast(msg);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("클라이언트 연결 중 오류 발생: " + e.getMessage());
        } finally {
            clientWriters.remove(out);
            try {
                if (socket != null) socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    // 메인 스레드 싱행
    public static void main(String[] args) {
        List<ObjectOutputStream> clientWriters = Collections.synchronizedList(new ArrayList<>());

        try (ServerSocket ss = new ServerSocket(3000)) {
            System.out.println("Server started successfully.....");

            // Catch for Client Socket
            while(true) {
                System.out.println("Start Client Socket Connect............");
                Socket clientSocket = ss.accept();
                System.out.println("Client connected | " + clientSocket.getInetAddress());

                // 각 클라이언트에 대한 서버 인스턴스 생성
                OjmServer os = new OjmServer(clientSocket, clientWriters);
                // 각 클라이언트별로 새로운 스레드를 생성하여 스레드 진행
                new Thread(os).start();
            }
        } catch (IOException e) {
            System.err.println("서버 시작 중 오류 발생: " + e.getMessage());
        }
    }
}
