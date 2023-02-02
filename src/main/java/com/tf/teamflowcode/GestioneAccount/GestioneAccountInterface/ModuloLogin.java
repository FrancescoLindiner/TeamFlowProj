package com.tf.teamflowcode.GestioneAccount.GestioneAccountInterface;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.GestioneOrariEStipendi.GestioneOrariEStipendiControl.ControlStipendi;
import com.tf.teamflowcode.GestioneOrariEStipendi.GestioneOrariEStipendiControl.GeneraOrarioControl;
import com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl.ControlFirma;

import javafx.scene.Node;

public class ModuloLogin {

    Parent parent;
    Stage stage;
    Scene scene;

    @FXML
    private TextField passwordText;

    @FXML
    private CheckBox checkBox;

    @FXML
    private PasswordField password;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFiled;

    @FXML
    private Button loginButton;

    @FXML
    private Button recuperaPasswordButton;

    @FXML
    void login(ActionEvent event) throws IOException, InterruptedException {

        AccountControl accountControl = new AccountControl();
        boolean isCorrect = accountControl.controllaDatiLogin(textFiled.getText(), password.getText());
        if (!isCorrect || textFiled.getText() == "" || password.getText() == "") {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/SplashScreenErrore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            parent = FXMLLoader.load(getClass()
                    .getResource(
                            "/com/tf/teamflowcode/Pannelli/fxml/splahScreenConfirm.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent, 810, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        GeneraOrarioControl generaOrarioControl = new GeneraOrarioControl();

        /*
         * Runnable task = new Runnable() {
         * public void run() {
         * if (f.format(new Date()).equals("01-28")) {
         * generaOrarioControl.eliminaOrari();
         * generaOrarioControl.generaOrari(91);
         * 
         * } else if (f.format(new Date()).equals("04-28")) {
         * generaOrarioControl.eliminaOrari();
         * generaOrarioControl.generaOrari(91);
         * 
         * } else if (f.format(new Date()).equals("07-28")) {
         * generaOrarioControl.eliminaOrari();
         * generaOrarioControl.generaOrari(92);
         * 
         * } else if (f.format(new Date()).equals("10-28")) {
         * generaOrarioControl.eliminaOrari();
         * generaOrarioControl.generaOrari(92);
         * 
         * }
         * date.add(Calendar.MONTH, 3);
         * }
         * };
         * executor.scheduleAtFixedRate(task, 0, 90, TimeUnit.DAYS);
         */
        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);

        ControlStipendi controlStipendi = new ControlStipendi();
        Runnable task2 = new Runnable() {
            public void run() {
                if (!controlStipendi.isGenerati()) {
                    ControlStipendi controlStipendi = new ControlStipendi();
                    controlStipendi.generaStipendi();
                }
            }
        };

        LocalDate nextExecution2 = LocalDate.now().withDayOfMonth(27);
        if (nextExecution2.isBefore(LocalDate.now()))
            nextExecution2 = nextExecution2.plusMonths(1);

        Duration initialDelay2 = Duration.between(LocalDateTime.now(), nextExecution2.atTime(0, 0));

        // Period.ofMonths(1).toTotalMonths() non esiste
        // in alternativa si può usare TimeUnit.DAYS.toMillis(30)
        executor2.scheduleAtFixedRate(task2, initialDelay2.toMillis(), Duration.ofDays(30).toMillis(),
                TimeUnit.MILLISECONDS);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            public void run() {
                if (!generaOrarioControl.isGenerato()) {
                    generaOrarioControl.eliminaOrari();
                    System.out.println("\n\n\nGenerazione turni...\n\n\n");
                    generaOrarioControl.generaOrari(92);
                    System.out.println("\n\n\nTurni generati\n\n\n");
                }
            }
        };

        LocalDate nextJan28 = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)).withMonth(1)
                .withDayOfMonth(28);
        LocalDate nextApr28 = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)).withMonth(4)
                .withDayOfMonth(28);
        LocalDate nextJul28 = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)).withMonth(7)
                .withDayOfMonth(28);
        LocalDate nextOct28 = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)).withMonth(10)
                .withDayOfMonth(28);

        LocalDate nextExecution = nextJan28;
        if (nextExecution.isBefore(LocalDate.now()))
            nextExecution = nextApr28;
        if (nextExecution.isBefore(LocalDate.now()))
            nextExecution = nextJul28;
        if (nextExecution.isBefore(LocalDate.now()))
            nextExecution = nextOct28;

        Duration initialDelay = Duration.between(LocalDateTime.now(), nextExecution.atTime(0, 0));

        executor.scheduleAtFixedRate(task, initialDelay.toMillis(), Duration.ofDays(90).toMillis(),
                TimeUnit.MILLISECONDS);

        ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(1);

        Runnable task3 = new Runnable() {
            public void run() {
                DateFormat data = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String dataDiOggi = data.format(date);
                if (dataDiOggi.equals("01:00")) {
                    ControlFirma controlFirma = new ControlFirma();
                    List<Dipendente> list = controlFirma.returnList();
                    for (Dipendente dipendente : list) {
                        if (!controlFirma.controllaFirme(dipendente.getMatricola())) {
                            System.out.println(dipendente + "\nNon ha firmato l'uscita");
                            // invio mail
                        }
                    }
                }
            }
        };

        LocalDate nextExecution3 = LocalDate.now();

        Duration initialDelay3 = Duration.between(LocalDateTime.now(), nextExecution3.atTime(1, 0));

        // Period.ofMonths(1).toTotalMonths() non esiste
        // in alternativa si può usare TimeUnit.DAYS.toMillis(30)
        executor3.scheduleAtFixedRate(task3, initialDelay3.toMillis(), Duration.ofDays(1).toMillis(),
                TimeUnit.MILLISECONDS);

    }

    @FXML
    void showPassword(ActionEvent event) {
        if (checkBox.isSelected()) {
            passwordText.setText(password.getText());
            passwordText.setVisible(true);
            password.setVisible(false);
            return;
        }
        password.setText(passwordText.getText());
        password.setVisible(true);
        passwordText.setVisible(false);
    }

    @FXML
    void recuperaPassword(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass()
                .getResource(
                        "/com/tf/teamflowcode/GestioneAccount/fxml/RecuperaPassword.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent, 810, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Recupera Password");
        stage.show();
    }

    @FXML
    void initialize() {
        assert loginButton != null
                : "fx:id=\"loginButton\" was not injected: check your FXML file 'fxmlLogin.fxml'.";
        assert recuperaPasswordButton != null
                : "fx:id=\"recuperaPasswordButton\" was not injected: check your FXML file 'fxmlLogin.fxml'.";
        // Impostato il thread per l'aggiornamento degli stipendi
    }

}
