package com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiInterface;

import java.io.IOException;

import com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiControl.GestoreImpiegati;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class InterfacciaGestioneImpiegati {

    @FXML
    private Button buttonVaiIndietro;

    @FXML
    private Button buttonAggiungiImpiegato;

    @FXML
    private TextField textFieldCognome;

    @FXML
    private TextField textFieldNome;

    InterfacciaVisualizzaImpiegati ricercaImpiegati = new InterfacciaVisualizzaImpiegati();

    @FXML
    void buttonVaiIndietro(ActionEvent event) throws IOException {
        Parent splashScreen = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/Pannelli/fxml/InterfacciaPrincipaleAmministratore.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(splashScreen, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Interfaccia Principale - Amministratore");
        stage.show();
    }

    @FXML
    void buttonAggiungiImpiegati(ActionEvent event) throws IOException {
        Parent splashScreen = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/AggiungiImpiegato.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(splashScreen, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Aggiungi Impiegato");
        stage.show();
    }

    @FXML
    void buttonCerca(ActionEvent event) throws IOException {
        GestoreImpiegati gestioneImpiegati = new GestoreImpiegati();

        if (textFieldCognome.getText().isEmpty()) {
            gestioneImpiegati.cercaImpiegatoPerNome(textFieldNome.getText());
        } else if (textFieldNome.getText().isEmpty()) {
            gestioneImpiegati.cercaImpiegatoPerCognome(textFieldCognome.getText());
        } else {
            gestioneImpiegati.cercaImpiegatoPerNomeECognome(textFieldNome.getText(), textFieldCognome.getText());
        }

        Parent splashScreen = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/RicercaImpiegati.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(splashScreen, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Risultati Ricerca");
        stage.show();
    }

}