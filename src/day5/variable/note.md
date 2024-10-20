## 자바 언어 기초

### 1. 자료형의 종류
- char < byte < short < int < long < float < double
- int VS long의 차이는 32비트인가 64비트인가만 다릅니다.

```java
    var x = 1;      // 런타임시에 값을 통해 타입이 결정됨
    int i = 1;
    long l = 5L;
    float f1 = 3.14f;   // f는 생략불가
    double d1 = 3.14d;  // d는 생략가능
    byte b1 = 5;        // 결국 JVM은 int로 변환하여 연산
```

- 자료형의 크기가 고정되어 있습니다.
- 부호가 있는 자료형만 존재합니다.
- 자바는 signed, unsigned가 없습니다. (C에는 있음)

```java
    void methodA(int age) {
        if(age < 0) return;
    }
    int param = -10;
```


### 2. char
- char는 유니코드라서 16비트(2바이트)입니다.
- 자바의 유일한 부호가 없는 자료형 입니다.
- 유니코드 최대값은 U+FFFF
- 저 값보다 큰 유니코드를 표현하려면 String 쓴다.
- 문자를 담을 수 없습니다.
- String은 기본 데이터형이 아니므로 정확히 몇 바이트인지 알 수 없음.

### 3. 리터럴
- 객체(개체) -> null
- 16진수 공식 리터럴은 Ox로 시작됨.
- 8진수 리터럴은 0으로 시작됨.
- 2진수 리터럴은 0b로 시작됨.
- float의 리터럴은 f, F
- double의 리터럴은 d, D - 보통 생략함
- 문자 리터럴은 작은 따옴표 사용 (하나의 문자)
- 문자열 리터럴은 큰 따옴표 사용 (하나이상의 문자열)

### 4. String
- new를 사용한 인스턴스 변수를 비교연산자 ==로 비교하면 주소번지가 다르기 때문에 False가 나옵니다.
- 실제값이 같은지 확인할 때는 .equals()를 사용하여 리터럴 값을 비교합니다.

<br />

## 객체 만들기와 메모리
- 자바에서는 원시형만 stack에 넣을 수 있습니다.
- (primative data type VS reference data type)
- 클래스(참조형)는 모두 heap에 넣을 수 있습니다.
- People p = new People(); 새로운 Peaple이 만들어집니다.
- 그 People의 이름은 p 입니다.

### 1. 힙에 새로운 객체 생성
- Object 이해 : 객체 vs 개체
- OOP에서의 의미는 물체 또는 생명체를 의미합니다.
- 개체라고 번역하는 경우가 점점 늘어나고 있습니다.

### 2. 인스턴스(instance)
- 객체를 부르는 또 다른 표현임
- 어떤게 발현한 사건을 인스턴스라고 함.
- 어떤 클래스에 속하는 객체의 한 예입니다.
- 인스턴스화(instantiation) : 클래스로부터 객체 하나를 만드는 행위

### 3. 객체 생성
- ex) People scott = new People();
- ex) Human tiger = new Human();
- People, Human 모두 참조형 입니다.

