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
        System.out.println(servletRequest.getContentType());
        if(servletRequest.getContentType() != null){
            if(servletRequest.getContentType().equals("application/xml")){
                XmlMapper xmlMapper = new XmlMapper();
                servletResponse.getWriter().write(xmlMapper.writeValueAsString(servletRequest.getAttribute("resp")));
            }
            else if(servletRequest.getContentType().equals("application/json")){
                Gson gson = new Gson();
                servletResponse.getWriter().write(gson.toJson(servletRequest.getAttribute("resp")));
            }
            else {
                servletResponse.getWriter().write(servletRequest.getAttribute("resp").toString());
            }
        }
        else{
            servletResponse.getWriter().write("Content-Type header required !");
        }
    }

    @Override
    public void destroy() {

    }
}
