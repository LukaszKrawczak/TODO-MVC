package com.example.mypackage;

import javax.swing.*;

public class ErrorHandler extends JPanel {
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
