package com.svgs;

import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminController {

    @FXML
    private TextField addressField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField bookNumberField;

    @FXML
    private ListView<String> booksCheckedOutListView;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField isbnField;

    @FXML
    private TextField lastNameField;

    @FXML
    private Label overdueCountLabel;

    @FXML
    private TextField patronNumberField;

    @FXML
    private TextField searchFirstNameField;

    @FXML
    private TextField searchLastNameField;

    @FXML
    private TextField searchPatronNumberField;

    @FXML
    private TextField titleField;

    @FXML
    private ListView<String> userResultsListView;

    private ObservableList<String> userResults;
    private ObservableList<String> checkedOutBooks;

    private String originalColor;

    @FXML 
    void initialize() {
        Platform.runLater(() -> {
            // hack to make the focus not be on a TextField
            overdueCountLabel.requestFocus();
        });
        
        userResults = FXCollections.observableArrayList();
        checkedOutBooks = FXCollections.observableArrayList();

        userResultsListView.setItems(userResults);
        booksCheckedOutListView.setItems(checkedOutBooks);

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
    void goHome(ActionEvent event) {
        try {
            App.setRoot("dashboard");
        } catch (IOException e) {
            System.out.println(e);   // this probably only happens when the filename is wrong.
        }
    }

    @FXML
    void handleAddBook(ActionEvent event) {
        makeAlert("Book added successfully");
    }

    @FXML
    void handleAddUser(ActionEvent event) {
        makeAlert("User added successfully");
    }

    @FXML
    void handleDeleteUser(ActionEvent event) {
        makeAlert("User deleted successfully");
    }

    @FXML
    void handleSearchUsers(ActionEvent event) {

    }

    void makeAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
     
    }

}
