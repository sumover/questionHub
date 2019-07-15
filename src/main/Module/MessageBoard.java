package main.Module;

import java.sql.Date;

public class MessageBoard {
    private int messageNum;
    private Date today;
    private String[] messageTexts;
    private String[] messageUrls;

    public MessageBoard() {
    }

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String[] getMessageText() {
        return messageTexts;
    }

    public void setMessageText(String[] messageTexts) {
        this.messageTexts = messageTexts;
    }

    public String[] getMessageUrl() {
        return messageUrls;
    }

    public void setMessageUrl(String[] messageUrl) {
        this.messageUrls = messageUrl;
    }

    public String getMessageTextAt(int index) {
        return messageTexts[index];
    }

    public String getMessageUrlAt(int index) {
        return messageUrls[index];
    }
}
