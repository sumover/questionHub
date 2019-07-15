package main.Module;

import java.util.LinkedList;
import java.util.List;

public class StudentAnswer {
    private int id;
    private Student student;
    private Examination examination;
    private List<String> answerList;

    public StudentAnswer() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /**
     * parse 的格式举例
     * (A),(B),(211321),(sadas(23333))
     * 那么答案分别为:
     * A, B, 211321, sadas(23333)
     * 请用stack对字符串进行解析
     *
     * @param parse 被解析的字符串
     * @return 答案列表
     */
    public static List<String> parseAnswerListFromString(String parse) {
        List<String> answerList = new LinkedList<String>();
        // TODO 解析字符串, 如注释说明, 目前仅考虑只有选择题的情况
        int index = 0, left;
        do {
            left = nextLeftBracket(parse, index);
            index = nextRightBracket(parse, left);
            answerList.add(parse.substring(left + 1, index));
        } while (nextLeftBracket(parse, index) != -1);
        return answerList;
    }

    private static int nextLeftBracket(String parse, int index) {
        return parse.indexOf("(", index);
    }

    private static int nextRightBracket(String parse, int index) {
        return parse.indexOf(")", index);
    }

    public static String formatAnswerList(List<String> answerList) {
        String ans = "";
        for (String s : answerList) {
            ans += "(" + s + "),";
        }
        return ans;
    }
}
