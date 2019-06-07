package com.example.mypackage;

/**
 * Simple 'TO-DO' App based on Model View Controller pattern.
 * <p>
 * Created by Łukasz Krawczak June 2019.
 */

public class Main {

    public static void main(String[] args) {
        TasksView view = new TasksView();
        TaskModel model = new TaskModel();

        TaskController controller = new TaskController(view, model);
        view.setVisible(true);
    }
}
