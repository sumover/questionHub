package main.SQLConnctor;

import main.Module.MessageBoard;

public class ExaminationOperator {
    private Connector connector;

    ExaminationOperator() {
        this.connector = Connector.getInstance();
    }

    /**
     * 这个方法可以获得今天以后包括今天的十个考试的信息.
     * 注意是今天
     *
     * @return
     */
    public MessageBoard getLoginPageMessage() {
        MessageBoard messageBoard = new MessageBoard();
        connector.selectValues(
                "select * from examination\n" +
                        "where end_time > current_time ;\n",
                null
        );

        return messageBoard;
    }

}
