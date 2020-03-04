package studentServlet;

import javax.servlet.*;
import java.io.IOException;

public class StudentRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String a,b, rollNoFilterParameter = servletRequest.getParameter("rollNo");
        String[] c = rollNoFilterParameter.split("RN",2);
        a = c[0];
//        b = c[1];
        if("".equals(a)){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            System.out.println("false" + "---" + this);
            servletResponse.getWriter().write("invalid format !");
        }

    }

    @Override
    public void destroy() {

    }
}