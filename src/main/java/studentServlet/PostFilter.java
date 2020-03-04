package studentServlet;

import javax.servlet.*;
import java.io.IOException;

public class PostFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("post filter initialized .. !");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        if(servletRequest.getContentType().equals("application/xml")){
//            System.out.println("application/xml");
//            servletResponse.setContentType("application/xml");
//        } else {
//            System.out.println("application/json");
//            servletResponse.setContentType("application/json");
//        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
