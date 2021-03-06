package main.servletDispatcher;

import main.Module.Examination;
import main.SQLConnctor.Connector;
import main.SQLConnctor.ExaminationOperator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "examinationPageDispatcher", value = "/examination")
public class ExaminationPageDispatcher extends HttpServlet {

    @Override
    public void init() throws ServletException {
        if (!Connector.isConnected()) Connector.connect_static();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("examinationPage.jsp");
        if (session.getAttribute("loginFail") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        Integer eid = getInteger(map.get("eid")[0]);
        ExaminationOperator examinationOperator = new ExaminationOperator();
        Examination examination = examinationOperator.getExaminationById(eid);
        session.setAttribute("drewExamination", examination);
        dispatcher.forward(request, response);
    }

    public static Integer getInteger(String s) {
        int v = 0;
        for (int i = 0; i < s.length(); ++i)
            v = v * 10 + s.charAt(i) - '0';
        return v;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
