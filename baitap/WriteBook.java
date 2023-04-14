package JSON.baitap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteBook {
    public static void main(String[] args) {
        JSONObject BookDetails = new JSONObject();
        BookDetails.put("id","01");
        BookDetails.put("name","Đắc nhân tâm ");
        BookDetails.put("price","300.000");
        BookDetails.put("author","Dale Carnegie");

        JSONObject BookObject = new JSONObject();
        BookObject.put("book",BookDetails);

        JSONObject BookDetails2 = new JSONObject();
        BookDetails2.put("id","02");
        BookDetails2.put("name","The Lean Startup");
        BookDetails2.put("price","200.000");
        BookDetails2.put("author","Eric Rise");

        JSONObject BookObject2 = new JSONObject();
        BookObject2.put("book",BookDetails2);

        JSONArray BookList = new JSONArray();
        BookList.add(BookObject);
        BookList.add(BookObject2);

        try(FileWriter file = new FileWriter("book.json")){
            file.write(BookList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
