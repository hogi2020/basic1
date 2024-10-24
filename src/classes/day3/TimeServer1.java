package classes.day3;

// 실행 순서로 반드시 TimeServer 먼저 실행하고 그 다음에 TimeClient를 실행할 것
// TimeServer.java: 1초간격으로 현재의 시간 문자열을 접속한 클라이언트에게 전송하는
//프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer1 extends Thread {

    private Socket socket;

    public TimeServer1(Socket s) {  // s -> main 메소드의 클라이언트
        // 아래 코드에 대해 말할 수 있습니다.
        // 전역변수와 초기화를 시킴 - nullpointer
        // 얕은복사 즉, 원본을 다른 메소드(run)에서 사용하기 위해서 꼭 필요함.
        // socket 변수를 run 메소드에서 사용할 때, NullPointerException 발동됨.
        this.socket = s;
    }

    // run() 시작
    public void run() {     // Start() 호출되면 JVM이 알아서 호출해줌 - 콜백함수(actionPerformed)
        System.out.println("run call....");
        try {
            // PrintWriter 출력할 때, 사용하는 클래스와 Socket은 의존관계에 있습니다.
            // socket이 null이면 PrintWriter 객체가 생성이 안됩니다.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // BufferedReader는 필터 스트림 입니다. 실제 듣기를 제공하는 클래스는
            // inputStreamReader 클래스 입니다. - 듣기 성능 향상을 위해 사용한 필터 스트림
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while(true) {
                out.println(getTimeStr());  // 현재 시간을 읽어와서 출력을 내보냄
                try {
                    sleep(1000);    // 밀리세크단위 1000이 1초임. 멈춤
                } catch(InterruptedException i) {}
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nClient disconnected...\n");
            try {
                socket.close();
            } catch(IOException e) {}
        }
    } // run() 종료


    // getTimeStr() 시작
    private String getTimeStr() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        return (hour < 10 ? "0" + hour : "" + hour) + ":" +
                (min < 10 ? "0" + min : "" + min)  +	":" +
                (sec < 10 ? "0" + sec : "" + sec) ;
    } // getTimeStr() 종료


    // main() 시작
    public static void main(String args[]) {
        int port = 2008;                // 클라이언트가 접속할 서버의 IP주소를 반영해야함.
        ServerSocket server = null;     // 동시에 여러 사용자를 받는 소켓임 | 서버 소켓은 듣고 말하기에 관여하지 않습니다.
        Socket client = null;           // 듣고 말하기에 관여하는 소켓
        // 이 소켓이 있어야 InputStream과 OutputStream을 생성할 수 있습니다.
        // 즉 서로 의존관계에 있고, null이면 생성이 불가합니다.
        // 듣기와 말하기 모두 불가합니다.
        try {
            server = new ServerSocket(port);    // 파라미터로 2008번을 넘김
        } catch(IOException e) {                // 예외처리
            // 프로그램의 임의 중단을 막고 예외가 발생하더라도 반드시 해야할 후처리가 있다.
            // 후처리를 위해 예외처리는 필수임.
            System.out.println("Can't bind port: " + port);
            e.printStackTrace();
            try {
                // 사용한 자원에 대해서는 명시적으로 반납처리를 합니다.
                // open 되어 있으면 불순한 목적으로 위변소를 할 수 있습니다.
                server.close();
            } catch(IOException i) {}
            System.exit(1);
        }
        System.out.println("Time Server started successfully...");
        while(true) {       // 반복문 파라미터의 true가 있음 - 무한반복 - 왜냐면 서버니까.
            try {
                // 이 지점에서 기다림이 발생합니다. 언제까지 사용자가 new Socket(ip.port)할 때까지
                client = server.accept();                           // 접속이 들어오면 낚아챈다. - 스레드(실행흐름)
                System.out.println("New Client connected...");      // 누가 왔음
                // Client는 Socket타입이다. - 이것이 있어야 말하고 듣고 할 수 있습니다.
                // 왜 생성자 파라미터로 넘기나요? - 다른 사용자 정의 메소드에서 쓰려고.
                TimeServer1 tServer = new TimeServer1(client);      // 생성자 호출
                tServer.start();                                    // 스레드가 동작하는 run 메소드를 호출해줌
                // 사용자가 직접 스레드를 컨트롤 하지 못함 - 보호
                // 결합도를 낮추기 위해서임. 결합도가 높으면 재사용성이 떨어집니다.
                // 결합도가 높으면 단위테스트와 통합테스트가 어려워집니다.
                // 코드의 양은 늘어나더라도 복잡도가 증가하지 않도록 코딩하기
                System.out.println("New Time Server Thread started...");
            } catch(IOException e) {
                System.out.println("Can't start server thread!!");
                e.printStackTrace();
                try {
                    client.close();
                } catch(IOException i) {}
            }
        }
    } // main() 종료
}

/*
프로그램 동작 과정
1. 서버는 2008번 포트에서 클라이언트 연결을 기다립니다.
sever = new ServerSocket(2008);//1~65570 사이의 숫자 사용함.
1~1023번까지는 윈도우 운영체제가 사용하므로 피한다.

2. 클라이언트가 연결(new Socket("172.16.90.45"))되면
새로운 스레드가 생성되어서 해당 클라이언트에게 1초마다 현재 시간을 전송합니다.
: 객체를 생성할 때, 서버소켓에 접속을 시도하게 됩니다. 다른 코드는 없습니다.

3. 클라이언트가 연결을 종료하면 해당 스레드는 종료됩니다.
스레드 클래스가 사용자에 대해서 라이프사이클을 관리합니다. (생성-활용-죽음)

4. 서버는 새로운 클라이언트가 연결될 때까지 계속 대기하며
연결이 될 때마다 새로운 스레드를 생성합니다. (깊은복사)
 */