package main.SQLConnctor;

import main.Module.ExaminationPaper;
import main.Module.Question;
import main.Module.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ExaminationPaperOperator {
    private static boolean autoSetId = true;
    private Connector connector = Connector.getInstance();

    public ExaminationPaperOperator() {
    }

    private static void setAutoSetId(boolean b) {
        ExaminationPaperOperator.autoSetId = b;
    }

    public int addExaminationPaper(ExaminationPaper examinationPaper) {
        int eid = connector.insertValues(
                "insert into examination_paper (name, create_date, create_teacher_id, question_list, note)\n" +
                        "values (?,CURRENT_DATE,?,?,?);",
                new String[]{ //name, create_teacher_id, question_list, note
                        examinationPaper.getName(),
                        Integer.toString(examinationPaper.getCreateTeacher().getId()),
                        ExaminationPaper.parseQuestionListToIdList(examinationPaper.getQuestionList()),
                        examinationPaper.getNote()
                }
        );
        if (autoSetId) examinationPaper.setId(eid);
        return autoSetId ? 0 : eid;
    }

    public ExaminationPaper getExaminationPaper(int pid) {
        ExaminationPaper examinationPaper = new ExaminationPaper();
        UserLoginChecker userLoginChecker = new UserLoginChecker();
        MultipleChoiceQuestionOpertor multipleChoiseQuestionOpertor =
                new MultipleChoiceQuestionOpertor();
        ResultSet resultSet = connector.selectValues(
                "select * from web_note_databases.examination_paper\n" +
                        "where id=?;",
                new String[]{Integer.toString(pid)}
        );
        try {
            if (!resultSet.next()) return null;
            int columnIndex = 1;
            examinationPaper.setId(resultSet.getInt(columnIndex++));
            examinationPaper.setName(resultSet.getString(columnIndex++));
            examinationPaper.setCreateDate(resultSet.getDate(columnIndex++));
            examinationPaper.setCreateTeacher((Teacher) userLoginChecker.getUser(resultSet.getInt(columnIndex++)));
            List<Question> questionList = new LinkedList<Question>();
            int[] questionIds = ExaminationPaper.parseQuestionIdList(resultSet.getString(columnIndex++));
            for (int qid : questionIds)
                questionList.add(multipleChoiseQuestionOpertor.getQuestionInSQL(qid));
            examinationPaper.setQuestionList(questionList);
            examinationPaper.setNote(resultSet.getString(columnIndex++));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examinationPaper;
    }
}
