package my.application.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AccessControlInterceptor implements HandlerInterceptor {

    public void postHandle(HttpRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       
            response.setHeader("Access-Control-Allow-Origin", "*");
       
    }
}