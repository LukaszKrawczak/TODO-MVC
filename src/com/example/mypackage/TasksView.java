package com.example.mypackage;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.List;

public class TasksView extends JFrame {

    private JLabel titleLabel = new JLabel("Tytuł");
    private JTextField titleField = new JTextField(10);
    private JLabel bodyLabel = new JLabel("Treść");
    private JTextField bodyField = new JTextField(10);
    private JButton addTaskButton = new JButton("Dodaj");
    private DefaultListModel<Task> model = new DefaultListModel<>();
    private JList<Task> tasksList = new JList<>(model);

    TasksView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);

        JPanel todoPanel = new JPanel();
        todoPanel.add(titleLabel);
        todoPanel.add(titleField);
        todoPanel.add(bodyLabel);
        todoPanel.add(bodyField);
        todoPanel.add(addTaskButton);
        todoPanel.add(tasksList);

        this.add(todoPanel);
    }

    protected void addTaskListener(ActionListener addTaskListener) {
        if (addTaskListener != null)
            addTaskButton.addActionListener(addTaskListener);
    }

    protected void removeTaskListener(EventListener removeTaskListener) {
        if (removeTaskListener != null)
            tasksList.addListSelectionListener((ListSelectionListener) removeTaskListener);
    }

    public String titleTextField() {
        return titleField.getText().isEmpty() ? null : titleField.getText();
    }

    public String bodyTextField() {
        return bodyField.getText().isEmpty() ? null : bodyField.getText();
    }

    public void setList(List<Task> tasks) {
        tasks.forEach(task -> model.addElement(task));
    }

    public void removeModelElement(Task task) {
        model.removeElement(task);
    }

    public void removeAllModelElements() {
        model.removeAllElements();
    }

    public void clearTextFields() {
        titleField.setText("");
        bodyField.setText("");
    }

    public boolean hasDone() {
        return false;
    }

    public String getTitleLabel() {
        return titleLabel.getText().isEmpty() ? null : titleLabel.getText();
    }

    public int listSize() {
        return model.size();
    }

    public Task selectedListItem() {
        return tasksList.getSelectedValue();
    }
}
