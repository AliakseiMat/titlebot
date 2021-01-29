package com.chatmeter.titlebot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

    public ModelAndView getMainPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        return model;
    }
}
