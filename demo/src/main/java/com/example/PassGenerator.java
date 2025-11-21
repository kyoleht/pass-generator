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
        //numero que o usuario digita
        TextField lengthPassField = new TextField();
        lengthPassField.setPromptText("Enter password length");
        Button genButton = new Button("Generate Password");
        genButton.setOnAction (e -> {
            try {
                // pega o valor e atualiza o texto
                int length = Integer.parseInt(lengthPassField.getText());
                // estava passando TextField, que é um objeto do javafx 
                // passando o valor correto para gerar a senha
                String password = generatePass(length);
                passLabel.setText(password);
            } catch (NumberFormatException nfException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("An error occurred while generating the password.");
                alert.setContentText("Please try again. " + nfException.getMessage());
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, lengthPassField, genButton, passLabel);

        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 450, 450);
        palco.setScene(scene);
        palco.setTitle("Password Generator");
        palco.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}