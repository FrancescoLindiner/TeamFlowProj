package com.tf.teamflowcode.Pannelli.PannelliInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Logout {

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneAccount/fxml/fxmlLogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.show();
    }

}
