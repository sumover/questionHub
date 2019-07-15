package main.SQLConnctor;

import main.Module.MultipleChoice;
import main.Module.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MultipleChoiceQuestionOpertor extends QuestionOperator {
    @Override
    int insertIntoTypeTable(Question question) {
        MultipleChoice multipleChoiceQuestion = (MultipleChoice) question;
        return connector.insertValues(
                "insert into web_note_databases.multiple_choice_questions (`describe`, options) \n" +
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
                "delete from web_note_databases.multiple_choice_questions \n" +
                        "where id=?;",
                new String[]{Integer.toString(id)}
        );
    }

    @Override
    public Question getQuestionInSQL(int id) {
        MultipleChoice multipleChoice = new MultipleChoice();
        try {
            ResultSet questionResult = connector.selectValues("select * from web_note_databases.questions \n" +
                    "where id=?;", new String[]{Integer.toString(id)});
            questionResult.next();
            int anotherId = questionResult.getInt(4);
            ResultSet multipleChoiceResult = connector.selectValues("\n" +
                    "select * from web_note_databases.multiple_choice_questions\n" +
                    "where id=?;", new String[]{Integer.toString(anotherId)});
            multipleChoiceResult.next();
            multipleChoice.setId(id);
            multipleChoice.setDescribe(multipleChoiceResult.getString(2));
            multipleChoice.setScore(questionResult.getInt(2));
            multipleChoice.setOptions(
                    MultipleChoice.getOptionsListByJSON(multipleChoiceResult.getString(3))
            );
            multipleChoiceResult.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return multipleChoice;
    }
}
