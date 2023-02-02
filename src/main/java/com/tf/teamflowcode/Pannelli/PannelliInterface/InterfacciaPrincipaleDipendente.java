package com.tf.teamflowcode.Pannelli.PannelliInterface;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.scene.Node;

public class InterfacciaPrincipaleDipendente implements Initializable {

    Parent parent;
    Stage stage;
    Scene scene;

    BoundaryDBMS boundaryPannelli = new BoundaryDBMS();

    @FXML
    private Button buttonImpostazioni;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label nomeUtente;

    @FXML
    private Label labelAperto1;

    @FXML
    private Label labelAperto2;

    @FXML
    private Label labelAperto3;

    @FXML
    private Label labelAperto4;

    @FXML
    private Label labelChiuso1;

    @FXML
    private Label labelChiuso2;

    @FXML
    private Label labelChiuso3;

    @FXML
    private Label labelChiuso4;

    @FXML
    private Label labelMatricola;

    @FXML
    private Label labelApertoImpiegato;

    @FXML
    private Label labelChiusoImpiegato;

    @FXML
    private Label labelServizioImpiegato;

    @FXML
    private Label labelImpiegatiAttivi1;

    @FXML
    private Label labelImpiegatiAttivi2;

    @FXML
    private Label labelImpiegatiAttivi3;

    @FXML
    private Label labelImpiegatiAttivi4;

    AccountControl accountControl = new AccountControl();

    public void setData() {
        AccountControl accountControl = new AccountControl();

        DateFormat Date = DateFormat.getDateInstance();

        Calendar cals = Calendar.getInstance();

        String currentDate = Date.format(cals.getTime());

        label1.setText("Turno del " + currentDate);

        label2.setText("Ciao " + accountControl.returnNome());

        labelMatricola.setText("Matricola: " + accountControl.returnMatricola());
    }

    public void setNomeUtente() {
        nomeUtente.setText(accountControl.returnNome() + " " + accountControl.returnCognome());
    }

    public void setServizi() {
        int totaliImpiegati = 0;
        if (accountControl.returnRuolo().equals("Amministratore")) {

            if (accountControl.impiegatiAttivi("Impiegato A", 50)) {
                labelAperto1.setVisible(true);
                labelChiuso1.setVisible(false);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato A");
                labelImpiegatiAttivi1.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato A")) + "/"
                                + totaliImpiegati);
            } else {
                labelAperto1.setVisible(false);
                labelChiuso1.setVisible(true);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato A");
                labelImpiegatiAttivi1.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato A")) + "/"
                                + totaliImpiegati);
            }
            if (accountControl.impiegatiAttivi("Impiegato B", 60)) {
                labelAperto2.setVisible(true);
                labelChiuso2.setVisible(false);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato B");
                labelImpiegatiAttivi2.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato B")) + "/"
                                + totaliImpiegati);
            } else {
                labelAperto2.setVisible(false);
                labelChiuso2.setVisible(true);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato B");
                labelImpiegatiAttivi2.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato B")) + "/"
                                + totaliImpiegati);
            }
            if (accountControl.impiegatiAttivi("Impiegato C", 60)) {
                labelAperto3.setVisible(true);
                labelChiuso3.setVisible(false);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato C");
                labelImpiegatiAttivi3.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato C")) + "/"
                                + totaliImpiegati);
            } else {
                labelAperto3.setVisible(false);
                labelChiuso3.setVisible(true);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato C");
                labelImpiegatiAttivi3.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato C")) + "/"
                                + totaliImpiegati);
            }
            if (accountControl.impiegatiAttivi("Impiegato D", 60)) {
                labelAperto4.setVisible(true);
                labelChiuso4.setVisible(false);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato D");
                labelImpiegatiAttivi4.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato D")) + "/"
                                + totaliImpiegati);
            } else {
                labelAperto4.setVisible(false);
                labelChiuso4.setVisible(true);
                totaliImpiegati = accountControl.prendiImpiegati("Impiegato D");
                labelImpiegatiAttivi4.setText(
                        Integer.toString(accountControl.impiegatiAttiviParziali("Impiegato D")) + "/"
                                + totaliImpiegati);
            }
        } else {
            labelServizioImpiegato.setText("Servizio " + accountControl.returnRuolo().substring(10, 11));
            if (accountControl.impiegatiAttivi(accountControl.returnRuolo(), 60)) {
                labelApertoImpiegato.setVisible(true);
                labelChiusoImpiegato.setVisible(false);
            } else {
                labelApertoImpiegato.setVisible(false);
                labelChiusoImpiegato.setVisible(true);
            }
        }
    }

    public void setOrario() throws SQLException {
        List<String> orari = boundaryPannelli.getOrari();
        if (orari != null && orari.size() == 2 && orari.get(0).equals("00:00:00")) {
            label3.setText("oggi hai il giorno libero");
            label4.setText(" ");
        } else if (orari != null && orari.size() == 2 && orari.get(0).equals("22:00:00")) {
            label3.setText("oggi il tuo turno cominicia alle");
            label4.setText("22:00 e termina alle 06:00");
        } else if (orari != null && orari.size() == 4) {
            String oraInizioMattina = orari.get(0);
            String oraFineMattina = orari.get(1);
            String oraInizioPomeriggio = orari.get(2);
            String oraFinePomeriggio = orari.get(3);
            label3.setText("oggi i tuoi turni sono ai seguenti orari:");
            label4.setText(oraInizioMattina.substring(0, 5) + "-" + oraFineMattina.substring(0, 5) + " e "
                    + oraInizioPomeriggio.substring(0, 5) + "-" + oraFinePomeriggio.substring(0, 5));
        } else {
            label3.setText("oggi non hai turni di lavoro");
            label4.setText(" ");
        }
    }

    @FXML
    void buttonImpostazioni(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/impostazioniAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Impostazioni");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/impostazioniImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Impostazioni");
            stage.show();
        }
    }

    @FXML
    void apriGestioneImpiegati(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneImpiegati/fxml/GestioneImpiegati.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Gestione Impiegati");
        stage.show();
    }

    @FXML
    void buttonLogout(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestioneAccount/fxml/LogoutAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestioneAccount/fxml/LogoutImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    void buttonTurni(ActionEvent event) throws IOException, ParseException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestioneOrariEStipendi/fxml/Turni.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Turni");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestioneOrariEStipendi/fxml/TurniImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Turni");
            stage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
        setNomeUtente();
        setServizi();
        try {
            setOrario();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void mostraStipendi(ActionEvent event) throws IOException {
        /*
         * if (dataDiOggi.equals("27") && oraDiOggi.equals("00:00")) {
         * ControlStipendi controlStipendi = new ControlStipendi();
         * controlStipendi.generaStipendi();
         * }
         */

        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestioneOrariEStipendi/fxml/StipendioAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Stipendio");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestioneOrariEStipendi/fxml/StipendioImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Stipendio");
            stage.show();
        }

    }

    @FXML
    void buttonRichiediPermesso(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/RichiediPermessoAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Richiedi Permesso");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/RichiediPermessoImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Richiedi Permesso");
            stage.show();
        }
    }

    @FXML
    void buttonFirma(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestionePresenze/fxml/InterfacciaFirma.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Firma");
        stage.show();
    }

    @FXML
    void buttonFirmaRemoto(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/FirmaDaRemotoAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Firma Da Remoto");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/FirmaDaRemotoImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Firma Da Remoto");
            stage.show();
        }

    }

    @FXML
    void buttonNotifiche(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/Pannelli/fxml/SezioneNotifiche.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Sezione notifiche");
        stage.show();
    }

    @FXML
    void buttonGestionePresenze(ActionEvent event) throws IOException {
        if (accountControl.returnRuolo().equals("Amministratore")) {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/PannelloGestionePresenzeAmministratore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Gestione Presenze");
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/GestionePresenze/fxml/PannelloGestionePresenzeImpiegato.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Gestione Presenze");
            stage.show();
        }
    }

    @FXML
    void buttonGestioneFerie(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestionePresenze/fxml/GestioneFerie.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Interfaccia Principale - Amministratore");
        stage.show();
    }
}