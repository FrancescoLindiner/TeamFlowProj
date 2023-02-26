package com.tf.teamflowcode.GestionePresenze.GestionePresenzeInterface;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.GestionePresenzeControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.RimpiazzaControl;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.scene.Node;

public class InterfacciaComunicaAssenza {

    final String DRIVER = "com.mysql.cj.jdbc.Driver";

    Parent parent;
    Stage stage;
    Scene scene;

    @FXML
    private DatePicker datePicker;

    GestionePresenzeControl controlAssenza = new GestionePresenzeControl();
    AccountControl accountControl = new AccountControl();
    RimpiazzaControl rimpiazzaImpiegato = new RimpiazzaControl();

    DateFormat giorno = new SimpleDateFormat("dd");
    Date giorno2 = new Date();
    String dataDiOggiGiorno = giorno.format(giorno2);
    int giornoInteger = Integer.parseInt(dataDiOggiGiorno);

    DateFormat mese = new SimpleDateFormat("MM");
    Date mese2 = new Date();
    String dataDiOggiMese = mese.format(mese2);
    int meseInteger = Integer.parseInt(dataDiOggiMese);

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        LocalDate localDate = datePicker.getValue();
        if (Integer.parseInt(localDate.toString().substring(5, 7)) < meseInteger) {
            if (accountControl.returnRuolo().equals("Amministratore")) {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreAssenzaAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
                return;
            } else {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreAssenzaImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
                return;
            }
        } else if (Integer.parseInt(localDate.toString().substring(5, 7)) == meseInteger &&
                Integer.parseInt(localDate.toString().substring(8, 10)) <= giornoInteger) {
            if (accountControl.returnRuolo().equals("Amministratore")) {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreAssenzaAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
                return;
            } else {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreAssenzaImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
                return;
            }
        }
        BoundaryDBMS boundaryGestionePresenze = new BoundaryDBMS();
        if (boundaryGestionePresenze.controllaTurnoQuery(localDate.toString())) {
            if (accountControl.returnRuolo().equals("Amministratore") && !rimpiazzaImpiegato
                    .controllaNotte(localDate.toString(),
                            Integer.parseInt(accountControl.returnMatricola()))) {
                rimpiazzaImpiegato.rimpiazzaAmministratoreGiornoIntero(localDate.toString(),
                        accountControl.returnMatricola(),
                        accountControl.returnNome() + " " + accountControl.returnCognome());
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaAssenzaAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Conferma");
                stage.show();
            } else if (accountControl.returnRuolo().equals("Amministratore") && rimpiazzaImpiegato
                    .controllaNotte(localDate.toString(),
                            Integer.parseInt(accountControl.returnMatricola()))) {
                rimpiazzaImpiegato.rimpiazzaAmministratoreNotte(localDate.toString(),
                        Integer.parseInt(accountControl.returnMatricola()),
                        accountControl.returnNome() + " " + accountControl.returnCognome());
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaAssenzaAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Conferma");
                stage.show();
            } else if (!accountControl.returnRuolo().equals("Amministratore") && rimpiazzaImpiegato
                    .controllaNotte(localDate.toString(),
                            Integer.parseInt(accountControl.returnMatricola()))) {
                rimpiazzaImpiegato.rimpiazzaImpiegatoNotte(localDate.toString(),
                        Integer.parseInt(accountControl.returnMatricola()),
                        accountControl.returnNome() + " " + accountControl.returnCognome());
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaAssenzaImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Conferma");
                stage.show();
            } else {
                rimpiazzaImpiegato.rimpiazzaImpiegatoGiornoIntero(localDate.toString(),
                        accountControl.returnMatricola(),
                        accountControl.returnNome() + " " + accountControl.returnCognome());
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaAssenzaImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Conferma");
                stage.show();
            }
        } else {
            if (accountControl.returnRuolo().equals("Amministratore")) {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreAssenzaAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
            } else {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreAssenzaImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
            }
        }
    }

    @FXML
    void vaiIndietro(ActionEvent event) throws IOException {
        AccountControl accountControl = new AccountControl();
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/PannelloGestionePresenzeAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Interfaccia Principale - Amministratore");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/PannelloGestionePresenzeImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Interfaccia Principale - Impiegato");
            stage.show();
        }
    }
}