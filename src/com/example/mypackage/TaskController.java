package com.example.mypackage;

import javax.swing.event.ListSelectionListener;

public final class TaskController {
    private final TasksView theView;
    private final TaskModel theModel;

    public TaskController(TasksView theView, TaskModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addTaskListener((actionEvent) -> {
            final String title = theView.titleTextField();
            final String body = theView.bodyTextField();
            final boolean hasDone = theView.hasDone();

            final Task task = new Task(title, body, hasDone);

            if (title != null && body != null) {
                theModel.addTask(task);
                theView.removeAllModelElements();
                theView.setList(theModel.getTasks());
                theView.clearTextFields();
            } else
                new ErrorHandler().displayErrorMessage("You need to add text to the fields");
        });

        this.theView.removeTaskListener((ListSelectionListener) valueChanged -> {
            final Task removedTask = theView.selectedListItem();
            theModel.removeTask(removedTask);
            theView.removeModelElement(removedTask);
        });
    }
}