package studentServlet;

import Data.Student;
import db.StudentDb;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class StudentServlet extends HttpServlet  {
    StudentDb db;
    ServletContext context;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Student stud = new Student(req.getParameter("name"),req.getParameter("university"),req.getParameter("rollNo"));
        System.out.println( " POST " + "\n" + stud.stringify() );
        resp.getWriter().write(db.insertRow(stud));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Student stud;
            String rolno = req.getParameter("rollNo");
            stud = db.getByRollNo(rolno);
            System.out.println("GET /roll/rollNo?=" + rolno);
            req.setAttribute("resp",stud.stringify());
            resp.setContentType(req.getContentType());
    }

    @Override
    public void init() throws ServletException {
        super.init();
        db = new StudentDb();
        context = getServletContext();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
