package main.SQLConnctor;

import main.Module.Question;
import main.SQLConnctor.Exception.NoAnswerException;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AnswerOperator {
    private Connector connector = Connector.getInstance();

    public AnswerOperator() {
    }

    /**
     * @param questionId 题目的id
     * @return id为id的question的ans
     * @throws NoAnswerException
     */
    public String getAnswerByQuestion(int questionId) throws NoAnswerException {
        String ans = null;
        int qid = questionId;
        ResultSet resultSet = connector.selectValues(
                "select * from answer\n" +
                        "where question_id=?;",
                new String[]{
                        Integer.toString(qid)
                }
        );
        try {
            if (resultSet.next()) {
                ans = resultSet.getString(2);
                resultSet.close();
            } else {
                throw new NoAnswerException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    /**
     * @param questionId 题目的id
     * @param ans        答案
     * @return 是否为update
     */
    public boolean updateAnswerBuQuestion(int questionId, String ans) {
        boolean status = false;
        ResultSet resultSet = connector.selectValues(
                "select * from answer\n" +
                        "where question_id=?;",
                new String[]{
                        Integer.toString(questionId)
                }
        );
        try {
            if (resultSet.next()) {
                connector.deleteValues(
                        "delete from answer\n" +
                                "where id=?;",
                        new String[]{
                                Integer.toString(questionId)
                        }
                );
                status = true;
            }
            connector.insertValues(
                    "insert into answer (ans, question_id) \n" +
                            "values (?,?);",
                    new String[]{
                            ans,
                            Integer.toString(questionId)
                    }
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
