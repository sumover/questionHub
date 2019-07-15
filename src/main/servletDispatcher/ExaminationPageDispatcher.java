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

@WebServlet(name = "examinationPageDispatcher", value = "/examination")
public class ExaminationPageDispatcher extends HttpServlet {

    @Override
    public void init() throws ServletException {
        if (!Connector.isConnected()) Connector.connect_static();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        Integer eid = Integer.getInteger(request.getParameter("eid"));
        ExaminationOperator examinationOperator = new ExaminationOperator();
        Examination examination = examinationOperator.getExaminationById(eid);
        HttpSession session = request.getSession();
        session.setAttribute("drewExamination", examination);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
