package jdbc.book;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BookNaverSearch extends JDialog {
    BookApp ba = null;
    String[] cols = {"도서번호","도서명", "저자","출판사"};
    String[][] data = new String[0][4];
    DefaultTableModel dtm_book = new DefaultTableModel(data, cols);
    JTable jtb_book = new JTable(dtm_book);
    JScrollPane jsp_book = new JScrollPane(jtb_book,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String clientId = "cXo0_LIWIljK5FqlP24I"; //애플리케이션 클라이언트 아이디
    String clientSecret = "Dde77rglEu"; //애플리케이션 클라이언트 시크릿
    String apiURL = "https://openapi.naver.com/v1/search/book.json";
    public BookNaverSearch() {}
    public BookNaverSearch(BookApp ba) {
        this.ba = ba;
        initDisplay();
        String query = JOptionPane.showInputDialog("검색어를 입력하세요.");
        List<Map<String,Object>> list = searchBooks(query);
        refreshData(list);
    }
    public void refreshData(List<Map<String,Object>> list){
        for(int i=0;i < list.size();i++){
            Map<String,Object> rMap = list.get(i);
            Vector<Object> v = new Vector<>();
            v.add(rMap.get("isbn"));
            v.add(rMap.get("title"));
            v.add(rMap.get("author"));
            v.add(rMap.get("publisher"));
            dtm_book.addRow(v);
        }
    }
    public List<Map<String,Object>> searchBooks(String query){
        List<Map<String,Object>> list = null;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiURL+"?query="+query)
                .addHeader("X-Naver-Client-Id", clientId)
                .addHeader("X-Naver-Client-Secret", clientSecret)
                .build();
        try(Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Gson gson = new Gson();
                //JSON응답에서 items 배열만 추출하여 List<Map<String,Object>>형태로 변환
                java.lang.reflect.Type listType = new TypeToken<List<HashMap<String,Object>>>(){}.getType();
                Map<String,Object> resultMap = gson.fromJson(json, Map.class);
                list = gson.fromJson(gson.toJson(resultMap.get("items")), listType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public void initDisplay(){
        //System.out.println("initDisplay");
        //System.out.println(this.ba);//null
        this.add(jsp_book);
        this.setSize(700,500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new BookNaverSearch(null);
    }
}
