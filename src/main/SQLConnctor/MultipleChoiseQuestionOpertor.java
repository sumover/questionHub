package main.SQLConnctor;

import main.Module.MultipleChoice;
import main.Module.Question;

import java.sql.ResultSet;

public class MultipleChoiseQuestionOpertor extends QuestionOperator {
    @Override
    int insertIntoTypeTable(Question question) {
        MultipleChoice multipleChoiceQuestion = (MultipleChoice) question;
        return connector.insertValues(
                "insert into web_note_databases.multiple_choise_questions (\"describe\", options) \n" +
                        "values (?, ?);",
                new String[]{
                        multipleChoiceQuestion.getDescribe(),
                        MultipleChoice.getOptionsJsonByList(multipleChoiceQuestion.getOptions())
                }
        );
    }

    @Override
    public void deleteTypeQuestion(int id) {
        connector.deleteValues(
                "delete from web_note_databases.multiple_choise_questions \n" +
                        "where id=?;",
                new String[]{Integer.toString(id)}
        );
    }
}
