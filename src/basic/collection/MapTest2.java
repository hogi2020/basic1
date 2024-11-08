package basic.collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
    public static void main(String[] args) {
        // key에는 String 타입만 가능함, value에는 Object 타입이면 모두 가능함.
        HashMap<String, Object> map = new HashMap<>();

        map.put("name", "나신입");
        map.put("school", "가산대학교");
        map.put("address", "서울시 마포구 공덕동");
        map.put("age", String.valueOf(30));
    }
}


/*
변수 - 같은 타입만 담을 수 있다.
배열 - 같은 타입만 담을 수 있다. 크기가 고정이다.
컬렉션 프레임워크 - 다른 타입도 담을 수 있다. 크기도 늘었다. 줄었다. 한다.
- Object 타입이라면 모두 담는다. (원시형은 안된다.)
- int -> Integer, double -> Double, 원시형이더라도 wrapper 클래스가 있다.
 */