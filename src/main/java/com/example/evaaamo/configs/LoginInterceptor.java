package com.example.evaaamo.configs;

import com.example.evaaamo.services.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//Used to check if the URL has /admin/ in it before the request gets to the controller
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    LoginService loginService;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {
        //Check if the requested URL contains "/admin/"
        if (request.getRequestURI().contains("/admin/")) {
            //If user not logged in, redirect to login page
            if (!loginService.isUserLoggedIn(request.getSession())) {
                response.sendRedirect("/login");
                return false;
            }
        }
        return true; //Allow the request to proceed
    }

}
