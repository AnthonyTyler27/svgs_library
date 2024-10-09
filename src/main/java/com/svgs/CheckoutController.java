package com.svgs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CheckoutController {

    @FXML
    private Label bookAuthorLabel;

    @FXML
    private TextField bookNumberField;

    @FXML
    private Label bookTitleLabel;

    @FXML
    private ListView<String> checkedOutBooksListView;

    private ObservableList<String> checkedOutBooks;

    @FXML
    private TextField patronNumberField;

    private String originalColor = "";

    @FXML
    void initialize() {
        checkedOutBooks = FXCollections.observableArrayList();
        checkedOutBooksListView.setItems(checkedOutBooks);
    }

    @FXML
    void handleCheckout(ActionEvent event) {

    }

    @FXML
    void handleHome(ActionEvent event) {
        try {
            App.setRoot("dashboard");
        } catch (Exception e) {
            System.out.println(e);
        }
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
