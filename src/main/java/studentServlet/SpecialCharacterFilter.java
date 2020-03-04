package studentServlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("special character filter initialised !");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String rollNo, name, university;
        rollNo = servletRequest.getParameter("rollNo");
        name  = servletRequest.getParameter("name");
        university = servletRequest.getParameter("university");
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(rollNo);
        if (matcher.matches()){
            System.out.println("true");
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            System.out.println("false" + "---" + this);
            servletResponse.getWriter().write("special characters not allowed !");
        }
    }

    @Override
    public void destroy() {

    }
}
