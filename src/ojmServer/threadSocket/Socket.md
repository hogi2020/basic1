### 소켓
- 자바에서는 소켓(Socket)이라는 개념을 통해서 네트워크 통신;
- 네트워크 7계층에서 소켓은 네트워크의 끝부분을 의미합니다.
- 실제 데이터가 어떻게 전송되는지 상관하지 않고, 읽기/쓰기 인터페이스를 지원합니다.
- 네트워크 계층이나, 전송계층이 캡슐화 되어 있기 때문에 두 개의 계층을 신경쓰지 않고, 프로그램을 작성할 수 있습니다.
- 자바는 이식성이나 플랫폼 독립적인 프로그램을 지원하기 위해서 소켓을 핵심 라이브러리로 만들었습니다.
- TCP/IP 계층의 TCP를 지원하기 위해서 Socket, ServerSocket 클래스 제공함.
- (널널한 개발자 | 유튜버)
- 클라이언트의 경우, Socket 객체를 생성해서 TCP서버와 연결을 시도합니다.
- 서버쪽에서는 ServerSocket을 사용하여 클라이언트로부터의 연결을 송수신하는 역할을 합니다.
- 클라이언트는 Socket 클래스만 주로 사용함.


#### **소켓에 담기는 정보**
```java
InetAddress serverAddress = socket.getInetAddress();  // 연결된 서버의 IP 주소 가져오기
int serverPort = socket.getPort();                    // 원격 서버 포트 번호
int localPort = socket.getLocalPort();                // 로컬 머신의 포트 번호
InputStream in = socket.getInputStream();             // 데이터 읽기용 입력 스트림
OutputStream out = socket.getOutputStream();          // 데이터 전송용 출력 스트림
boolean isClosed = socket.isClosed();                 // 소켓이 닫혔는지 확인
boolean isConnected = socket.isConnected();           // 소켓이 연결되었는지 확인
```


### 서버측
- ServerSocket 생성 - 생성자도 호출된다. 생성자도 괄호있다. 파라미터가 올 수 있다.
- 클래스 생성자 파라미터 자리가 대단히 중요합니다. 클래스 사이의 관계를 설정, 
