package main.SQLConnctor;

import main.Module.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 模板模式, 其中, insertIntoTypeTable下放到子类中, 在题目插入相关表前,
 * 会先在相关类型的表中插入题目,
 */
public abstract class QuestionOperator {
    Connector connector;
    private boolean autoSetId = true;

    QuestionOperator() {
        connector = Connector.getInstance();
    }

    public void setAutoSetId(boolean autoSetId) {
        this.autoSetId = autoSetId;
    }

    public boolean getAutoSetId() {
        return autoSetId;
    }

    /**
     * 模板模式, 将各种类型的题插入到那个表的方法下放到子类
     *
     * @param question 要被插入的题类型, 请主动变换类型
     * @return 返回相关类型表的刚刚插入题的id
     */
    abstract int insertIntoTypeTable(Question question);

    /**
     * @param question 被插入的题的类型
     * @return
     */
    public int insertIntoQuestions(Question question) {
        int id_in_another = insertIntoTypeTable(question);
        int score = question.getScore();
        String type = question.getType();
        int qid = connector.insertValues(
                "insert into web_note_databases.questions (score, type, id_in_others)\n" +
                        "values (?,?,?);",
                new String[]{
                        Integer.toString(score),
                        type,
                        Integer.toString(id_in_another)
                }
        );
        if (autoSetId) question.setId(qid);
        return autoSetId ? 1 : qid;
    }

    /**
     * @param id 要被删除的类型的题的id
     */
    abstract void deleteTypeQuestion(int id);

    public void deleteQuestion(Question question) {
        int qid = question.getId();
        ResultSet id_in_another_set = connector.selectValues(
                "select id_in_others from web_note_databases.questions\n" +
                        "where id=?;",
                new String[]{Integer.toString(qid)}
        );
        try {
            int id_in_another = 0;
            if (id_in_another_set.next()) id_in_another = id_in_another_set.getInt(1);
            id_in_another_set.close();
            // 先删相关类型题库
            deleteTypeQuestion(id_in_another);
            //再删主题库
            connector.deleteValues(
                    "delete from web_note_databases.questions\n" +
                            "where id=?;",
                    new String[]{Integer.toString(qid)}
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract Question getQuestionInSQL(int id);
}