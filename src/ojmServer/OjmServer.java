package ojmServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class OjmServer implements Runnable {
    // 선언부
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

        try {
            // 입출력 스트림 작성
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            /// 새 클라이언트의 PrintWriter를 리스트에 추가
            synchronized (clientWriters) {
                clientWriters.add(out);
                System.out.println("클라이언트 접속");
            }

            // 메세지 수신
            while((msg = in.readLine()) != null) {
                System.out.println("메세지 정상 출력 | " + msg);

                /// 브로드캐드 메소드를 통해서 모든 클라이언트에게 메세지 전송
                broadcast(msg);
            }
        }
        catch (IOException e) {
            // 예외처리 및 Server Close
            e.printStackTrace();
        }
        finally {
            // 자원 해제 | 자원 누수 방지를 위해 클라이언트 연결이 종료되면 자원 해제
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();

                /// 클라이언트 연결이 종료되면 리스트에서 PrintWriter 제거
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    // 메인 스레드 싱행
    public static void main(String[] args) {
        List<ObjectOutputStream> clientWriters = new ArrayList<>();
        ServerSocket ss = null;

        try {
            // Take Server Port
            ss = new ServerSocket(3000);
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
            e.printStackTrace();
            try {ss.close();}
            catch (IOException ex) {ex.printStackTrace();}
        }
    }
}