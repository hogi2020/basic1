package ojmServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class OjmTimeServer extends Thread {
    // 클라이언트 - 서버 모델에서 데이터를 주고 받기 위해 사용
    private Socket socket;

    // 생성자 생성
    public OjmTimeServer(Socket s) {
        this.socket = s;
    }

    // Calender 클래스를 통해 실시간 시간 데이터 가져오기
    private String getTimeStr() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        return (hour < 10 ? "0" + hour:"" + hour) +":"+
                (min < 10 ? "0" + min:"" + min) + ":"+
                (sec < 10 ? "0" + sec:"" + sec);
    }


    // Thread 클래스의 run() 메서드이며, start() 메서드에 의해 실행됩니다.
    public void run() {
        // Start() 호출되면 JVM이 알아서 호출해줌
        System.out.println("run call....");

        // 예외처리를 하는 이유는 스레드가 외부에서 중단될 경우 대응하기 위한 것입니다.
        try {
            // getInputStream(): 데이터를 받기 위한 입력 스트림을 반환합니다.
            // getOutputStream(): 데이터를 보내기 위한 출력 스트림을 반환합니다.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true) {
                out.println(getTimeStr());              // 현재 시간을 읽어와서 출력을 내보냄
                try {
                    sleep(1000);                   // 스레드 함수 내 로 1초 멈춤
                } catch(InterruptedException i) {}      // 인터럽트가 발생했을 때의 예외처리
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nClient disconnected...\n");
            try {
                socket.close();
            } catch(IOException e) {}
        }
    }

    public static void main(String[] args) {
        int port =  2008;               // 클라이언트가 접속할 포트번호
        ServerSocket server = null;     // 서버에서 클라이언트의 연결 요청을 수신하고, 그 요청을 통해 새로운 통신용 소켓 생성
        Socket client = null;           // 서버와 클라이언트 양측에서 사용되며, 데이터를 주고받는 역할.

        try {
            server = new ServerSocket(port);
        } catch(IOException e) {
            System.out.println("Can't bind port: " + port);
            e.printStackTrace();

            try {
                server.close(); // 에러가 발생한 server를 반납합니다.
            } catch(IOException i) {}
            System.exit(1);     // 오류가 발생하거나 문제가 생겼을 때, 프로그램 강제 종료하는 코드
        }
        System.out.println("Time Server started successfully...");

        // 서버는 지속 작동해야 하므로 반복문 사용
        while(true) {

            try {
                client = server.accept();
                System.out.println("New Client connected...");

                // main 메소드에서 생성된 Socket을 멤버변수에 할당합니다.
                OjmTimeServer otServer = new OjmTimeServer(client);
                // start() 메소드는 새로운 스레드를 시작하는 메소드 입니다. 호출되면 run() 메서드가 실행됩니다.
                otServer.start();

            } catch(IOException e) {
                System.out.println("Can't start server thread!!");
                e.printStackTrace();

                try {
                    client.close();
                } catch(IOException i) {}
            }
        }
    }
}
