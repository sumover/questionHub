package main.SQLConnctor;

import main.Module.Examination;
import main.Module.MessageBoard;
import main.Module.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExaminationOperator {
    private Connector connector;

    public ExaminationOperator() {
        this.connector = Connector.getInstance();
    }

    /**
     * 获得从当前时刻之后开始的size个考试信息
     * 如果没有那么多，那就能给多少就给多少。。。
     *
     * @param size
     * @return 信息表
     */
    public MessageBoard getLoginPageMessage(int size) {
        MessageBoard messageBoard = new MessageBoard();
        ResultSet resultSet = connector.selectValues("\n" +
                        "select * from web_note_databases.examination\n" +
                        "where end_time > current_time order by begin_time;\n",
                null
        );
        List<Examination> list = new LinkedList<Examination>();
        Examination examination = new Examination();
        while (getExaminationFromResult(resultSet, examination) && size-- != 0) {
            list.add(examination);
            examination = new Examination();
        }
        String[] message = new String[list.size()], urls = new String[list.size()];

        /**
         * 添加消息
         */
        for (int i = 0; i < list.size(); ++i) message[i] = list.get(i).getExaminationPaper().getName();

        /**
         *添加URL
         */

        messageBoard.setMessageNum(list.size());
        messageBoard.setMessageText(message);
        messageBoard.setToday(new Date());
//        messageBoard.setMessageUrl();
        return messageBoard;
    }

    /**
     * 根据id从数据库里得到Examination
     * 说实话Mybatis还是挺好用的...比如这种业务场景
     * 你妈的我已经写了无数个这种的函数了
     * 草(中日双语)
     *
     * @param eid id
     * @return
     */
    public Examination getExaminationById(int eid) {
        Examination examination = new Examination();
        ExaminationPaperOperator paperOperator = new ExaminationPaperOperator();
        UserLoginChecker loginChecker = new UserLoginChecker();
        ResultSet resultSet = connector.selectValues(
                "select * from examination\n" +
                        "where id=?;",
                new String[]{Integer.toString(eid)}
        );
        getExaminationFromResult(resultSet, examination);
//        try {
//            if (!resultSet.next()) return null;
//            examination.setId(eid);
//            examination.setExaminationPaper(paperOperator.getExaminationPaper(resultSet.getInt(2)));
//            examination.setCreateTeacher((Teacher) loginChecker.getUser(resultSet.getInt(3)));
//            examination.setCreateTime(Examination.parseFromSQL(resultSet.getString(4)));
//            examination.setBeginTime(Examination.parseFromSQL(resultSet.getString(5)));
//            examination.setEndTime(Examination.parseFromSQL(resultSet.getString(6)));
//            examination.setStatus(resultSet.getString(7));
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return examination;
    }

    /**
     * 给examinationList准备的
     *
     * @return 考试列表
     */
    public List<Examination> getExaminationList() {
        List<Examination> examinations = new LinkedList<Examination>();
        Integer[] eidArray = connector.getIdArrays("eid", "where end_time > current_time order by begin_time");
        for (Integer eid : eidArray) {
            examinations.add(getExaminationById(eid));
        }
        return examinations;
    }

    private boolean getExaminationFromResult(ResultSet resultSet, Examination examination) {
        ExaminationPaperOperator paperOperator = new ExaminationPaperOperator();
        UserLoginChecker loginChecker = new UserLoginChecker();
        try {
            if (!resultSet.next()) return false;
            examination.setId(resultSet.getInt(1));
            examination.setExaminationPaper(paperOperator.getExaminationPaper(resultSet.getInt(2)));
            examination.setCreateTeacher((Teacher) loginChecker.getUser(resultSet.getInt(3)));
            examination.setCreateTime(Examination.parseFromSQL(resultSet.getString(4)));
            examination.setBeginTime(Examination.parseFromSQL(resultSet.getString(5)));
            examination.setEndTime(Examination.parseFromSQL(resultSet.getString(6)));
            examination.setStatus(resultSet.getString(7));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
