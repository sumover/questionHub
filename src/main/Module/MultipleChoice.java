package main.Module;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import java.util.LinkedList;
import java.util.List;

class Options {
    public char c;
    public String describe;

    public Options(char c, String describe) {
        this.c = c;
        this.describe = describe;
    }

}

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

    public static List<Options> getOptionsListByJSON(String json) {
        List<Options> optionsList = new LinkedList<Options>();

        return optionsList;
    }
}
