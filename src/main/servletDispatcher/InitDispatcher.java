package main.servletDispatcher;

import main.Module.MessageBoard;
import main.SQLConnctor.Connector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


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
        messageBoard.setMessageNum(0);
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
