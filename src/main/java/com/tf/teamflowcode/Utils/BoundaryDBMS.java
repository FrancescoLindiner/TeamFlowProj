package com.tf.teamflowcode.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.Entity.Permesso;
import com.tf.teamflowcode.Entity.Turno;
import com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiControl.AggiungiControl;
import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;

public class BoundaryDBMS {

    public static List<Dipendente> list = new ArrayList<>();

    final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public void cercaImpiegatoQuery(String nome, String cognome, String matricola) {
        Statement stmt = null;
        Connection conn = null;

        String nomeDB = "";
        String cognomeDB = "";
        String matricolaDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE nome='" + nome
                    + "' AND cognome='" + cognome + "' AND matricola='" + matricola + "';";

            System.out.println("Cheching record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getString("tipologia");
                list.add(new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void cercaImpiegatoPerCognomeEMatricolaQuery(String cognome, String matricola) {
        Statement stmt = null;
        Connection conn = null;

        String nomeDB = "";
        String cognomeDB = "";
        String matricolaDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE cognome='" + cognome + "' AND matricola='" + matricola + "';";

            System.out.println("Cheching record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getString("tipologia");
                list.add(new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void cercaImpiegatoPerNomeEMatricolaQuery(String nome, String matricola) {
        Statement stmt = null;
        Connection conn = null;

        String nomeDB = "";
        String cognomeDB = "";
        String matricolaDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE nome='" + nome + "' AND matricola='" + matricola + "';";

            System.out.println("Cheching record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getString("tipologia");
                list.add(new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void cercaImpiegatoPerNomeECognomeQuery(String nome, String cognome) {
        Statement stmt = null;
        Connection conn = null;

        String nomeDB = "";
        String cognomeDB = "";
        String matricolaDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE nome='" + nome + "' AND cognome='" + cognome + "';";

            System.out.println("Cheching record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getString("tipologia");
                list.add(new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void cercaImpiegatoPerMatricolaQuery(String matricola) {
        Statement stmt = null;
        Connection conn = null;

        String nomeDB = "";
        String cognomeDB = "";
        String matricolaDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE matricola='" + matricola + "';";

            System.out.println("Cheching record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getString("tipologia");
                list.add(new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void cercaImpiegatoPerNomeQuery(String nome) {
        Statement stmt = null;
        Connection conn = null;

        String nomeDB = "";
        String cognomeDB = "";
        String matricolaDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE nome='" + nome + "';";

            System.out.println("Cheching record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getString("tipologia");
                list.add(new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void cercaImpiegatoPerCognomeQuery(String cognome) {
        Statement stmt = null;
        Connection conn = null;

        String nomeDB = "";
        String cognomeDB = "";
        String matricolaDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE cognome='" + cognome + "';";

            System.out.println("Cheching record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getString("tipologia");
                list.add(new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void modificaImpiegatoEmailQuery(ObservableList<Dipendente> impiegato, String email) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "UPDATE dipendente SET email='" + email + "' WHERE matricola="
                    + impiegato.get(0).getMatricola();

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void modificaImpiegatoGradoQuery(ObservableList<Dipendente> impiegato, String grado) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "UPDATE dipendente SET tipologia='" + grado + "' WHERE matricola="
                    + impiegato.get(0).getMatricola();

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void modificaImpiegatoQuery(ObservableList<Dipendente> impiegato, String grado, String email) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "UPDATE dipendente SET tipologia='" + grado + "', email='"
                    + email + "' WHERE matricola=" + impiegato.get(0).getMatricola();

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void rimuoviImpiegatoQuery(ObservableList<Dipendente> impiegato) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "DELETE FROM dipendente WHERE matricola=" + impiegato.get(0).getMatricola() + ";";

            System.out.println("Deleting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void aggiungiImpiegatoQuery(String nome, String cognome, String grado, String email, ActionEvent event)
            throws IOException {
        Statement stmt = null;
        Connection conn = null;

        AggiungiControl aggiungiControl = new AggiungiControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO dipendente (nome, cognome, email, password, tipologia) VALUES ('" + nome + "', '"
                    + cognome + "', '" + email + "', '" + aggiungiControl.generatePassword() + "', '" + grado + "');";

            DateFormat anno = new SimpleDateFormat("yyyy");
            Date anno2 = new Date();
            String dataDiOggiAnno = anno.format(anno2);

            DateFormat mese = new SimpleDateFormat("MM");
            Date mese2 = new Date();
            String dataDiOggimese = mese.format(mese2);
            int meseInteger = Integer.parseInt(dataDiOggimese);

            String sql2 = "INSERT INTO stipendio (anno_s, mese_s, s_matricola, ore_straordinario_1, ore_straordinario_2, ore_straordinario_3, ore_straordinario_4, importo) VALUES( '"
                    + dataDiOggiAnno + "', '" + meseInteger
                    + "', (SELECT matricola from dipendente WHERE nome='" + nome + "' AND cognome='" + cognome
                    + "'), 0, 0, 0, 0, 0 );";
            String sql3 = "INSERT INTO stipendio (anno_s, mese_s, s_matricola, ore_straordinario_1, ore_straordinario_2, ore_straordinario_3, ore_straordinario_4, importo) VALUES( '"
                    + dataDiOggiAnno + "', '" + (meseInteger + 1)
                    + "', (SELECT matricola from dipendente WHERE nome='" + nome + "' AND cognome='" + cognome
                    + "'), 0, 0, 0, 0, 0);";
            String sql4 = "INSERT INTO stipendio (anno_s, mese_s, s_matricola, ore_straordinario_1, ore_straordinario_2, ore_straordinario_3, ore_straordinario_4, importo) VALUES( '"
                    + dataDiOggiAnno + "', '" + (dataDiOggimese + 2)
                    + "', (SELECT matricola from dipendente WHERE nome='" + nome + "' AND cognome='" + cognome
                    + "'), 0, 0, 0, 0, 0 );";

            System.out.println("Inserting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    String emailDB = "";
    String passowrdDB = "";
    static Dipendente dipendente;

    Parent parent;
    Stage stage;
    Scene scene;

    public boolean controllaDatiLogin(String email, String password) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT email, password FROM dipendente WHERE email='" + email + "' AND password='" + password
                    + "';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                emailDB = rs.getNString("email");
                passowrdDB = rs.getNString("password");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (emailDB.equals(email) && passowrdDB.equals(password)) {
            dipendente = getInformazioniDipendenteQuery(this.emailDB, this.passowrdDB);
            return true;
        } else {
            return false;
        }
    }

    public Dipendente getInformazioniDipendenteQuery(String email, String password) {
        Statement stmt = null;
        Connection conn = null;
        String matricolaDB = "";
        String nomeDB = "";
        String cognomeDB = "";
        String emailDB = "";
        String tipologiaDB = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT matricola, nome, cognome, email, tipologia FROM dipendente WHERE email='" + email
                    + "' AND password='"
                    + password
                    + "';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                matricolaDB = rs.getString("matricola");
                nomeDB = rs.getString("nome");
                cognomeDB = rs.getString("cognome");
                emailDB = rs.getString("email");
                tipologiaDB = rs.getNString("tipologia");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new Dipendente(matricolaDB, nomeDB, cognomeDB, emailDB, tipologiaDB);
    }

    public void modificaPassword(String text, ActionEvent event) throws IOException {
        AccountControl accountControl = new AccountControl();

        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "UPDATE dipendente SET password='" + text + "' WHERE matricola="
                    + accountControl.returnMatricola() + ";";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            if (accountControl.returnRuolo().equals("Amministratore")) {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaModificaPwAmministratore.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Password Modificata");
                stage.show();
            } else {
                parent = FXMLLoader.load(getClass()
                        .getResource(
                                "/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaModificaPwImpiegato.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(parent, 810, 500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Password Modificata");
                stage.show();
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean controllaEmailQuery(String email) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT email FROM dipendente WHERE email='" + email + "';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                if (email.equals(rs.getString("email"))) {
                    return true;
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<String> getStipendioQuery(String matricola) {

        Statement stmt = null;
        Connection conn = null;
        double stipendio = 0.0;
        int anno = 0;
        int mese = 0;
        List<String> lista = new ArrayList<>();

        DateFormat anno2 = new SimpleDateFormat("yyyy");
        Date anno3 = new Date();
        String annoDiOggi = anno2.format(anno3);

        DateFormat mese2 = new SimpleDateFormat("MM");
        Date mese3 = new Date();
        String meseDiOggi = mese2.format(mese3);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT importo, anno_s, mese_s FROM stipendio WHERE s_matricola='" + matricola
                    + "' AND anno_s='" + annoDiOggi + "' AND mese_s='" + meseDiOggi + "';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                stipendio = rs.getDouble("importo");
                anno = rs.getInt("anno_s");
                mese = rs.getInt("mese_s");
            }
            lista.add(Double.toString(stipendio));
            lista.add(Integer.toString(anno));
            lista.add(Integer.toString(mese));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public ObservableList<String> returnListaStipendiQuery() {
        Statement stmt = null;
        Connection conn = null;

        ObservableList<String> listaStipendi = FXCollections.observableArrayList();
        AccountControl accountControl = new AccountControl();

        DateFormat mese2 = new SimpleDateFormat("MM");
        Date mese3 = new Date();
        String meseDiOggi = mese2.format(mese3);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT importo, anno_s, mese_s, ore_straordinario_1, ore_straordinario_2, ore_straordinario_3, ore_straordinario_4 FROM stipendio WHERE s_matricola="
                    + accountControl.returnMatricola() + " AND mese_s<='" + meseDiOggi + "';";

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                double stipendio = rs.getDouble("importo");
                int anno = rs.getInt("anno_s");
                int mese = rs.getInt("mese_s");
                int ore_straordinario1 = rs.getInt("ore_straordinario_1");
                int ore_straordinario2 = rs.getInt("ore_straordinario_2");
                int ore_straordinario3 = rs.getInt("ore_straordinario_3");
                int ore_straordinario4 = rs.getInt("ore_straordinario_4");

                listaStipendi
                        .add(stipendio + " €" + ", Data: " + anno + "-" + mese + ", Ore straordinario:\nServizio A: "
                                + ore_straordinario1 + "\nServizio B: " + ore_straordinario2 + "\nServizio C: "
                                + ore_straordinario3 + "\nServizio D: " + ore_straordinario4);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaStipendi;
    }

    public void aggiornaStipendioQuery(String tipologia, int presenze, int oreStraordinario1, int oreStraordinario2,
            int oreStraordinario3, int oreStraordinario4, String matricola) {

        int importoStipendio = 0;

        if (tipologia.equals("Amministratore")) {
            importoStipendio = 2500;
        } else if (tipologia.equals("Impiegato A")) {
            importoStipendio = 2100;
        } else if (tipologia.equals("Impiegato B")) {
            importoStipendio = 2000;
        } else if (tipologia.equals("Impiegato C")) {
            importoStipendio = 1900;
        } else if (tipologia.equals("Impiegato D")) {
            importoStipendio = 1800;
        }
        if (presenze >= 13) {
            importoStipendio += 150;
        }

        importoStipendio += oreStraordinario1 * 28;
        importoStipendio += oreStraordinario2 * 26;
        importoStipendio += oreStraordinario3 * 24;
        importoStipendio += oreStraordinario4 * 22;

        Statement stmt = null;
        Connection conn = null;

        DateFormat anno = new SimpleDateFormat("yyyy");
        Date anno2 = new Date();
        String dataDiOggiAnno = anno.format(anno2);

        DateFormat mese = new SimpleDateFormat("MM");
        Date mese2 = new Date();
        String dataDiOggimese = mese.format(mese2);
        if (dataDiOggimese.equals("12")) {
            if (tipologia.equals("Amministratore")) {
                importoStipendio += 2500;
            } else if (tipologia.equals("Impiegato A")) {
                importoStipendio += 2100;
            } else if (tipologia.equals("Impiegato B")) {
                importoStipendio += 2000;
            } else if (tipologia.equals("Impiegato C")) {
                importoStipendio += 1900;
            } else if (tipologia.equals("Impiegato D")) {
                importoStipendio += 1800;
            }
        }

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "UPDATE stipendio SET importo=" + importoStipendio + " WHERE anno_s=" + dataDiOggiAnno
                    + " AND mese_s=" + dataDiOggimese + " AND s_matricola=" + matricola + ";";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int prediOreStraordinarioQuery(String matricola2, int num_servizio) {
        Statement stmt = null;
        Connection conn = null;

        DateFormat anno = new SimpleDateFormat("yyyy");
        Date anno2 = new Date();
        String dataDiOggiAnno = anno.format(anno2);

        DateFormat mese = new SimpleDateFormat("MM");
        Date mese2 = new Date();
        String dataDiOggimese = mese.format(mese2);

        int ore = 0;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT ore_straordinario_" + num_servizio + " FROM stipendio WHERE s_matricola=" + matricola2
                    + " AND anno_s='"
                    + dataDiOggiAnno + "' AND mese_s='" + dataDiOggimese + "';";

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ore += rs.getInt("ore_straordinario_" + num_servizio);
            }
            System.out.println("Ore straordinario " + num_servizio + ": " + ore);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ore;
    }

    public int prendiPresenzeQuery(String matricola) {
        Statement stmt = null;
        Connection conn = null;

        int ore = 0;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT count(presenza) FROM turno WHERE presenza=" + true + " AND t_matricola=" + matricola
                    + ";";

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                ore = rs.getInt("count(presenza)");
            }
            System.out.println(ore);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ore;
    }

    public List<Dipendente> returnListaDipendentiQuery() {
        Statement stmt = null;
        Connection conn = null;

        List<Dipendente> lista = new ArrayList<>();

        String matricola = "";
        String nome = "";
        String cognome = "";
        String email = "";
        String tipologia = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT matricola, nome, cognome, email, tipologia FROM dipendente";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricola = rs.getString("matricola");
                nome = rs.getString("nome");
                cognome = rs.getString("cognome");
                email = rs.getString("email");
                tipologia = rs.getString("tipologia");

                lista.add(new Dipendente(matricola, nome, cognome, email, tipologia));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public void inserisciTupleStipendiQuery(String matricola, String dataDiOggiAnno, int meseInteger) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO stipendio (anno_s, mese_s, s_matricola, ore_straordinario_1, ore_straordinario_2, ore_straordinario_3, ore_straordinario_4, importo) VALUES ('"
                    + dataDiOggiAnno + "', '" + Integer.toString(meseInteger) + "', '" + matricola
                    + "', 0, 0, 0, 0, 0);";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void caricaGiornoLiberoQuery(String matricola, String data) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'libero', '" + matricola + "', '-', '-', " + false
                    + ", " + false + ", " + false + ");";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void caricaTurnoNotturnoQuery(String matricola, String data, String oraNotteInizio2, String oraNotteFine2) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");
            System.out.println("Inserimento turno notturno");
            String sql = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'notte', '" + matricola + "', '" + oraNotteInizio2 + "', '" + oraNotteFine2 + "', " + false
                    + ", " + false + ", " + false + ");";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void caricaITurni1Query(String matricola, String data, String ora_inizioMattina2, String ora_fineMattina2,
            String ora_inizioPome2, String ora_finePome2) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");
            System.out.println("Inserimento turno mattina");
            String sql = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'mattina', '" + matricola + "', '" + ora_inizioMattina2 + "', '" + ora_fineMattina2 + "', "
                    + false + ", " + false + ", " + false + ");";

            System.out.println("Inserimento turno pomeriggio");
            String sql2 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'pomeriggio', '" + matricola + "', '" + ora_inizioPome2 + "', '" + ora_finePome2 + "', "
                    + false + ", " + false + ", " + false + ");";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void caricaITurni2Query(String matricola, String data, String ora_inizioMattina2, String ora_fineMattina2,
            String ora_inizioPome2, String ora_finePome2) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            System.out.println("Inserimento turno mattina");
            String sql = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'mattina', '" + matricola + "', '" + ora_inizioMattina2 + "', '" + ora_fineMattina2 + "', "
                    + false + ", " + false + ", " + false + ");";
            System.out.println("Inserimento turno pomeriggio");
            String sql2 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'pomeriggio', '" + matricola + "', '" + ora_inizioPome2 + "', '" + ora_finePome2 + "', "
                    + false + ", " + false + ", " + false + ");";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void caricaITurni3Query(String matricola, String data, String ora_inizioMattina2, String ora_fineMattina2,
            String ora_inizioPome2, String ora_finePome2) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'mattina', '" + matricola + "', '" + ora_inizioMattina2 + "', '" + ora_fineMattina2 + "', "
                    + false + ", " + false + ", " + false + ");";

            String sql2 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'pomeriggio', '" + matricola + "', '" + ora_inizioPome2 + "', '" + ora_finePome2 + "', "
                    + false + ", " + false + ", " + false + ");";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Dipendente> prendiImpiegatiQuery() {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Statement stmt = null;
        Connection conn = null;

        String matricola = "";
        String nome = "";
        String cognome = "";
        String email = "";
        String tipologia = "";

        List<Dipendente> list = new ArrayList<>();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE matricola NOT IN (SELECT f_matricola FROM ferie)";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricola = rs.getString("matricola");
                nome = rs.getString("nome");
                cognome = rs.getString("cognome");
                email = rs.getString("email");
                tipologia = rs.getString("tipologia");
                list.add(new Dipendente(matricola, nome, cognome, email, tipologia));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void eliminaOrariQuery() {

        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "DELETE FROM turno";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ObservableList<Turno> prendiTurniQuery() {

        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Statement stmt = null;
        Connection conn = null;

        String data = "";
        String descrizione = "";
        String ora_inizio = "";
        String ora_fine = "";
        AccountControl accountControl = new AccountControl();
        ObservableList<Turno> list = FXCollections.observableArrayList();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data, descrizione, ora_inizio, ora_fine FROM turno WHERE t_matricola="
                    + accountControl.returnMatricola() + ";";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                data = rs.getString("data");
                descrizione = rs.getString("descrizione");
                ora_inizio = rs.getString("ora_inizio");
                ora_fine = rs.getString("ora_fine");
                list.add(new Turno(data, descrizione, ora_inizio, ora_fine));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean queryIsGenerati() {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Statement stmt = null;
        Connection conn = null;

        DateFormat anno = new SimpleDateFormat("yyyy");
        Date annoDate = new Date();
        String annoDiOggi = anno.format(annoDate);

        DateFormat mese = new SimpleDateFormat("MM");
        Date meseDate = new Date();
        String meseDiOggi = mese.format(meseDate);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT importo FROM stipendio WHERE anno_s='" + annoDiOggi + "' AND mese_s='" + meseDiOggi
                    + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getInt("importo") == 0) {
                    return false;
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public List<Dipendente> prendiTuttiGliImpiegati() {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Statement stmt = null;
        Connection conn = null;

        String matricola = "";
        String nome = "";
        String cognome = "";
        String email = "";
        String tipologia = "";

        List<Dipendente> list = new ArrayList<>();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricola = rs.getString("matricola");
                nome = rs.getString("nome");
                cognome = rs.getString("cognome");
                email = rs.getString("email");
                tipologia = rs.getString("tipologia");
                list.add(new Dipendente(matricola, nome, cognome, email, tipologia));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Dipendente> prendiImpiegatiConFerie() {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Statement stmt = null;
        Connection conn = null;

        String matricola = "";
        String nome = "";
        String cognome = "";
        String email = "";
        String tipologia = "";

        List<Dipendente> list = new ArrayList<>();

        DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataDiOggi = data.format(date);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT * FROM dipendente WHERE matricola IN (SELECT f_matricola FROM ferie WHERE data_inizio_ferie IS NOT NULL AND data_inizio_ferie>'"
                    + dataDiOggi + "');";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricola = rs.getString("matricola");
                nome = rs.getString("nome");
                cognome = rs.getString("cognome");
                email = rs.getString("email");
                tipologia = rs.getString("tipologia");
                list.add(new Dipendente(matricola, nome, cognome, email, tipologia));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public String prendiDataFerie(String matricolaImpiegato, String inizioFine) {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data_" + inizioFine + "_ferie FROM ferie WHERE f_matricola='" + matricolaImpiegato
                    + "'";
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getString("data_" + inizioFine + "_ferie");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void caricaFerie(String matricola, String data) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data
                    + "', 'ferie', '" + matricola + "', '-', '-', " + false
                    + ", " + false + ", " + false + ");";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminaRichiestaFerie(String matricola) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "DELETE FROM ferie WHERE f_matricola='" + matricola + "'";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int prendiImpiegatiQuelGiorno(String data, String tipologia) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "select count(distinct matricola) from dipendente, turno where matricola=t_matricola and descrizione!='ferie' AND descrizione!='libero' and data='"
                    + data + "' and tipologia='" + tipologia + "'";

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("count(DISTINCT matricola)");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean controllaFirmaQuery() {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();

        DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataDiOggi = data.format(date);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");
            String oraInizio = prediOraInizioQuery();
            String oraFine = prediOraFineQuery();
            if (oraInizio == null || oraFine == null) {
                return false;
            }
            String sql = "SELECT presenza FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                    + " AND data='" + dataDiOggi + "' AND ora_inizio='" + oraInizio + "' AND ora_fine='"
                    + oraFine + "';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("presenza").equals("1")) {
                    return false;
                }

            }
            return true;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean aggiornaPresenzaQuery() {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();

        DateFormat data2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataDiOggi = data2.format(date);

        DateFormat ora = new SimpleDateFormat("HH");
        Date ora2 = new Date();
        String oraDiOggi = ora.format(ora2);
        int oraInteger = Integer.parseInt(oraDiOggi);

        boolean isModificato = false;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");
            String sql = "";
            if (oraInteger >= 5 && oraInteger < 15) {
                sql = "UPDATE turno SET presenza=" + true + ", firma_ingresso= " + true + " WHERE (t_matricola="
                        + accountControl.returnMatricola()
                        + ") AND (data='" + dataDiOggi + "') AND (descrizione='mattina');";
                isModificato = true;
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            } else if (oraInteger >= 15 && oraInteger < 22) {
                sql = "UPDATE turno SET presenza=" + true + ", firma_ingresso= " + true + " WHERE (t_matricola="
                        + accountControl.returnMatricola()
                        + ") AND (data='" + dataDiOggi + "') AND (descrizione='pomeriggio');";
                isModificato = true;
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            } else if (oraInteger >= 22 || oraInteger < 5) {
                sql = "UPDATE turno SET presenza=" + true + ", firma_ingresso=" + true + " WHERE (t_matricola="
                        + accountControl.returnMatricola()
                        + ") AND (data='" + dataDiOggi + "') AND (descrizione='notte');";
                isModificato = true;
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }

            System.out.println("Inserting record into the table...");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isModificato;
    }

    public String prediOraFineQuery() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

        Statement stmt = conn.createStatement();

        AccountControl accountControl = new AccountControl();

        DateFormat data2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataDiOggi = data2.format(date);

        DateFormat ora = new SimpleDateFormat("HH");
        Date ora2 = new Date();
        String oraDiOggi = ora.format(ora2);
        int oraInteger = Integer.parseInt(oraDiOggi);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");
            String sql = "";
            if (oraInteger >= 5 && oraInteger < 15) {
                sql = "SELECT ora_fine FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                        + " AND data ='" + dataDiOggi + "' AND descrizione='mattina';";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    String oraFine = rs.getString("ora_fine");
                    return oraFine;
                }
            } else if (oraInteger >= 15 && oraInteger < 22) {
                sql = "SELECT ora_fine FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                        + " AND data ='" + dataDiOggi + "' AND descrizione='pomeriggio';";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    String oraFine = rs.getString("ora_fine");
                    return oraFine;
                }
            } else if (oraInteger >= 22) {
                sql = "SELECT ora_fine FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                        + " AND data ='" + dataDiOggi + "' AND descrizione='notte';";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    String oraFine = rs.getString("ora_fine");
                    return oraFine;
                }
            }

            System.out.println("Inserting record into the table...");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String prediOraInizioQuery() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

        Statement stmt = conn.createStatement();

        AccountControl accountControl = new AccountControl();

        DateFormat data2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataDiOggi = data2.format(date);

        DateFormat ora = new SimpleDateFormat("HH");
        Date ora2 = new Date();
        String oraDiOggi = ora.format(ora2);
        int oraInteger = Integer.parseInt(oraDiOggi);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            String sql = "";
            if (oraInteger >= 5 && oraInteger < 15) {
                sql = "SELECT ora_inizio FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                        + " AND data ='" + dataDiOggi + "' AND descrizione='mattina';";
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    String oraInizio = rs.getString("ora_inizio");
                    return oraInizio;
                }
            } else if (oraInteger >= 15 && oraInteger < 22) {
                sql = "SELECT ora_inizio FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                        + " AND data ='" + dataDiOggi + "' AND descrizione='pomeriggio';";
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    String oraInizio = rs.getString("ora_inizio");
                    return oraInizio;
                }
            } else if (oraInteger >= 22) {
                sql = "SELECT ora_inizio FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                        + " AND data ='" + dataDiOggi + "' AND descrizione='notte';";
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    String oraInizio = rs.getString("ora_inizio");
                    return oraInizio;
                }

            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean controllaTurnoQuery(String data) {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();
        HashMap<String, String> turni = new HashMap<>();
        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data, descrizione FROM turno WHERE t_matricola=" + accountControl.returnMatricola();

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dataDB = rs.getString("data");
                String descrizione = rs.getString("descrizione");
                turni.put(dataDB, descrizione);
            }
            for (HashMap.Entry<String, String> entry : turni.entrySet()) {
                if (entry.getKey().equals(data) && !entry.getValue().equals("libero")) {
                    return true;
                }
            }
            return false;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean controllaTurnoEOraQuery(String data, String oraInizio, String oraFine) {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data, ora_inizio, ora_fine FROM turno WHERE t_matricola="
                    + accountControl.returnMatricola();

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dataDB = rs.getString("data");
                String oraInizioDB = rs.getString("ora_inizio");
                String oraFineDB = rs.getString("ora_fine");
                if (dataDB.equals(data) && oraInizioDB.substring(0, 5).equals(oraInizio)
                        && oraFineDB.substring(0, 5).equals(oraFine)) {
                    return true;
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String prendiOraQuery(String data) {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT ora_inizio FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                    + " AND data='" + data + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            String oraInizio = "";
            if (rs.next()) {
                oraInizio = rs.getString("ora_inizio");
            }
            return oraInizio;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean inserisciPermessoGiornoInteroQuery(String data, String motivazione) {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO permesso (p_matricola, data_p, ora_inizio_turno, ora_fine_turno, motivazione) VALUES ("
                    + accountControl.returnMatricola() + ", '" + data + "', '-', '-', '" + motivazione + "');";

            System.out.println("Inserting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            return true;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean inserisciPermessoOreQuery(String data, String oraInizio, String oraFine, String motivazione) {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO permesso (p_matricola, data_p, ora_inizio_turno, ora_fine_turno, motivazione) VALUES ("
                    + accountControl.returnMatricola() + ", '" + data + "', '" + oraInizio + "', '" + oraFine
                    + "', '" + motivazione + "');";

            System.out.println("Inserting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            return true;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean controllaOrariQuery(String data, String orario) {
        Statement stmt = null;
        Connection conn = null;

        String oraInizio = orario.substring(0, 5) + ":00";
        String oraFine = orario.substring(6, 11) + ":00";

        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT ora_inizio, ora_fine FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                    + " AND data='" + data + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String oraInizioDB = rs.getString("ora_inizio");
                String oraFineDB = rs.getString("ora_fine");
                if (oraInizioDB.equals(oraInizio) && oraFineDB.equals(oraFine)) {
                    return true;
                }
            }

            return false;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public Dipendente prendiAltroImpiegatoQuery(String ruolo, String nomeECognome, String nome, String cognome) {
        Statement stmt = null;
        Connection conn = null;

        String[] nomeECognomeArray = nomeECognome.split(" ");
        String nomeImpiegato = nomeECognomeArray[0];
        String cognomeImpiegato = nomeECognomeArray[1];

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT matricola, nome, cognome, email, tipologia FROM dipendente WHERE tipologia!='Amministratore' AND tipologia<='"
                    + ruolo + "'AND nome!='" + nomeImpiegato + "' AND cognome!='" + cognomeImpiegato
                    + "' AND nome!='" + nome + "' AND cognome!='" + cognome
                    + "' AND matricola not in (select f_matricola from ferie) ORDER BY RAND() LIMIT 1;";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String matricola = rs.getString("matricola");
                String nome2 = rs.getString("nome");
                String cognome2 = rs.getString("cognome");
                String email = rs.getString("email");
                String tipologia = rs.getString("tipologia");
                return new Dipendente(matricola, nome2, cognome2, email, tipologia);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void assegneStraordinarioPomeriggioQuery(String ora_inizio_turno_pomeriggio,
            String ora_fine_turno_pomeriggio,
            String data, String matricola, String matricolaImpiegatoPermesso, String ruoloImpiegatoPermesso) {
        Statement stmt = null;
        Connection conn = null;

        int ora_inizio = Integer.parseInt(ora_inizio_turno_pomeriggio.substring(0, 2));
        int ora_fine = Integer.parseInt(ora_fine_turno_pomeriggio.substring(0, 2));
        int ore_straordinario = ora_fine - ora_inizio;
        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql1 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data + "', 'pomeriggio', '" + matricola + "', '" + ora_inizio_turno_pomeriggio
                    + "', '"
                    + ora_fine_turno_pomeriggio + "', " + false + ", " + false + ", " + false + ");";

            DateFormat anno = new SimpleDateFormat("yyyy");
            Date anno2 = new Date();
            String dataDiOggiAnno = anno.format(anno2);

            DateFormat mese = new SimpleDateFormat("MM");
            Date mese2 = new Date();
            String dataDiOggimese = mese.format(mese2);

            if (ruoloImpiegatoPermesso.equals("Amministratore") || ruoloImpiegatoPermesso.equals("Impiegato A")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_1 = ore_straordinario_1 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);
            } else if (ruoloImpiegatoPermesso.equals("Impiegato B")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_2 = ore_straordinario_2 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);
            } else if (ruoloImpiegatoPermesso.equals("Impiegato C")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_3 = ore_straordinario_3 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);
            } else if (ruoloImpiegatoPermesso.equals("Impiegato D")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_3 = ore_straordinario_3 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);
            }

            String sql3 = "DELETE FROM turno WHERE t_matricola='" + matricolaImpiegatoPermesso + "' AND data='"
                    + data + "' AND descrizione='pomeriggio';";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql3);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void assegnaStraordinarioMattinaQuery(String ora_inizio_turno_mattina, String ora_fine_turno_mattina,
            String data, String matricola, String matricolaImpiegatoPermesso, String ruoloImpiegatoPermesso) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql1 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data + "', 'mattina', '" + matricola + "', '" + ora_inizio_turno_mattina
                    + "', '"
                    + ora_fine_turno_mattina + "', " + false + ", " + false + ", " + false + ");";

            int ora_inizio = Integer.parseInt(ora_inizio_turno_mattina.substring(0, 2));
            int ora_fine = Integer.parseInt(ora_fine_turno_mattina.substring(0, 2));
            int ore_straordinario = ora_fine - ora_inizio;

            DateFormat anno = new SimpleDateFormat("yyyy");
            Date anno2 = new Date();
            String dataDiOggiAnno = anno.format(anno2);

            DateFormat mese = new SimpleDateFormat("MM");
            Date mese2 = new Date();
            String dataDiOggimese = mese.format(mese2);

            if (ruoloImpiegatoPermesso.equals("Amministratore") || ruoloImpiegatoPermesso.equals("Impiegato A")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_1 = ore_straordinario_1 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);

            } else if (ruoloImpiegatoPermesso.equals("Impiegato B")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_2 = ore_straordinario_2 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);
            } else if (ruoloImpiegatoPermesso.equals("Impiegato C")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_3 = ore_straordinario_4 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);
            } else if (ruoloImpiegatoPermesso.equals("Impiegato D")) {
                String sql2 = "UPDATE stipendio SET ore_straordinario_4 = ore_straordinario_4 + " + ore_straordinario
                        + " where s_matricola='" + matricola + "' AND anno_s='" + dataDiOggiAnno + "' AND mese_s='"
                        + dataDiOggimese + "';";
                stmt = conn.createStatement();

                stmt.executeUpdate(sql2);
            }

            String sql3 = "DELETE FROM turno WHERE t_matricola='" + matricolaImpiegatoPermesso + "' AND data='"
                    + data + "' AND descrizione='mattina';";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql3);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String prendiGiornoLiberoQuery(String matricola, String data_p) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql1 = "select data from turno where data>'" + data_p
                    + "' AND descrizione='libero' AND t_matricola='"
                    + matricola + "';";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql1);

            if (rs.next()) {
                String data = rs.getString("data");
                return data;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void aggiornaOrari2Query(String matricolaImpiegatoSelezionato, String data,
            String ora_inizio_turno_mattina, String ora_fine_turno_mattina, String ora_inizio_turno_pomeriggio,
            String ora_fine_turno_pomeriggio) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql1 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data + "', 'mattina', '" + matricolaImpiegatoSelezionato + "', '" + ora_inizio_turno_mattina
                    + "', '"
                    + ora_fine_turno_mattina + "', " + false + ", " + false + ", " + false + ");";

            String sql3 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data + "', 'pomeriggio', '" + matricolaImpiegatoSelezionato + "', '" + ora_inizio_turno_pomeriggio
                    + "', '"
                    + ora_fine_turno_pomeriggio + "', " + false + ", " + false + ", " + false + ");";

            String sql2 = "DELETE FROM turno WHERE t_matricola='" + matricolaImpiegatoSelezionato + "' AND data='"
                    + data + "';";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql3);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void aggiornaOrariQuery(String matricolaImpiegatoSelezionato, String data,
            String ora_inizio_turno_mattina, String ora_fine_turno_mattina, String ora_inizio_turno_pomeriggio,
            String ora_fine_turno_pomeriggio) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql1 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data + "', 'mattina', '" + matricolaImpiegatoSelezionato + "', '" + ora_inizio_turno_mattina
                    + "', '"
                    + ora_fine_turno_mattina + "', " + false + ", " + false + ", " + false + ");";

            String sql3 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + data + "', 'pomeriggio', '" + matricolaImpiegatoSelezionato + "', '" + ora_inizio_turno_pomeriggio
                    + "', '"
                    + ora_fine_turno_pomeriggio + "', " + false + ", " + false + ", " + false + ");";

            String sql2 = "DELETE FROM turno WHERE t_matricola='" + matricolaImpiegatoSelezionato + "' AND data='"
                    + data + "' AND descrizione='libero'";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql3);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean controllaNotteQuery(String data_p, int p_matricola) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT descrizione FROM turno WHERE data='" + data_p + "' AND t_matricola=" + p_matricola
                    + ";";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("descrizione").equals("notte")) {
                    return true;
                }
            }
            return false;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String getRuoloQuery(String matricolaString) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT tipologia FROM dipendente WHERE matricola='" + matricolaString + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String ruolo = rs.getString("tipologia");
                return ruolo;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void assegnaTurniNuoviQuery(String ora_inizio_turno_mattina, String ora_fine_turno_mattina,
            String ora_inizio_turno_pomeriggio, String ora_fine_turno_pomeriggio, String dataNotte, String matricola) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql1 = "DELETE FROM turno WHERE data='" + dataNotte + "' AND t_matricola='" + matricola + "';";

            String sql2 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + dataNotte + "', 'mattina', '" + matricola + "', '" + ora_inizio_turno_mattina + "', '"
                    + ora_fine_turno_mattina + "', " + false + ", " + false + ", " + false + ");";

            String sql3 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + dataNotte + "', 'pomeriggio', '" + matricola + "', '" + ora_inizio_turno_pomeriggio + "', '"
                    + ora_fine_turno_pomeriggio + "', " + false + ", " + false + ", " + false + ");";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String prendiGiornoNotteQuery(String matricola, String data_p) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql1 = "select data from turno where data>'" + data_p + "' AND descrizione='notte' AND t_matricola='"
                    + matricola + "';";

            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql1);

            if (rs.next()) {
                String data = rs.getString("data");
                return data;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void aggiornaTurnoNotteImpiegatoSelezionatoQuery(String matricola, String data_p) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            if (controllaGiornoLiberoQuery(data_p, matricola) == null
                    || controllaGiornoLiberoQuery(data_p, matricola).equals("libero")) {
                String sql2 = "DELETE FROM turno WHERE data='" + data_p + "' AND t_matricola=" + matricola
                        + ";";
                String sql1 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                        + data_p + "', 'notte', '" + matricola + "', '22:00:00', '06:00:00', " + false + ", " + false
                        + ", " + false + ");";

                stmt = conn.createStatement();
                stmt.executeUpdate(sql2);
                stmt.executeUpdate(sql1);
            } else {
                String sql1 = "UPDATE turno SET ora_inizio='22:00:00', ora_fine='06:00:00', descrizione='notte' WHERE t_matricola='"
                        + matricola
                        + "' AND data='" + data_p + "';";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql1);
            }

            String giorno = data_p.substring(8, 10);
            int giornoInt = Integer.parseInt(giorno);
            int giornoSuccessivo = giornoInt + 1;
            String stringGiornoSuccessivo = Integer.toString(giornoSuccessivo);
            String dataSuccessiva = data_p.replace(giorno, stringGiornoSuccessivo);

            if (dataSuccessiva.equals("2023-01-32")) {
                dataSuccessiva = "2023-02-01";
            } else if (dataSuccessiva.equals("2023-02-28")) {
                dataSuccessiva = "2023-03-01";
            } else if (dataSuccessiva.equals("2023-03-32")) {
                dataSuccessiva = "2023-04-01";
            } else if (dataSuccessiva.equals("2023-04-31")) {
                dataSuccessiva = "2023-05-01";
            } else if (dataSuccessiva.equals("2023-05-32")) {
                dataSuccessiva = "2023-06-01";
            } else if (dataSuccessiva.equals("2023-06-31")) {
                dataSuccessiva = "2023-07-01";
            } else if (dataSuccessiva.equals("2023-07-32")) {
                dataSuccessiva = "2023-08-01";
            } else if (dataSuccessiva.equals("2023-08-32")) {
                dataSuccessiva = "2023-09-01";
            } else if (dataSuccessiva.equals("2023-09-31")) {
                dataSuccessiva = "2023-10-01";
            } else if (dataSuccessiva.equals("2023-10-32")) {
                dataSuccessiva = "2023-11-01";
            } else if (dataSuccessiva.equals("2023-11-31")) {
                dataSuccessiva = "2023-12-01";
            } else if (dataSuccessiva.equals("2023-12-31")) {
                dataSuccessiva = "2023-01-01";
            }

            String sql2 = "DELETE FROM turno WHERE data='" + dataSuccessiva + "' AND t_matricola=" + matricola + ";";
            String sql3 = "INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine, presenza, firma_ingresso, firma_uscita) VALUES ('"
                    + dataSuccessiva + "', 'libero', '" + matricola + "', '00:00:00', '00:00:00', " + false + ", "
                    + false
                    + ", " + false + ");";
            System.out.println("Updating record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String controllaGiornoLiberoQuery(String data_p, String matricola) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT descrizione FROM turno WHERE data='" + data_p + "' AND t_matricola='" + matricola
                    + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                if (rs.getString("descrizione").equals("libero") || rs.getString("descrizione") == null) {
                    return "libero";
                }
            } else {
                return null;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String prendiOraFineQuery(String matricola, String descrizione) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT ora_fine FROM turno WHERE t_matricola='" + matricola + "' AND descrizione='"
                    + descrizione + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String ora_fine = rs.getString("ora_fine");
                return ora_fine;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String prendiOraInizioQuery(String matricola, String descrizione) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT ora_inizio FROM turno WHERE t_matricola='" + matricola + "' AND descrizione='"
                    + descrizione + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String ora_inizio = rs.getString("ora_inizio");
                return ora_inizio;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Dipendente prendiImpiegatoQuery(String ruolo, String nomeECognome) {
        Statement stmt = null;
        Connection conn = null;

        String[] nomeECognomeArray = nomeECognome.split(" ");
        String nomeImpiegato = nomeECognomeArray[0];
        String cognomeImpiegato = nomeECognomeArray[1];

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT matricola, nome, cognome, email, tipologia FROM dipendente WHERE tipologia!='Amministratore' AND tipologia<='"
                    + ruolo + "'AND nome!='" + nomeImpiegato + "' AND cognome!='" + cognomeImpiegato
                    + "' AND matricola not in (select f_matricola from ferie) ORDER BY RAND() LIMIT 1;";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String matricola = rs.getString("matricola");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String email = rs.getString("email");
                String tipologia = rs.getString("tipologia");
                return new Dipendente(matricola, nome, cognome, email, tipologia);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Dipendente prendiAmministratoreQuery(String matricola, String nomeECognome) {
        Statement stmt = null;
        Connection conn = null;

        String[] nomeECognomeArray = nomeECognome.split(" ");
        String nomeImpiegato = nomeECognomeArray[0];
        String cognomeImpiegato = nomeECognomeArray[1];

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT matricola, nome, cognome, email, tipologia FROM dipendente WHERE tipologia='Amministratore' AND nome!='"
                    + nomeImpiegato + "' AND cognome!='" + cognomeImpiegato
                    + "' AND matricola not in (select f_matricola from ferie) ORDER BY RAND() LIMIT 1;";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String matricolaAmministratore = rs.getString("matricola");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String email = rs.getString("email");
                String tipologia = rs.getString("tipologia");
                return new Dipendente(matricolaAmministratore, nome, cognome, email, tipologia);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Dipendente prendiAltroAmministratoreQuery(String ruolo, String nomeECognome, String nome, String cognome) {
        Statement stmt = null;
        Connection conn = null;

        String[] nomeECognomeArray = nomeECognome.split(" ");
        String nomeImpiegato = nomeECognomeArray[0];
        String cognomeImpiegato = nomeECognomeArray[1];

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT matricola, nome, cognome, email, tipologia FROM dipendente WHERE tipologia='Amministratore' AND nome!='"
                    + nomeImpiegato + "' AND cognome!='" + cognomeImpiegato
                    + "' AND nome!='" + nome + "' AND cognome!='" + cognome
                    + "' AND matricola not in (select f_matricola from ferie) ORDER BY RAND() LIMIT 1;";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String matricola = rs.getString("matricola");
                String nome2 = rs.getString("nome");
                String cognome2 = rs.getString("cognome");
                String email = rs.getString("email");
                String tipologia = rs.getString("tipologia");
                return new Dipendente(matricola, nome2, cognome2, email, tipologia);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean controllaPeriodoRosso(LocalDate date1, LocalDate date2) {
        String dataInizioRosso = prendiDataInizioRossoQuery();
        if (dataInizioRosso == null) {
            return false;
        }
        String dataFineRosso = prendiDataFineRossoQuery();

        LocalDate localDateInizioRosso = LocalDate.parse(dataInizioRosso);
        LocalDate localDateFineRosso = LocalDate.parse(dataFineRosso);

        if (date2.isEqual(localDateInizioRosso) || date1.isEqual(localDateFineRosso)
                || (date1.isBefore(localDateInizioRosso) && date2.isAfter(localDateInizioRosso))
                || ((date1.isBefore(localDateFineRosso) && date1.isAfter(localDateInizioRosso))
                        || date1.isEqual(localDateInizioRosso))
                || (date2.isBefore(localDateFineRosso) || date2.isEqual(localDateFineRosso))
                        && (date1.isAfter(localDateInizioRosso) || date1.isEqual(localDateInizioRosso))) {
            return true;
        }
        return false;
    }

    public String prendiDataFineRossoQuery() {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data_fine_periodo_rosso FROM ferie WHERE data_fine_periodo_rosso IS NOT null";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getString("data_fine_periodo_rosso");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String prendiDataInizioRossoQuery() {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data_inizio_periodo_rosso FROM ferie WHERE data_inizio_periodo_rosso IS NOT null";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getString("data_inizio_periodo_rosso");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean controllaDateFerie(LocalDate date) {
        String dataFineTurnazione = prendiDataFineTurnazione();

        LocalDate localDateFineTurnazione = LocalDate.parse(dataFineTurnazione);

        if (date.isAfter(localDateFineTurnazione)) {
            return false;
        }
        return true;
    }

    private String prendiDataFineTurnazione() {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data FROM turno ORDER BY data DESC";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getString("data");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void registraFerie(String date1, String date2) {
        Statement stmt = null;
        Connection conn = null;
        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO ferie (data_inizio_ferie, data_fine_ferie, f_matricola, data_inizio_periodo_rosso, data_fine_periodo_rosso) VALUES ('"
                    + date1 + "', '" + date2 + "', '" + accountControl.returnMatricola() + "', null, null);";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void registraPeriodoRosso(String data1, String data2) {
        Statement stmt = null;
        Connection conn = null;
        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "INSERT INTO ferie (data_inizio_ferie, data_fine_ferie, f_matricola, data_inizio_periodo_rosso, data_fine_periodo_rosso) VALUES (null, null, "
                    + " '" + accountControl.returnMatricola() + "', '" + data1 + "', '" + data2 + "');";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*public boolean controllaPeriodoDateRosso(LocalDate localDate, LocalDate localDate2) {
        String dataInizioPeriodoRosso = prendiDataInizioRossoQuery();

        if (dataInizioPeriodoRosso == null) {
            return true;
        }
        return false;
    }*/

    public void eliminaPeriodoRossoVecchio() {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "DELETE FROM ferie WHERE data_inizio_periodo_rosso IS NOT NULL;";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int prendiIdFerie(LocalDate localDateInizioPeriodoRosso, LocalDate localDateFinePeriodoRosso) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT id_ferie FROM ferie WHERE data_inizio_periodo_rosso='"
                    + localDateInizioPeriodoRosso.toString()
                    + "' AND data_fine_periodo_rosso='" + localDateFinePeriodoRosso.toString() + "' ;";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("id_ferie");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean verificaTurnoQuery(String data) {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT id_turno FROM turno WHERE data='" + data + "' AND t_matricola="
                    + accountControl.returnMatricola() + ";";

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int id_turno = 0;

            while (rs.next()) {
                id_turno = rs.getInt("id_turno");
            }
            if (id_turno == 0) {
                return false;
            } else {
                return true;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public ObservableList<Permesso> setNotificheQuery() {
        Statement stmt = null;
        Connection conn = null;

        ObservableList<Permesso> listPermessi = FXCollections.observableArrayList();

        int matricola = 0;
        int id_permesso = 0;
        String data_p = "";
        String ora_inizio_turno = "";
        String ora_fine_turno = "";
        String motivazione = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT id_permesso, p_matricola, data_p, ora_inizio_turno, ora_fine_turno, motivazione FROM permesso";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                matricola = rs.getInt("p_matricola");
                String nomeECognome = getNomeDipendenteQuery(matricola);
                id_permesso = rs.getInt("id_permesso");
                data_p = rs.getString("data_p");
                ora_inizio_turno = rs.getString("ora_inizio_turno");
                ora_fine_turno = rs.getString("ora_fine_turno");
                motivazione = rs.getString("motivazione");
                listPermessi.add(new Permesso(id_permesso, matricola, data_p, ora_inizio_turno, ora_fine_turno,
                        motivazione, nomeECognome));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listPermessi;
    }

    public String getNomeDipendenteQuery(int matricola) {
        Statement stmt = null;
        Connection conn = null;

        String nome = "";
        String cognome = "";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT nome, cognome FROM dipendente WHERE matricola=" + matricola + ";";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                nome = rs.getString("nome");
                cognome = rs.getString("cognome");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nome + " " + cognome;
    }

    public void eliminaRichiestaQuery(ObservableList<Permesso> permessoSelezionato) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "DELETE FROM permesso WHERE id_permesso=" + permessoSelezionato.get(0).getId_permesso() + ";";

            System.out.println("Deleting record into the table...");

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getOrari() {
        Statement stmt = null;
        Connection conn = null;

        AccountControl accountControl = new AccountControl();
        DateFormat giorno = new SimpleDateFormat("yyyy-MM-dd");
        Date giorno2 = new Date();
        String dataDiOggiGiorno = giorno.format(giorno2);

        List<String> orari = new ArrayList<>();

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT ora_inizio, ora_fine FROM turno WHERE t_matricola=" + accountControl.returnMatricola()
                    + " AND  data='" + dataDiOggiGiorno + "';";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            String oraInizio = "";
            String oraFine = "";

            while (rs.next()) {
                oraInizio = rs.getString("ora_inizio");
                oraFine = rs.getString("ora_fine");
                orari.add(oraInizio);
                orari.add(oraFine);
            }
            return orari;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "ERRORE COMUNICAZIONE CON IL DBMS",
                    ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-size: 16px;" + "-fx-font-weight: bold;");
            dialogPane.getStyleClass().remove("alert");
            GridPane grid = (GridPane) dialogPane.lookup("*.header-panel");
            grid.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                alert.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}