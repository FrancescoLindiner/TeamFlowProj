package com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import com.tf.teamflowcode.Entity.Dipendente;

public class ControlFirma {

    public boolean controllaFirme(String matricola) {
        Statement stmt = null;
        Connection conn = null;

        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT firma_uscita FROM turno WHERE descrizione!='ferie' AND descrizione!='libero' AND data='"
                    + getDataBefore() + "'";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            boolean isFirma = false;
            while (rs.next()) {
                if (rs.getString("firma_uscita").equals(1)) {
                    isFirma = true;
                } else {
                    isFirma = false;
                }
            }
            return isFirma;
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

    private String getDataBefore() {
        String s;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        s = formatter.format(date);
        return s;
    }

    public List<Dipendente> returnList() {
        Statement stmt = null;
        Connection conn = null;

        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT matricola, nome, cognome, email, tipologia FROM dipendente";

            System.out.println("Selecting record into the table...");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Dipendente> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new Dipendente(rs.getString("matricola"), rs.getString("nome"), rs.getString("cognome"),
                        rs.getString("email"),
                        rs.getString("tipologia")));
            }
            return list;
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
}