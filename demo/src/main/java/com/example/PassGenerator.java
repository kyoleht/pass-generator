package com.example;

import java.security.SecureRandom;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class PassGenerator extends Application {

    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?/";

    public static String generatePass(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder pass = new StringBuilder(length);

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            pass.append(chars.charAt(index));
        }

        return pass.toString();
    }

    @Override
    public void start(Stage palco) {
        Label title = new Label("Password Generator");
        title.setFont(Font.font("Arial", 26));
        title.setTextFill(Color.DARKBLUE);

        TextField lengthPassField = new TextField();
        lengthPassField.setPromptText("Enter password length");
        lengthPassField.setMaxWidth(200);

        Label passLabel = new Label("");
        passLabel.setFont(Font.font("Arial", 20));
        passLabel.setTextFill(Color.DARKMAGENTA);

        Button genButton = new Button("Generate Password");
        genButton.setStyle(
            "-fx-background-color: #4A90E2; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 10 20; " +
            "-fx-background-radius: 8;"
        );

        genButton.setOnAction(e -> {
            try {
                if (lengthPassField.getText().trim().isEmpty()) {
                    showError("Please enter a password length.");
                    return;
                }

                int length = Integer.parseInt(lengthPassField.getText());

                if (length < 4) {
                    showError("Password must be at least 4 characters long.");
                    return;
                }

                if (length > 100) {
                    showError("Password too long! Please choose less than 100 characters.");
                    return;
                }

                String password = generatePass(length);
                passLabel.setText(password);

            } catch (NumberFormatException nfException) {
                showError("Please enter only numbers.");
            }
        });

        VBox layout = new VBox(15, title, lengthPassField, genButton, passLabel);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #E7F1FF;");

        Scene scene = new Scene(layout, 400, 350);
        palco.setScene(scene);
        palco.setTitle("Password Generator");
        palco.show();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
