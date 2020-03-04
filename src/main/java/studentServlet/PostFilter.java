package studentServlet;

import Data.Student;
import com.fasterxml.jackson.xml.XmlMapper;
import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import java.io.IOException;

public class PostFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("post filter initialized .. !");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest,servletResponse);
        String resp = (String) servletRequest.getAttribute("resp");
        System.out.println(resp);
        if(servletRequest.getContentType().equals("application/xml")){
            Gson gson = new Gson();
            Student stud = gson.fromJson(resp,Student.class) ;

            XmlMapper xmlMapper = new XmlMapper();
            servletResponse.getWriter().write(xmlMapper.writeValueAsString(stud));
        } else{
            servletResponse.getWriter().write(resp);
        }
    }

    @Override
    public void destroy() {

    }
}
