package com.example.mypackage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * One possible convention is to use the "should" in the test method name.
 * For example, "ordersShouldBeCreated" or "menuShouldGetActive".
 * This gives a hint what should happen if the test method is executed.
 * <p>
 * Another approach is to use "Given[ExplainYourInput]When[WhatIsDone]Then[ExpectedResult]"
 * for the display name of the test method.
 * <p>
 * https://www.vogella.com/tutorials/JUnit/article.html
 */
public class TasksViewTest extends JFrame {

    private static int count;
    private TasksView view;
    private TaskModel model;
    private TaskController controller;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @Before
    public void setup() {
        System.out.println("Running a test...");
        view = new TasksView();
        model = new TaskModel();

        controller = new TaskController(view, model);
        view.setVisible(false);

        model.addTask(randomStringTask());
        model.addTask(randomStringTask());
        model.addTask(randomStringTask());

    }

    @Test
    public void shouldReturnNullWhenTitleLabelIsNotEntered() {
        assertNotNull(null, view.getTitleLabel());
    }

    @Test
    public void checkIfTaskReturnsProperLenght() {
        assertEquals(3, model.getTasks().size());
    }

    @Test
    public void viewModelIsNotNull() {
        assertNotNull(view);
    }

    @Test
    public void shouldRemoveAllElementsInListModel() {
        view.setList(model.getTasks());
        view.removeAllModelElements();
        assertEquals(0, view.listSize());
    }

    @Test
    public void shouldReturnZeroIfRemovedThreeElementsInThreeElementList() {
        TaskModel myModel = new TaskModel();
        Task task1 = new Task("test1", "test1", false);
        Task task2 = new Task("test2", "test2", false);
        Task task3 = new Task("test3", "test3", false);

        myModel.addTask(task1);
        myModel.addTask(task2);
        myModel.addTask(task3);

        assertEquals(3, myModel.getTasks().size());
        myModel.removeTask(task1);
        assertEquals(2, myModel.getTasks().size());
        myModel.removeTask(task2);
        assertEquals(1, myModel.getTasks().size());
        assertEquals(task3, myModel.getTask(0));
        myModel.removeTask(task3);
        assertEquals(0, myModel.getTasks().size());
    }

    private Task randomNullTask() {
        return new Task(null, null, false);
    }

    private Task randomStringTask() {
        return new Task("test", "test", false);
    }
}