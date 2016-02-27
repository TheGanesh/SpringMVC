package com.ganesh.controller;


import com.ganesh.model.TodoTask;
import com.ganesh.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RESTController {

    @Autowired
    TodoService todoService;

    @ResponseBody
    @RequestMapping(value = "/todo", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public List<TodoTask> addTodoTask(@RequestBody TodoTask todoTask) {
        todoService.addTodoTask(todoTask);
        return todoService.getAllTasks();
    }

    @ResponseBody
    @RequestMapping(value = "/todos", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public List<TodoTask> getTodos() {

        return todoService.getAllTasks();

    }

}
