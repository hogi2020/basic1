# Java 학습 내용 정리


## 1. Java(자바) 기초

1) 변수 선언 및 초기화
    - 클래스 영역에서는 변수 선언과 초기화를 분리할 수 없습니다.
    - 메소드 영역에서는 변수 선언과 초기화를 분리할 수 있습니다.

2) 메모리
    - stack에는 변수와 메소드가 저장
    - 메모리가 부족해지면 오버플로우가 발생하므로 stack에서는 메소드가 종료되면 해당 메모리 영역을 초기화합니다.
    - heap에는 객체와 인스턴스가 저장
    - heap은 {} 중괄호 안에 인스턴스들이 저장됨

3) 원시형 변수와 참조형 변수
    - 원시형 변수 : 단순한 값을 저장하는 변수 | 스택 영역에 저장됨
    - 참조형 변수 : 주소를 저장하는 변수 | 힙 메모리에 저장됨

4) 클래스의 인스턴스화
    - 클래스의 전역변수나 메소드를 활용하는 방법
    - 클래스의 인스턴스를 힙 메모리에 할당

5) JDK
    - JDK는 JVM, JRE, 컴파일러, 개발도구로 구성
    - JVM은 자바 애플리케이션을 운영체제에서 실행되도록 돕습니다.
    - JRE는 자바 프로그램을 실행하는데 필요한 환경과 라이브러리를 의미합니다.
    - 컴파일러(javac)는 자바 소스 파일(.java)을 JVM이 이해할 수 있는 바이트코드(.class)로 변환합니다.
    - 개발 도구는 디버거, 문서 생성기 등 개발을 지원하는 도구들을 의미합니다.

6) 타입의 종류
    - 문자열 : String (참조형 클래스)
    - 정수형 : int
    - 논리형 : boolean
    - 실수형 : float, double

7) 예약어 new는 클래스의 인스턴스를 힙 메모리에 할당하는 역할을 합니다.

8) 접근제한자
    - public | 모든 클래스에서 접근 가능

    - private | 해당 클래스 내에서만 가능
    - default | 동일 패키지 내에서 접근 가능, 다른 패키지에서는 접근 불가
    - protected | 동일 패키지 내에서 접근 가능하며, 다른 패키지에서는 접근 불가하나 "다른 패키지에 있는 하위 클래스"에서도 접근 가능

9) 형변환
    - int에서 double로 형변환 (묵시적 형변환)
    - double에서 int로 형변환 (강제 형변환)
    - 강제 형변환 시, 변수값 앞에 () 명시

10) static (정적 키워드)
    - static 키워드로 선언된 변수는 클래스 변수라고 불립니다.
    - 객체를 생성하지 않아도 호출하면 전역변수가 됩니다.
    - 인스턴스 변수와 달리 static 변수는 객체와 관계없이 클래스 차원에서 공유됩니다.