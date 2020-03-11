package studentServlet;
import com.fasterxml.jackson.xml.XmlMapper;
import com.google.gson.Gson;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PostFilter implements Filter {
    ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
        context.log(this.getClass() + " init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest,servletResponse);
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if(httpServletRequest.getMethod().equals("GET")){
            context.log(servletRequest.getContentType());
            if(httpServletRequest.getHeader("Accept") != null){
                servletResponse.setContentType(httpServletRequest.getHeader("Accept"));
                if(httpServletRequest.getHeader("Accept").equals("application/xml")){
                    XmlMapper xmlMapper = new XmlMapper();
                    servletResponse.getWriter().write(xmlMapper.writeValueAsString(servletRequest.getAttribute("resp")));
                }
                else if(httpServletRequest.getHeader("Accept").equals("application/json")){
                    Gson gson = new Gson();
                    servletResponse.getWriter().write(gson.toJson(servletRequest.getAttribute("resp")));
                }
                else {
                    servletResponse.getWriter().write(servletRequest.getAttribute("resp").toString());
                }
            }
            else{
                servletResponse.getWriter().write(servletRequest.getAttribute("resp").toString());
            }
        }

    }

    @Override
    public void destroy() {
        context.log(this.getClass() + " destroy");
    }
}
