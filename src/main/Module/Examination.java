package main.Module;

import java.sql.Time;
import java.util.Date;

public class Examination {
    private ExaminationPaper examinationPaper;
    private Teacher createTeacher;
    private Time createTime, beginTime, endTime;
    private String status; // public, private

    public Examination() {
    }

    public ExaminationPaper getExaminationPaper() {
        return examinationPaper;
    }

    public void setExaminationPaper(ExaminationPaper examinationPaper) {
        this.examinationPaper = examinationPaper;
    }

    public Teacher getCreateTeacher() {
        return createTeacher;
    }

    public void setCreateTeacher(Teacher createTeacher) {
        this.createTeacher = createTeacher;
    }

    public Time getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }
}
