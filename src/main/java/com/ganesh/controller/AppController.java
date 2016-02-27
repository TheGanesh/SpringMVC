package com.ganesh.controller;


import com.ganesh.model.TodoTask;
import com.ganesh.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/getTasks", method = RequestMethod.GET)
    public ModelAndView getdata() {

        List<TodoTask> taskList = todoService.getAllTasks();

        ModelAndView model = new ModelAndView("todo");
        model.addObject("tasks", taskList);

        return model;

    }
}