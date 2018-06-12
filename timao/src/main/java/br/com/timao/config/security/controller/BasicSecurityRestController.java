package br.com.timao.config.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.MappedInterceptor;

import br.com.timao.config.security.JwtTokenUtil;
import br.com.timao.config.security.JwtUser;

public class BasicSecurityRestController {

    @Bean
    @Autowired
    public MappedInterceptor getMappedInterceptor(MyHandlerInterceptor myHandlerInterceptor) {
        return new MappedInterceptor(new String[] { "/" }, myHandlerInterceptor);
    }

    @Component
    public static class MyHandlerInterceptor implements HandlerInterceptor {

        @Value("${jwt.header}")
        private String tokenHeader;

        @Autowired
        private JwtTokenUtil jwtTokenUtil;

        @Autowired
        @Qualifier("jwtUserDetailsService")
        private UserDetailsService userDetailsService;
        
    	 public  boolean isTokenValid(HttpServletRequest request) throws Exception {
    	        String token = request.getHeader(tokenHeader).substring(7);
    	        String username = jwtTokenUtil.getUsernameFromToken(token);
    	        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
    	        if(user!=null) {
    	        	return true;        	
    	        }else {        	 
    	        	throw new Exception();
    	        }
    	       
    	    }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            return isTokenValid(request);
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                Exception ex) throws Exception {

        }
    }

    @ControllerAdvice
    public static class MyExceptionHandler {
        @ExceptionHandler(Exception.class)
        @ResponseBody
        public Map<String, Object> handelr() {
            Map<String, Object> m1 = new HashMap<String, Object>();
            m1.put("status", "error");
            m1.put("message", "Sorry, your provided token information expired or not exists.");
            return m1;
        }
    }
    
      
}
