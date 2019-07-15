package main;

import main.Module.ExaminationPaper;
import main.SQLConnctor.Connector;
import main.SQLConnctor.ExaminationPaperOperator;

public class TestSQLMain {
    public static void main(String[] args) {
        Connector.connect_static();
        ExaminationPaperOperator operator = new ExaminationPaperOperator();
        ExaminationPaper examinationPaper = operator.getExaminationPaper(1);
        operator.addExaminationPaper(examinationPaper);
        Connector.disconnect_static();
    }
}
