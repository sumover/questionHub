package main.Module;

import java.util.LinkedList;
import java.util.List;

class Options {
    char c;
    String describe;

    public Options(char c, String describe) {
        this.c = c;
        this.describe = describe;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}

public class MultipleChoice extends Question {
    private String describe;
    List<Options> options;

    public MultipleChoice(int score, String describe, List<Options> options) {
        super(score, QUESTION_TYPE.multiple_choice);
        options = new LinkedList<Options>();
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
}
