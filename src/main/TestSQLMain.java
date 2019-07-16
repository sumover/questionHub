package main;

import main.Module.Examination;
import main.Module.ExaminationPaper;
import main.Module.StudentAnswer;
import main.SQLConnctor.Connector;
import main.SQLConnctor.ExaminationOperator;
import main.SQLConnctor.ExaminationPaperOperator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class TestSQLMain {
    public static void main(String[] args) {
        Connector.connect_static();
        ExaminationOperator operator = new ExaminationOperator();
        operator.getExaminationList();
        Connector.disconnect_static();
    }
}
