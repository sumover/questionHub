package main.Module;

import javax.json.*;
import java.io.StringReader;
import java.util.*;


public class MultipleChoice extends Question {
    private String describe;
    List<Options> options;

    public MultipleChoice(int score, String describe, List<Options> options) {
        super(score, "MultipleChoice ");
        options = new LinkedList<Options>();
    }

    public MultipleChoice() {
    }

    public void addOptions(char c, String describes) {
        options.add(new Options(c, describes));
    }

    public List<Options> getOptions() {
        return options;
    }

    public String getDescribe() {
        return describe;
    }

    public static String getOptionsJsonByList(List<Options> optionList) {
        String json = "{\n";
        for (Options option :
                optionList) {

        }
        return json + "\n}";
    }

    public static List<Options> getOptionsListByJSON(String jsonString) {
        List<Options> optionsList = new LinkedList<Options>();
        JsonReader reader = Json.createReader(new StringReader(jsonString));
        JsonObject jsonObject = reader.readObject();
        Set<Map.Entry<String, JsonValue>> entries = jsonObject.entrySet();
        Iterator<Map.Entry<String, JsonValue>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonValue> entry =
                    iterator.next();
            optionsList.add(new Options(entry.getKey().charAt(0), entry.getValue().toString()));
        }
        return optionsList;
    }
}
