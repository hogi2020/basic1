# 하나의 어플리케이션을 두 개의 클래스로 관리하기

- NoticeMain.java
- NoticeDialog.java


1. NoticeMain은 JFrame을 상속받고, NoticeDialog는 JDialog클래스를 상속 받는다.
2. NoticeMain.java에서 사용하는 this는 NoticeMain과 JFrame을 포함하고 있는 NoitceDialog에서 사용하는 this는 JDialog도 포함된다.
3. 두 클래스 모두 화면 처리는 initDisplay()를 활용합니다. initDisplay()는 사용자 정의 함수이므로 this를 사용 가능 합니다.
4. main() NoticeMain에만 구현하고, NoticeDialog에서는 단위테스트 용도로 사용한 후 폐기합니다.
5. 생성자를 적극 활용해봅니다. (객체 주입: 의존성 주입) - 클래스와 클래스 사이에는 관계가 있습니다.
6. 두 클래스가 상속관계가 아니더라도 업무적인 관계가 있습니다. 결론은 클래스 사이의 관계를 통해서 업무에 대한 처리 완섬됨(얕은 복사, 유지되도록 코드 [깊은 복사로 한다면 의도하지 않은 문제가 발생함.])
7. 하나(얕은복사, 공유)의 화면으로 입력, 상세보기, 수정 등 세가지를 처리해본다.
8. 인스턴스화의 위치가 중요합니다.[위치에 따라 NullPointerException 발동하기도 하고, 아니기도 합니다.]
9. static이 아닌 모든 문제들을 풀어보세요.


## 프로젝트 역할 구분
1. 프로토콜 설계 : 메신저니까... 대화방, 다자간 대화방, 강퇴, 나가기 등의 프로토콜
2. DB 설계
3. 화면정의서 필요
4. 