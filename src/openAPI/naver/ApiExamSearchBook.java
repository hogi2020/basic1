package openAPI.naver;

// 네이버 검색 API 예제 - 블로그 검색
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection; // 웹 http
import java.net.MalformedURLException;  // 웹 요청 시 발생 예외
import java.net.URL;
import java.net.URLEncoder; // 인코더 한글 (깨짐)
import java.util.ArrayList;
import java.util.HashMap;   // Map의 구현체 클래스이다. (Hashtable)
import java.util.List;
import java.util.Map;       // Map`은 인터페이스 이다.


public class ApiExamSearchBook {

    public List<Map<String, Object>> getBookList(String result) {
        List<Map<String, Object>> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("items");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            // System.out.println(item.getString("link"));

            Map<String, Object> bookMap = new HashMap<>();
            bookMap.put("title", item.getString("title"));
            bookMap.put("author", item.getString("author"));
            bookMap.put("publisher", item.getString("publisher"));
            bookMap.put("isbn", item.getString("isbn"));
            bookMap.put("image", item.getString("image"));
            bookMap.put("link", item.getString("link"));
            bookMap.put("pubdate", item.getString("pubdate"));
            bookMap.put("description", item.getString("description"));

            list.add(bookMap);
        }

        for (Map<String, Object> map : list) {
            System.out.println(map);
        }


        return list;
    }

    public static void main(String[] args) {
        ApiExamSearchBook asb = new ApiExamSearchBook();

        String clientId = "HIo6FH0hSKpUX3yKgvj5"; //애플리케이션 클라이언트 아이디
        String clientSecret = "eSzHpKmLMt"; //애플리케이션 클라이언트 시크릿


        String query = null;
        try {
            // 사용자로부터 책이름 입력 받아오기
            query = JOptionPane.showInputDialog("검색할 책이름을 쓰시오.");
            query = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        // 네이버 웹서버에 요청(요청객체 지원)을 위한 URL이다.
        String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + query;    // JSON 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);
        System.out.println(responseBody);
        asb.getBookList(responseBody);

    }


    /**********************************************************************
     *
     * @return: API 공통를 반환합니다.
     *********************************************************************/

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        // conncet 메소드를 호출할 때, 파라미터로 네이버 책 검색 URL을 넘깁니다.
        // 그 URL을 가지고 HttpURLConnection 객체를 생성합니다.
        // 네이버 웹 서버에 get 방식으로 요청한다는 것을 설정하기 - setRequestMethod("GET|POST|PUT|PATCH|DELETE")
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출 - 200;
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
}