package main.Module;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExaminaionPaper {
    private int id;
    private String name;
    private Date createDate;
    private Teacher createTeacher;
    private List<Question> questionList;
    private String note;


    public ExaminaionPaper(List<Question> questionList, String name, Date createDate, Teacher createTeacher) {
        this.questionList = questionList;
        this.name = name;
        this.createDate = createDate;
        this.createTeacher = createTeacher;
    }

    public ExaminaionPaper() {
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Teacher getCreateTeacher() {
        return createTeacher;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCreateTeacher(Teacher createTeacher) {
        this.createTeacher = createTeacher;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    /**
     * @param questionList 被解析的问题id列表， 直接从数据库里爬的
     * @return 解析完的数组
     */
    public static int[] parseQuestionIdList(String questionList) {
        List<Integer> list = new LinkedList<Integer>();
        int id = 0;
        for (int i = 0; i < questionList.length(); ++i) {
            char c = questionList.charAt(i);
            if (Character.isDigit(c)) {
                id = id * 10 + c - '0';
            } else {
                list.add(id);
            }
        }
        list.add(id);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; ++i)
            arr[i] = list.get(i);
        return arr;
    }

    /**
     * 把questionList编码为可存放在数据库内且可解析的字符串
     *
     * @param questionList 被编码的list
     * @return 编好的字符串
     */
    public static String parseQuestionListToIdList(List<Question> questionList) {
        String parse = Integer.toString(questionList.get(0).getId());
        for (int i = 1; i < questionList.size(); ++i)
            parse += " " + Integer.toString(questionList.get(i).getId());
        return parse;
    }

}