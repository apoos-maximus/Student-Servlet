package studentServlet;

import javax.servlet.*;
import java.io.IOException;

public class StudentRequestFilter implements Filter {
    ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
        context.log(this.getClass() + " init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String a,b, rollNoFilterParameter = servletRequest.getParameter("rollNo");
        String[] c = rollNoFilterParameter.split("RN",2);
        a = c[0];
        if("".equals(a)){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            context.log(this.getClass() + " doFilter :" + "wrong format");
            servletResponse.getWriter().write("invalid format !");
        }

    }

    @Override
    public void destroy() {
        context.log(this.getClass() + " destroy");
    }
}