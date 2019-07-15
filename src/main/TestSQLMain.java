package main;

import main.Module.ExaminationPaper;
import main.Module.StudentAnswer;
import main.SQLConnctor.Connector;
import main.SQLConnctor.ExaminationPaperOperator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class TestSQLMain {
    public static void main(String[] args) {
//        Connector.connect_static();
//        Connector.disconnect_static();
        String parse = "(A),(B),(C)";
//        System.out.println(parse);
//        System.out.println(parse.substring(1, 2));
        List<String> stringList = StudentAnswer.parseAnswerListFromString(parse);
        for (String o : stringList) {
            System.out.println(o);
        }
        System.out.println(StudentAnswer.formatAnswerList(stringList));
    }
}
