package main.Module;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Examination {
    private ExaminationPaper examinationPaper;
    private Teacher createTeacher;
    private Date createTime, beginTime, endTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
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


    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Date parseFromSQL(String dateFromSQL) {
        try {
            return simpleDateFormat.parse(dateFromSQL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseFromDate(Date date) {
        return simpleDateFormat.format(date);
    }
}
