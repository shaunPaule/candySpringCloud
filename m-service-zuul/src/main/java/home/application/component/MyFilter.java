package home.application.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public Object run() throws ZuulException {
        Logger logger = Logger.getLogger(ZuulFilter.class.getName());
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        logger.warning(String.format("%s>>>%s",request.getMethod(),request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(token == null || "".equals(token)){
            logger.warning("token is empty");
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            try{
                rc.getResponse().getWriter().write("token is empty");
            }catch(Exception e){}

            return null;
        }
        logger.fine("ok");
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
