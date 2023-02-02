package com.tf.teamflowcode.GestionePresenze.GestionePresenzeInterface;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.GestioneFerieControl;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class InterfacciaRichiediFerie implements Initializable {

    Parent parent;
    Stage stage;
    Scene scene;

    AccountControl accountControl = new AccountControl();
    BoundaryDBMS boundaryGestionePresenze = new BoundaryDBMS();

    @FXML
    private DatePicker datePicker1;

    @FXML
    private DatePicker datePicker2;

    @FXML
    private Button buttonIndietro;

    @FXML
    private Label labelPeriodoRosso;

    public boolean controllaGiorni() {

        LocalDate localDate1 = datePicker1.getValue();
        LocalDate localDate2 = datePicker2.getValue();

        long daysBetween = ChronoUnit.DAYS.between(localDate1, localDate2) + 1;
        GestioneFerieControl gestioneFerieControl = new GestioneFerieControl();

        List<Integer> list = gestioneFerieControl.controllaRichiestaFerie();

        if (daysBetween <= 7) {
            if (list.size()!=0) {
                // invece di ritornare un booleano ritorno un lista che contiene gli id_ferie
                // se questa lista non è vuota
                // prendo la data inizio e la data fine ferie
                String dataInizioFerie = "";
                String dataFineFerie = "";
                long daysBetween2 = 0;
                for (Integer integer : list) {
                    dataInizioFerie = gestioneFerieControl.prendiDataInizioFerie(integer);
                    dataFineFerie = gestioneFerieControl.prendiDataFineFerie(integer);
                    LocalDate localDateInizioFerie = LocalDate.parse(dataInizioFerie);
                    LocalDate localDateFineFerie = LocalDate.parse(dataFineFerie);
                    daysBetween2 += ChronoUnit.DAYS.between(localDateInizioFerie, localDateFineFerie) + 1;

                }
                if (daysBetween2 + daysBetween <= 7) {
                    return true;
                } else {
                    return false;
                }

            }

        } else {
            return false;
        }
        return true;
    }

    @FXML
    void buttonConferma(ActionEvent event) throws IOException {
        // controlla se il periodo si accavalla con il periodo rosso oppure ha richiesto
        // le ferie per questo trimestre
        LocalDate localDate1 = datePicker1.getValue();
        LocalDate localDate2 = datePicker2.getValue();
        // si deve controllare che il numero di giorni sia minore o uguale a 7

        if (!boundaryGestionePresenze.controllaPeriodoRosso(localDate1, localDate2)
                && !boundaryGestionePresenze.controllaDateFerie(localDate1) && controllaGiorni()) {
            boundaryGestionePresenze.registraFerie(localDate1.toString(), localDate2.toString());
            if (accountControl.returnRuolo().equals("Amministratore")) {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaRichiediAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
            } else {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaRichiediImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
            }
        } else {
            if (accountControl.returnRuolo().equals("Amministratore")) {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreRichiediAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Errore");
                stage.show();
            } else {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreRichiediImpiegato.fxml"));
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
    void buttonVaiIndietro(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/PannelloGestionePresenzeAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Impostazioni");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/PannelloGestionePresenzeImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Impostazioni");
            stage.show();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String inizioPeriodoRosso = boundaryGestionePresenze.prendiDataInizioRossoQuery();

        if (inizioPeriodoRosso == null) {
            labelPeriodoRosso.setVisible(false);
        } else {
            labelPeriodoRosso.setText("Attenzione: non è possibile richiedere ferie dal "
                    + boundaryGestionePresenze.prendiDataInizioRossoQuery() + " al "
                    + boundaryGestionePresenze.prendiDataFineRossoQuery());
        }
    }
}