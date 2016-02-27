package com.ganesh.service;

import com.ganesh.model.TodoTask;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("todoService")
public class TodoService {

    List<TodoTask> todoTaskList = new ArrayList<>();

    @PostConstruct
    public void init() {
        todoTaskList.add(new TodoTask("1", "FirstTask"));
    }

    public void addTodoTask(TodoTask todoTask) {

        todoTaskList.add(todoTask);

    }

    public List<TodoTask> getAllTasks() {

        return todoTaskList;

    }

}
