package com.ganesh.model;

public class TodoTask {

    protected String todoId;

    protected String todoName;

    public TodoTask() {
    }

    public TodoTask(String todoId, String todoName) {
        this.todoId = todoId;
        this.todoName = todoName;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    @Override
    public String toString() {
        return "{" +
                "todoId='" + todoId + '\'' +
                ", todoName='" + todoName + '\'' +
                '}';
    }
}
