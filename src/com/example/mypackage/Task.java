package com.example.mypackage;

public class Task implements TaskInterface {
    private String name;
    private String body;
    private boolean done;

    public Task(String name, String body, boolean done) {
        this.name = name;
        this.body = body;
        this.done = done;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Task getTask() {
        return this;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", done=" + done +
                '}';
    }
}

