package main.servletDispatcher;

import main.Module.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginSuccess", value = "/loginSuccess")
public class LoginSuccessDispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        session.setAttribute("userType", loginUser.getUserType());
        if (loginUser.getUserType().equals("teacher")) {
            // TODO 转到teacher界面
            response.sendRedirect("teacherHomePage.jsp");
        } else if (loginUser.getUserType().equals("student")) {
            // TODO 转到student界面
            response.sendRedirect("studentHomePage.jsp");
        }
//        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
