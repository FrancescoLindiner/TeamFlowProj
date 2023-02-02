package com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiInterface;

import java.io.IOException;

import com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiControl.AggiungiControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class InterfacciaAggiungiImpiegato {

    @FXML
    private Button buttonConferma;

    @FXML
    private Button buttonVaiIndietro;

    @FXML
    private TextField textFieldCognome;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldGrado;

    @FXML
    private TextField textFiledNome;

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        AggiungiControl aggiungiControl = new AggiungiControl();
        if (!textFiledNome.getText().equals("") && !textFieldCognome.getText().equals("")
                && !textFieldEmail.getText().equals("") && !textFieldGrado.getText().equals("")) {
            aggiungiControl.aggiungiImpiegato(textFiledNome.getText(), textFieldCognome.getText(),
                    textFieldGrado.getText(), textFieldEmail.getText(), event);
        }
    }

    @FXML
    void buttonVaiIndietro(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/GestioneImpiegati.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Gestione Impiegati");
        stage.show();
    }

}
