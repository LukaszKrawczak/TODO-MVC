package com.example.mypackage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskModelTest {
    private static int count;
    private TaskModel taskModel;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @Before
    public void setup() {
        taskModel = new TaskModel();
    }

    @Before
    public void before() {
        taskModel.addTask(randomNullTask());
        taskModel.addTask(randomNullTask());
        taskModel.addTask(randomNullTask());
        System.out.println(taskModel.getTasks().size());
    }

    @Test
    public void shouldReturnNumberOfAddedItems() {
        assertEquals(3, taskModel.getTasks().size());
    }

    @Test
    public void shouldThrowErrorWhenGetItemOutOfBound() {
        assertNotEquals(4, taskModel.getTasks().size());
        assertNotEquals(-1, taskModel.getTasks().size());
        assertNotEquals(5, taskModel.getTasks().size());
    }

    @Test
    public void shouldReturnNullValueWhenTryingToGetItemOutOfBound() {
        assertNull(taskModel.getTask(5));
    }

    @Test
    public void shouldHaveTheSameNameAsEnteredBefore() {
        taskModel.addTask(randomStringTask());
        TaskInterface task = taskModel.getTask(3);
        Task testtask = new Task("test", "test", false);

        assertEquals(testtask.getName(), task.getName());
    }

    @Test
    public void shouldReturnDifferentObject() {
        taskModel.addTask(randomStringTask());
        TaskInterface task = new Task("test", "test", false);

        assertNotSame(task.getTask(), taskModel.getTask(3));
    }

    @Test
    public void shouldRe() {
        taskModel.removeTaskById(3);
        assertEquals(2, taskModel.getTasks().size());
        taskModel.removeTaskById(2);
        assertEquals(1, taskModel.getTasks().size());
        taskModel.removeTaskById(1);
        assertEquals(0, taskModel.getTasks().size());
        taskModel.addTask(randomStringTask());
        assertEquals(1, taskModel.getTasks().size());
    }

    private Task randomNullTask() {
        return new Task(null, null, false);
    }

    private Task randomStringTask() {
        return new Task("test", "test", false);
    }
}