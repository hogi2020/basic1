package ojmServer.multiThread;

import java.io.*;
import java.net.*;

public class SampleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println("서버에 연결되었습니다.");

            // 서버와 통신하기 위한 입출력 스트림
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // 서버로부터 메시지 수신하는 스레드
            new Thread(new ServerListener(in)).start();

            // 사용자 입력을 서버로 전송
            String message;
            while ((message = userInput.readLine()) != null) {
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 서버로부터 메시지를 수신하는 스레드
    static class ServerListener implements Runnable {
        private BufferedReader in;

        public ServerListener(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);  // 서버로부터 받은 메시지 출력
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
