package main;

import main.Module.ExaminationPaper;
import main.Module.Question;
import main.SQLConnctor.Connector;
import main.SQLConnctor.MultipleChoiseQuestionOpertor;

import java.util.Arrays;

public class TestSQLMain {
    public static void main(String[] args) {
        Connector.connect_static();
        MultipleChoiseQuestionOpertor questionOpertor = new MultipleChoiseQuestionOpertor();
        Question[] questions = new Question[4];
        for (int i = 0; i < 4; ++i) {
            questions[i] = questionOpertor.getQuestionInSQL(i + 1);
        }
        System.out.println(ExaminationPaper.parseQuestionListToIdList(Arrays.asList(questions)));
        Connector.disconnect_static();
    }
}
