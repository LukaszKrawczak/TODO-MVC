package com.example.mypackage;

import java.util.LinkedList;
import java.util.List;

public class TaskModel {

    private List<Task> tasks = new LinkedList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void removeTask(Task task) {
        if (task != null)
            this.tasks.remove(task);
    }

    public void removeTaskById(int id) {
        int fixedId = id - 1;
        try {
            if (id < 0 || id >= tasks.size()) {
                tasks.remove(fixedId);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't remove item");
        }
    }

    public Task getTask(int index) {
        int size = tasks.size() - 1;
        try {
            if (index < 0 || index >= size)
                return tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return null;
    }
}


