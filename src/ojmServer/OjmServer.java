package ojmServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class OjmServer {
    // 선언부
    /// ConcurrentHashMap 여러 스레드가 동시에 접근할 수 있도록 설계
    /// 여러 스레드가 동시에 데이터를 읽고 쓸 때 발생할 수 있는 문제 예방
    final int PORT = 3000;
    ConcurrentHashMap<String, OjmChatRoom> chatRooms;
    ConcurrentHashMap<ObjectOutputStream, String> clientRooms;


    // 생성자
    public OjmServer() {
        chatRooms = new ConcurrentHashMap<>();
        clientRooms = new ConcurrentHashMap<>();
    }

    // 서버 실행 및 스레드 관리
    public void start() {
        // 서버 포트 지정
        try(ServerSocket ss = new ServerSocket(PORT)) {
            System.out.println("Ready to Server.....");

            // 클라이언트 소켓 Accept() 반복문
            while (true) {
                Socket clientSocket = ss.accept();
                System.out.println("클라이언트 접속 | " + clientSocket.getInetAddress());
                new Thread(new OjmClientHandler(clientSocket, this)).start();
            }
        } catch (IOException e) {
            System.out.println("서버 작동 중 오류 발생: " + e.getMessage());
        }
    }

    // chatRooms Object 호출
    public OjmChatRoom getChatRoom(String roomName) {
        return chatRooms.computeIfAbsent(roomName, k -> new OjmChatRoom(roomName));
    }

    // 그룹창 생성
    public void createRoom(String roomName) {
        if (!chatRooms.containsKey(roomName)) {
            chatRooms.put(roomName, new OjmChatRoom(roomName));
            broadcastRoomList();
        }
    }

    // RoomList를 해당 클라이언트에게 전송
    public void broadcastRoomList() {
        // RoomList 결과는 아래와 같이 출력됩니다.
        // ROOMLIST: room1, room2, room3
        String roomList = "RoomList:" + String.join(",", chatRooms.keySet());
        System.out.println(roomList);   // test
        for (ObjectOutputStream client : clientRooms.keySet()) {
            try {
                client.writeObject(roomList);
                client.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("broadcast 진행");
        }
    }


    // HashMap에 그룹명 추가하기
    public void addClientToRoom(ObjectOutputStream client, String roomName) {
        clientRooms.put(client, roomName);
    }

    public void removeClientFromRoom(ObjectOutputStream client) {
        clientRooms.remove(client);
    }

    public String getClientRoom(ObjectOutputStream client) {
        return clientRooms.get(client);
    }


    // 메인 스레드 싱행
    public static void main(String[] args) {
        new OjmServer().start();
    }
}
