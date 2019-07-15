package main.servletDispatcher;

import main.SQLConnctor.Connector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

class MessageBoard {
    private int messageNum;
    private Date today;
    private String messageText;
    private String messageUrl;

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

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }
}


@WebServlet(name = "init", value = "/login")
public class InitDispatcher extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Connector.connect_static();
    }

    @Override
    public void destroy() {
        Connector.disconnect_static();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("get");
        HttpSession session = request.getSession();
        if (session.getAttribute("loginFail") == null) session.setAttribute("loginFail", false);
        // todo 添加公告信息
        MessageBoard messageBoard = new MessageBoard();
        session.setAttribute("loginPageMessageBoard", messageBoard);
        request.setCharacterEncoding("UTF-8");
        response.sendRedirect("login.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("post");
    }
}
