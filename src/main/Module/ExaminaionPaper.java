package main.Module;

import java.util.Date;
import java.util.List;

public class ExaminaionPaper {
    private List<Question> questionList;
    private int id;
    private String name;
    private Date createDate;
    private Teacher createTeacher;
    private static int EXAMINAIONPAPER_NUM = 0;

    public ExaminaionPaper(List<Question> questionList, String name, Date createDate, Teacher createTeacher) {
        this.questionList = questionList;
        this.name = name;
        this.createDate = createDate;
        this.createTeacher = createTeacher;
        this.id = EXAMINAIONPAPER_NUM++;
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
}