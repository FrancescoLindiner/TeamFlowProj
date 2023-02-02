package com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiControl;

import java.io.IOException;
import java.security.SecureRandom;

import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AggiungiControl {

    BoundaryDBMS boundaryGestioneImpiegati = new BoundaryDBMS();
    
    public void aggiungiImpiegato(String nome, String cognome, String grado, String email, ActionEvent event)
            throws IOException {
            boundaryGestioneImpiegati.aggiungiImpiegatoQuery(nome, cognome, grado, email, event);
            Parent parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaAggiungiImpiegato.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Impiegato Aggiunto");
            stage.show();

        
    }

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        char[] password = new char[5];

        for (int i = 0; i < 5; i++) {
            password[i] = characters.charAt(random.nextInt(characters.length()));
        }

        return new String(password);
    }
}