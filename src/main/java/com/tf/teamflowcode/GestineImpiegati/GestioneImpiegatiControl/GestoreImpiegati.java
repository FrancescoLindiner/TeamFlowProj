package com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiControl;

import javafx.collections.ObservableList;
import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.GestineImpiegati.GestioneImpiegatiInterface.InterfacciaVisualizzaImpiegati;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class GestoreImpiegati {

    final String DRIVER = "com.mysql.cj.jdbc.Driver";

    InterfacciaVisualizzaImpiegati ricercaImpiegati = new InterfacciaVisualizzaImpiegati();
    BoundaryDBMS boundaryGestioneImpiegati = new BoundaryDBMS();

    public void cercaImpiegato(String nome, String cognome, String matricola) {
        boundaryGestioneImpiegati.cercaImpiegatoQuery(nome, cognome, matricola);
    }

    public void cercaImpiegatoPerCognomeEMatricola(String cognome, String matricola) {
        boundaryGestioneImpiegati.cercaImpiegatoPerCognomeEMatricolaQuery(cognome, matricola);        
    }

    public void cercaImpiegatoPerNomeEMatricola(String nome, String matricola) {
        boundaryGestioneImpiegati.cercaImpiegatoPerNomeEMatricolaQuery(nome, matricola);
    }

    public void cercaImpiegatoPerNomeECognome(String nome, String cognome) {
        boundaryGestioneImpiegati.cercaImpiegatoPerNomeECognomeQuery(nome, cognome);
    }

    public void cercaImpiegatoPerMatricola(String matricola) {
        boundaryGestioneImpiegati.cercaImpiegatoPerMatricolaQuery(matricola);        
    }

    public void cercaImpiegatoPerNome(String nome) {
        boundaryGestioneImpiegati.cercaImpiegatoPerNomeQuery(nome);
    }

    public void cercaImpiegatoPerCognome(String cognome) {
        boundaryGestioneImpiegati.cercaImpiegatoPerCognomeQuery(cognome);
    }

    public void modificaImpiegatoEmail(ObservableList<Dipendente> impiegato, String email) {
        boundaryGestioneImpiegati.modificaImpiegatoEmailQuery(impiegato, email);
    }

    public void modificaImpiegatoGrado(ObservableList<Dipendente> impiegato, String grado) {
        boundaryGestioneImpiegati.modificaImpiegatoGradoQuery(impiegato, grado);
    }

    public void modificaImpiegato(ObservableList<Dipendente> impiegato, String grado, String email) {
        boundaryGestioneImpiegati.modificaImpiegatoQuery(impiegato, grado, email);
    }

    public void rimuoviImpiegato(ObservableList<Dipendente> impiegato) {
        boundaryGestioneImpiegati.rimuoviImpiegatoQuery(impiegato);
    }
}