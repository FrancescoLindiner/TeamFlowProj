package com.tf.teamflowcode.Pannelli.PannelliInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiControl.GestoreImpiegati;
import com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiInterface.InterfacciaVisualizzaImpiegati;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.scene.Node;

public class PannelloConfermaRimuovi {

    Parent parent;
    Stage stage;
    Scene scene;

    BoundaryDBMS boundaryGestioneImpiegati = new BoundaryDBMS();

    @FXML
    void buttonVaiIndietro(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/RicercaImpiegati.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Modifica Impiegato");
        stage.show();
    }

    @FXML
    public void buttonRimuovi(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/GestioneImpiegati.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Gestione Impiegati");
        stage.show();
        GestoreImpiegati gestioneImpiegati = new GestoreImpiegati();
        InterfacciaVisualizzaImpiegati ricercaImpiegati = new InterfacciaVisualizzaImpiegati();
        gestioneImpiegati.rimuoviImpiegato(ricercaImpiegati.impiegato);
        boundaryGestioneImpiegati.list.clear();
    }
}