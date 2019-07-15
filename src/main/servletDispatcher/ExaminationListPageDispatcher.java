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
import java.util.List;

@WebServlet(name = "examination", value = "/examinationList")
public class ExaminationListPageDispatcher extends HttpServlet {
    @Override
    public void init() throws ServletException {
        if (!Connector.isConnected()) Connector.connect_static();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(23333);
//        HttpSession session = request.getSession();
//        ExaminationOperator examinationOperator = new ExaminationOperator();
//        List<Examination> list = examinationOperator.getExaminationList();
//        session.setAttribute("examinationList", list);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("examinationListPage");
//        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
