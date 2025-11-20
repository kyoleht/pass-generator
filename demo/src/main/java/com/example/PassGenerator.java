package com.example;

import java.security.SecureRandom;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        Label passLabel = new Label("Password");
        Button genButton = new Button("Generate Password");
        genButton.setOnAction (e -> {
            try {
                // pega o valor e atualiza o texto
                String password = generatePass(12);
                passLabel.setText(password);
            } catch (ArrayIndexOutOfBoundsException aiobException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("An error occurred while generating the password.");
                alert.setContentText("Please try again. " + aiobException.getMessage());
                alert.showAndWait();
            }
        });

        
    }

    public static void main(String[] args) {
        launch();
    }
}