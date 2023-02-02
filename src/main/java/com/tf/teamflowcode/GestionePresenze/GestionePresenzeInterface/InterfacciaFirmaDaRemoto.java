package com.tf.teamflowcode.GestionePresenze.GestionePresenzeInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.FirmaRemotoControl;

import javafx.scene.Node;

public class InterfacciaFirmaDaRemoto {

    Parent parent;
    Stage stage;
    Scene scene;

    @FXML
    private TextArea textArea;

    AccountControl accountControl = new AccountControl();

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        FirmaRemotoControl firmaRemotoControl = new FirmaRemotoControl();
        if (textArea.getText().equals("")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreFirmaRemotoAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            return;
        }
        if (!firmaRemotoControl.controllaFirma()) {
            if (accountControl.returnRuolo().equals("Amministratore")) {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreFirmaRemotoAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } else {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreFirmaRemotoImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }

        } else {
            if (firmaRemotoControl.aggiornaPresenza()) {
                if (accountControl.returnRuolo().equals("Amministratore")) {
                    parent = FXMLLoader.load(getClass()
                            .getResource(
                                    "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaFirmaRemotoAmministratore.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(parent, 810, 500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                } else {
                    parent = FXMLLoader.load(getClass()
                            .getResource(
                                    "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaFirmaRemotoImpiegato.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(parent, 810, 500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
            } else {
                if (accountControl.returnRuolo().equals("Amministratore")) {
                    parent = FXMLLoader.load(getClass()
                            .getResource(
                                    "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreFirmaRemotoAmministratore.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(parent, 810, 500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                } else {
                    parent = FXMLLoader.load(getClass()
                            .getResource(
                                    "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreFirmaRemotoImpiegato.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(parent, 810, 500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
            }
        }
    }

    @FXML
    void vaiIndietro(ActionEvent event) throws IOException {
        AccountControl accountControl = new AccountControl();
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/InterfacciaPrincipaleAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Interfaccia Principale - Amministratore");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/InterfacciaPrincipaleImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Interfaccia Principale - Impiegato");
            stage.show();
        }
    }
}