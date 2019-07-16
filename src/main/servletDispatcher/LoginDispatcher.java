package main.servletDispatcher;


import main.Module.User;
import main.SQLConnctor.UserLoginChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginDispatcher", value = "/loginDispatcher")
public class LoginDispatcher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name, password;
        name = request.getParameter("loginFormUserNameText");
        password = request.getParameter("loginFormPasswordText");
//        response.getWriter().println("name : " + name + "\npwd : " + password);
        UserLoginChecker loginChecker = new UserLoginChecker();
        User user = loginChecker.loginCheck(name, password);
        HttpSession session = request.getSession();
        if (user == null) {
            session.setAttribute("loginFail", true);
            response.sendRedirect("login");
        } else {
            response.getWriter().println("login success!");
            session.setAttribute("loginUser", user);
            session.setAttribute("loginFail", false);
            response.sendRedirect("loginSuccess");
        }
    }
}
