package com.svgs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ReturnController {

    @FXML
    private Label bookAuthorLabel;

    @FXML
    private TextField bookIdField;

    @FXML
    private Label bookTitleLabel;

    @FXML
    private Label booksCheckedOutLabel;

    @FXML
    private Label dueDateLabel;

    @FXML
    private Label overdueBooksLabel;

    @FXML
    private TextField patronNumberField;

    @FXML
    private Label userNameLabel;

    private String originalColor = "";

    @FXML
    void handleHome(ActionEvent event) {
        try {
            App.setRoot("dashboard");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void handleReturn(ActionEvent event) {

        makeAlert("Book returned successfully");
    }

    // call this method for a popup dialog box message
    public void makeAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    // When they click on a button, this just lightens it up a little
    public void handleButtonPress(MouseEvent event) {
        Button button = (Button) event.getSource();
        originalColor = button.getStyle();
        String newColor = "-fx-background-color: derive(" + button.getStyle().substring(22, 29) + ", 20%);"
                + button.getStyle().substring(29);

        button.setStyle(newColor);
    }

    // Restores the original button color when the mouse is released
    public void handleButtonRelease(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle(originalColor);
    }

}
