package main;

import main.Module.ExaminationPaper;
import main.SQLConnctor.Connector;
import main.SQLConnctor.ExaminationPaperOperator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestSQLMain {
    public static void main(String[] args) {
//        Connector.connect_static();
//        Connector.disconnect_static();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = formatter.parse("2019-05-11 11:22:33");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
