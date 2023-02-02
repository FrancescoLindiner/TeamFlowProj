package com.tf.teamflowcode.GestioneAccount.GestioneAccountControl;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class AccountControl {
    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String emailDB = "";
    private String passowrdDB = "";
    static Dipendente dipendente;

    BoundaryDBMS boundaryGestioneAccount = new BoundaryDBMS();

    public void setEmailDB(String emailDB) {
        this.emailDB = emailDB;
    }

    public void setPassowrdDB(String passowrdDB) {
        this.passowrdDB = passowrdDB;
    }

    public String getEmailDB() {
        return emailDB;
    }

    public String getPassowrdDB() {
        return passowrdDB;
    }

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
            dipendente = getInformazioniDipendente(this.emailDB, this.passowrdDB);
            return true;
        } else {
            return false;
        }
    }

    public boolean impiegatiAttivi(String tipologia, int percentuale) {
        Statement stmt = null;
        Connection conn = null;

        DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataDiOggi = data.format(date);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT count(DISTINCT t_matricola) FROM turno t, dipendente d WHERE d.matricola=t.t_matricola and tipologia='"
                    + tipologia + "' and data='"
                    + dataDiOggi + "' and descrizione!='libero' and descrizione!='ferie';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);
            int numImpiegatoServizio = prendiImpiegati(tipologia);
            if (rs.next()) {
                if (rs.getInt("count(DISTINCT t_matricola)") >= (percentuale * numImpiegatoServizio) / 100) {
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
        return false;
    }

    public int impiegatiAttiviParziali(String tipologia) {
        Statement stmt = null;
        Connection conn = null;

        DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataDiOggi = data.format(date);

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT count(DISTINCT t_matricola) FROM turno t, dipendente d WHERE d.matricola=t.t_matricola and tipologia='"
                    + tipologia + "' and data='"
                    + dataDiOggi + "' and descrizione!='libero';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("count(DISTINCT t_matricola)");
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

    public int prendiImpiegati(String string) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT count(matricola) FROM dipendente WHERE tipologia='" + string + "';";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("count(matricola)");
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

    public String returnRuolo() {
        return dipendente.getTipologia();
    }

    public String returnNome() {
        return dipendente.getNome();
    }

    public String returnMatricola() {
        return dipendente.getMatricola();
    }

    public String returnCognome() {
        return dipendente.getCognome();
    }

    public Dipendente getInformazioniDipendente(String email, String password) {
        return boundaryGestioneAccount.getInformazioniDipendenteQuery(email, password);
    }

}