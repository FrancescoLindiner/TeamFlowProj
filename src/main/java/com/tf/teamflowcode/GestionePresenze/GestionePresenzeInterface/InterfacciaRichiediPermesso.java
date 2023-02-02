package com.tf.teamflowcode.GestionePresenze.GestionePresenzeInterface;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.RichiediPermessoControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.RimpiazzaControl;

import javafx.scene.Node;

public class InterfacciaRichiediPermesso {

    Parent parent;
    Stage stage;
    Scene scene;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField oraPicker;

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

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        RichiediPermessoControl richiediPermessoControl = new RichiediPermessoControl();
        LocalDate localDate = datePicker.getValue();
        RimpiazzaControl rimpiazzaImpiegato = new RimpiazzaControl();
        AccountControl accountControl = new AccountControl();
        try {
            if (oraPicker.getText().equals("")) {
                if (richiediPermessoControl.controllaTurno(localDate.toString())
                        && richiediPermessoControl.controlla24HTurno(localDate.toString())) {
                    if (accountControl.returnRuolo().equals("Amministratore")) {

                        // devo controllare che il numero di amministratori in servizio sia maggiore del
                        // 50% degli amministratori totali
                        if (!accountControl.impiegatiAttivi("Amministratore", 50)) {
                            parent = FXMLLoader.load(getClass()
                                    .getResource(
                                            "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoAmministratore.fxml"));
                            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            scene = new Scene(parent, 810, 500);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            return;
                        }

                        boolean isNotte = rimpiazzaImpiegato.controllaNotte(localDate.toString(),
                                Integer.parseInt(accountControl.returnMatricola()));
                        if (isNotte) {
                            rimpiazzaImpiegato.rimpiazzaAmministratoreNotte(localDate.toString(),
                                    Integer.parseInt(accountControl.returnMatricola()),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());
                        } else {
                            rimpiazzaImpiegato.rimpiazzaAmministratoreGiornoIntero(localDate.toString(),
                                    accountControl.returnMatricola(),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());
                        }
                        parent = FXMLLoader.load(getClass()
                                .getResource(
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaPermessoAmministratore.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(parent, 810, 500);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                        return;
                    } else {
                        // devo controllare che il numero di impiegati in servizio sia maggiore del
                        // 60% degli impiegati totali
                        if (!accountControl.impiegatiAttivi(accountControl.returnRuolo(), 60)) {
                            parent = FXMLLoader.load(getClass()
                                    .getResource(
                                            "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoImpiegato.fxml"));
                            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            scene = new Scene(parent, 810, 500);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            return;
                        }
                        boolean isNotte = rimpiazzaImpiegato.controllaNotte(localDate.toString(),
                                Integer.parseInt(accountControl.returnMatricola()));

                        if (isNotte) {

                            rimpiazzaImpiegato.rimpiazzaImpiegatoNotte(localDate.toString(),
                                    Integer.parseInt(accountControl.returnMatricola()),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());

                        } else {

                            rimpiazzaImpiegato.rimpiazzaImpiegatoGiornoIntero(localDate.toString(),
                                    accountControl.returnMatricola(),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());

                        }
                        parent = FXMLLoader.load(getClass()
                                .getResource(
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaPermessoImpiegato.fxml"));
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
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoAmministratore.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(parent, 810, 500);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    } else {
                        parent = FXMLLoader.load(getClass()
                                .getResource(
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoImpiegato.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(parent, 810, 500);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    }
                }
            } else if (!oraPicker.getText().equals("")) {
                if (richiediPermessoControl.controllaTurno(localDate.toString())
                        && richiediPermessoControl.controlla24HOra(localDate.toString(),
                                oraPicker.getText().substring(0, 5))
                        &&
                        richiediPermessoControl.controllaOrari(localDate.toString(), oraPicker.getText())) {
                    if (accountControl.returnRuolo().equals("Amministratore")) {
                        boolean isNotte = rimpiazzaImpiegato.controllaNotte(localDate.toString(),
                                Integer.parseInt(accountControl.returnMatricola()));
                        if (isNotte) {
                            rimpiazzaImpiegato.rimpiazzaAmministratoreNotte(localDate.toString(),
                                    Integer.parseInt(accountControl.returnMatricola()),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());

                        } else if (oraPicker.getText().equals("") || oraPicker.getText().equals(null)) {
                            rimpiazzaImpiegato.rimpiazzaAmministratoreGiornoIntero(localDate.toString(),
                                    accountControl.returnMatricola(),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());
                        } else {
                            String oraInizio = oraPicker.getText().substring(0, 5);
                            String oraFine = oraPicker.getText().substring(6, 11);
                            rimpiazzaImpiegato.rimpiazzaAmministratoreOre(localDate.toString(), oraInizio, oraFine,
                                    accountControl.returnMatricola(),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());
                        }

                        parent = FXMLLoader.load(getClass()
                                .getResource(
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaPermessoAmministratore.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(parent, 810, 500);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    } else {
                        
                        boolean isNotte = rimpiazzaImpiegato.controllaNotte(localDate.toString(),
                                Integer.parseInt(accountControl.returnMatricola()));

                        if (isNotte) {

                            rimpiazzaImpiegato.rimpiazzaImpiegatoNotte(localDate.toString(),
                                    Integer.parseInt(accountControl.returnMatricola()),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());

                        } else if (oraPicker.getText().equals("") || oraPicker.getText().equals(null)) {

                            rimpiazzaImpiegato.rimpiazzaImpiegatoGiornoIntero(localDate.toString(),
                                    accountControl.returnMatricola(),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());

                        } else {
                            String oraInizio = oraPicker.getText().substring(0, 5);
                            String oraFine = oraPicker.getText().substring(6, 11);
                            rimpiazzaImpiegato.rimpiazzaImpiegatoOre(localDate.toString(),
                                    oraInizio, oraFine, accountControl.returnMatricola(),
                                    accountControl.returnNome() + " " + accountControl.returnCognome());
                        }
                        parent = FXMLLoader.load(getClass()
                                .getResource(
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaPermessoImpiegato.fxml"));
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
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoAmministratore.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(parent, 810, 500);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    } else {
                        parent = FXMLLoader.load(getClass()
                                .getResource(
                                        "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoImpiegato.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(parent, 810, 500);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    }
                }
            } else {
                if (accountControl.returnRuolo().equals("Amministratore")) {
                    parent = FXMLLoader.load(getClass()
                            .getResource(
                                    "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoAmministratore.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(parent, 810, 500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                } else {
                    parent = FXMLLoader.load(getClass()
                            .getResource(
                                    "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoImpiegato.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(parent, 810, 500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (NullPointerException e) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/PannelloErrorePermessoImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }

    }
}