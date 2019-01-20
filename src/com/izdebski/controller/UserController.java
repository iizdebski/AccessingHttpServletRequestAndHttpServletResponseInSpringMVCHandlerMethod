package com.izdebski.controller;

import com.izdebski.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String registerPage(){
        return "register";
    }

    @RequestMapping(value="/registerSuccess", method = RequestMethod.POST)
    public ModelAndView registerSuccess(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(userName, age, email, country);
        ModelAndView modelAndView = new ModelAndView("registerSuccess");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
