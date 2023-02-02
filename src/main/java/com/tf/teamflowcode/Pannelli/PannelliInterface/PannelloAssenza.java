package com.tf.teamflowcode.Pannelli.PannelliInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.ControlAssenza;

public class PannelloAssenza {

    ControlAssenza controlAssenza = new ControlAssenza();
    AccountControl accountControl = new AccountControl();

    Parent parent;
    Stage stage;
    Scene scene;

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/InterfacciaPrincipaleAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Errore");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/InterfacciaPrincipaleImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Errore");
            stage.show();
        }
    }

    @FXML
    void buttonRiprova(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/AssenzaMalattiaAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Errore");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/AssenzaMalattiaImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Errore");
            stage.show();
        }
    }
}