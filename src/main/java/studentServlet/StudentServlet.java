package studentServlet;

import Data.Student;
import db.StudentDb;
import org.example.DB.Db;
import org.example.Employee.Employee;


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
        Student stud = new Student(req.getParameter("name"),req.getParameter("university"),req.getParameter("rollNo"));
        context.log( " POST " + "\n" + stud.stringify() );
        resp.setContentType("application/json");
        resp.getWriter().write(db.insertRow(stud));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            Student stud;
//            String rolno = req.getParameter("rollNo");
//            stud = db.getByRollNo(rolno);
//            context.log("GET /roll/rollNo?=" + rolno);
//            req.setAttribute("resp",stud);
//            resp.setContentType(req.getHeader("Accept"));

        int id = Integer.valueOf(req.getParameter("id"));


        Db empDB = new Db();

        Employee employee = empDB.readEmployee(id);
        req.setAttribute("resp",employee);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        db = new StudentDb();
        context = getServletContext();
        context.log(this.getClass() + " init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.log(this.getClass() + " service");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        context.log(this.getClass() + " destroy");
        super.destroy();
    }

    }
