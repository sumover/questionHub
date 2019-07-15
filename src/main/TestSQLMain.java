package main;

import main.Module.*;
import main.SQLConnctor.Connector;
import main.SQLConnctor.MultipleChoiseQuestionOpertor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestSQLMain {
    public static void main(String[] args) {
        Connector.connect_static();

        MultipleChoiseQuestionOpertor questionOpertor = new MultipleChoiseQuestionOpertor();
        MultipleChoice multipleChoice = new MultipleChoice(
                5, "are you shadiao?",
                new LinkedList<Options>(Arrays.asList(new Options('A', "YES"),
                        new Options('B', "NO")))
        );
//        questionOpertor.insertIntoQuestions(multipleChoice);
        multipleChoice.setId(12);
        questionOpertor.deleteQuestion(multipleChoice);
        Connector.disconnect_static();
    }
}
