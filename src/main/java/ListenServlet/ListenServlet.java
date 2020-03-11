package ListenServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

public class ListenServlet extends HttpServlet {
    ServletContext context;
    ServletConfig servletConfig;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.log("POST-post-listen");
        resp.getWriter().write("POST: hey happy listening");
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.log("GET-get-listen");
        ByteArrayInputStream in = (ByteArrayInputStream) context.getResourceAsStream(context.getInitParameter("properties"));
        context.log(context.getInitParameter("properties"));
        Properties s = new Properties();
        s.load(in);
//        System.out.println(s.toString());

        resp.getWriter().write(s.toString());
    }




    @Override
    public void init() throws ServletException {
        super.init();
        servletConfig = getServletConfig();
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
