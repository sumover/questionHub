package main.Module;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.StringReader;
import java.util.*;


public class MultipleChoice extends Question {
    private String describe;
    private List<Options> options;

    public MultipleChoice(int score, String describe, List<Options> options) {
        super(score, "multipleChoice");
        this.describe = describe;
        this.options = new LinkedList<Options>(options);
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public MultipleChoice() {
        super();
        super.setType("multipleChoice");
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
        Iterator<Options> iterator = optionList.iterator();
        String json = "{\n";
        Options options = iterator.next();
        json += "\"" + options.c + "\" : \"" + options.describe + "\"";

        while (iterator.hasNext()) {
            options = iterator.next();
            json += ",\n\"" + options.c + "\" : \"" + options.describe + "\",\n";
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
