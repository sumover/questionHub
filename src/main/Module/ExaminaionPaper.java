package main.Module;

import java.util.Date;
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
}