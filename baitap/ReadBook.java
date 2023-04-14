package JSON.baitap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadBook {
    public static void main(String[] args) {
        JSONParser jsonBook = new JSONParser();
        try(FileReader reader = new FileReader("book.json"))
        {
            Object BookObject = jsonBook.parse(reader);

            JSONArray BookList = (JSONArray) BookObject;
            System.out.println(BookList);

            BookList.forEach( emp -> parseBookObject( (JSONObject) emp) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    private static void parseBookObject(JSONObject book){
        JSONObject bookObject = (JSONObject) book.get("book");

        String id = (String) bookObject.get("id");
        System.out.println(id);

        String name = (String) bookObject.get("name");
        System.out.println(name);

        String price = (String) bookObject.get("price");
        System.out.println(price);

        String author = (String) bookObject.get("author");
        System.out.println(author);
    }
}
