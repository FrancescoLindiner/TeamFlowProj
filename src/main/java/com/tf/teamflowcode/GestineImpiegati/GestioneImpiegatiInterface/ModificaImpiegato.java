package com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiInterface;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiControl.GestoreImpiegati;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.scene.Node;

public class ModificaImpiegato {

    @FXML
    private TextField textFiledGrado;

    @FXML
    private TextField textFiledEmail;

    Parent parent;
    Stage stage;
    Scene scene;

    BoundaryDBMS boundaryGestioneImpiegati = new BoundaryDBMS();

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        InterfacciaVisualizzaImpiegati ricercaImpiegati = new InterfacciaVisualizzaImpiegati();
        GestoreImpiegati gestioneImpiegati = new GestoreImpiegati();
        ObservableList<Dipendente> impiegato = ricercaImpiegati.impiegato;
        if (textFiledGrado.getText().equals("")) {
            gestioneImpiegati.modificaImpiegatoEmail(impiegato, textFiledEmail.getText());
        } else if (textFiledEmail.getText().equals("")) {
            gestioneImpiegati.modificaImpiegatoGrado(impiegato, textFiledGrado.getText());
        } else {
            gestioneImpiegati.modificaImpiegato(impiegato, textFiledGrado.getText(), textFiledEmail.getText());
        }
        boundaryGestioneImpiegati.list.clear();
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/GestioneImpiegati.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ricerca Impiegati");
        stage.show();
    }

    @FXML
    void buttonVaiIndietro(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/RicercaImpiegati.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ricerca Impiegati");
        stage.show();
    }
}