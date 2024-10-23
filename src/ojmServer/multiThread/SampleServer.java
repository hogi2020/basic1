package ojmServer.multiThread;

import java.io.*;
import java.net.*;
import java.util.*;


public class SampleServer {
    // 현재 연결된 모든 클라이언트의 소켓 리스트
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버가 포트 8080에서 실행 중입니다...");

        while (true) {
            Socket clientSocket = serverSocket.accept();  // 클라이언트 연결 대기
            System.out.println("새로운 클라이언트가 연결되었습니다.");

            // 클라이언트 핸들러 생성 및 스레드 시작
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clientHandlers.add(clientHandler);  // 연결된 클라이언트를 리스트에 추가
            new Thread(clientHandler).start();  // 스레드 시작
        }
    }

    // 클라이언트 핸들러 클래스 (각 클라이언트를 처리)
    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // 클라이언트와 데이터 주고받기 위한 스트림 설정
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // 클라이언트 이름 요청 및 수신
                out.println("사용자 이름을 입력하세요: ");
                clientName = in.readLine();
                System.out.println(clientName + "이(가) 연결되었습니다.");

                // 다른 클라이언트와 대화 가능
                out.println("1:1로 대화할 상대의 이름을 입력하세요: ");
                String targetName = in.readLine();
                ClientHandler targetClient = getClientByName(targetName);

                if (targetClient != null) {
                    out.println(targetName + "과(와) 연결되었습니다.");
                    handleConversation(targetClient);
                } else {
                    out.println("대상을 찾을 수 없습니다.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();  // 클라이언트 소켓 닫기
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 다른 클라이언트와 대화를 처리
        private void handleConversation(ClientHandler targetClient) throws IOException {
            String message;
            while ((message = in.readLine()) != null) {
                // 상대방에게 메시지 전송
                targetClient.out.println(clientName + ": " + message);
            }
        }

        // 클라이언트 이름으로 ClientHandler를 찾음
        private ClientHandler getClientByName(String name) {
            for (ClientHandler client : clientHandlers) {
                if (client.clientName.equals(name)) {
                    return client;
                }
            }
            return null;
        }
    }
}
