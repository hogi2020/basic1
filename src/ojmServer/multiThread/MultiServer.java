package ojmServer.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class MultiServer {
    // 선언부
    static private ArrayList<Socket> clientSockets = new ArrayList<>();

    // Runnable 사용을 통한 Thread 관리
    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        // 생성자 | 소켓을 받음
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        // 클라이언트 명으로 ArrayList search!
        private Socket getClientByName(String OtherName) {
            for (Socket socket : clientSockets) {
                if (socket.equals(OtherName)) {
                    return socket;
                }
            }
            return null;
        }


        @Override
        public void run() {
            try {
                // 입출력스트림 설정
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // 클라이언트 이름 연결
                out.println("Input your NickName!");
                this.clientName = in.readLine();
                System.out.println(clientName + " | Connected Server!");

                // 다른 클라이언트와 대화 가능
                out.println("Please Input Other Client Name for 1:1!");
                String OtherName = in.readLine();
                Socket targerClient = getClientByName(OtherName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    // 메인 스레드
    public static void main(String[] args) {
        MultiServer ms = new MultiServer();
        ServerSocket ss = null;
        Socket clientSocket = null;

        // 서버사이드 소켓 생성
        try {
            ss = new ServerSocket(5000);
        } catch (IOException e) {e.printStackTrace();}
        System.out.println("Start Server in port[5000]...");

        // 클라이언트 사이드 소켓 생성
        while (true) {
            try {
                clientSocket = ss.accept();
            } catch (IOException e) {e.printStackTrace();}
            System.out.println("Connect New Client...");

            // 클라이언트 소켓 리스트에 소켓 추가
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            ms.clientSockets.add(clientSocket);
            new Thread(clientHandler).start();
        }
    }
}
