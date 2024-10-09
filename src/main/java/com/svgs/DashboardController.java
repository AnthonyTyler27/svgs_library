package com.svgs;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DashboardController {

    private String originalColor;

    
    @FXML
    void handleAdminLogin(ActionEvent event) {
        try {
            App.setRoot("adminPanel");
        } catch (IOException e) {
            System.out.println(e);   // this probably only happens when the filename is wrong. 
        }
    }
    
    // When they click on a button, this just lightens it up a little
    public void handleButtonPress(MouseEvent event) {
        Button button = (Button) event.getSource();
        originalColor = button.getStyle();
        String newColor = "-fx-background-color: derive(" + button.getStyle().substring(22, 29) + ", 20%);" + button.getStyle().substring(29);

        button.setStyle(newColor);
    }

    // Restores the original button color when the mouse is released
    public void handleButtonRelease(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle(originalColor);
    }

    @FXML
    void handleCheckout(ActionEvent event) {
        try {
            App.setRoot("checkoutScreen");
        } catch (IOException e) {
            System.out.println(e);   // this probably only happens when the filename is wrong. 
        }
    }

    @FXML
    void handleExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void handleReturn(ActionEvent event) {
        try {
            App.setRoot("returnScreen");
        } catch (IOException e) {
            System.out.println(e);   // this probably only happens when the filename is wrong. 
        }

    }

}
