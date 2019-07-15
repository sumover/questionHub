package main.SQLConnctor;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import java.io.StringReader;

public class TestSQLMain {
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "            \"A\":0, \n" +
                "            \"B\":1\n" +
                "        }";
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        JsonArray array = jsonReader.readArray();
        System.out.println(array);
        jsonReader.close();
    }
}
