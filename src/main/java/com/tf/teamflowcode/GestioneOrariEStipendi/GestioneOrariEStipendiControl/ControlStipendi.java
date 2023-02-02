package com.tf.teamflowcode.GestioneOrariEStipendi.GestioneOrariEStipendiControl;

import java.util.List;

import javafx.collections.ObservableList;
import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class ControlStipendi {

    AccountControl accountControl = new AccountControl();
    BoundaryDBMS boundaryGestioneOrariEStipendi = new BoundaryDBMS();

    String matricola = accountControl.returnMatricola();

    public List<String> getStipendio(String matricola) {
        return boundaryGestioneOrariEStipendi.getStipendioQuery(matricola);
    }

    public ObservableList<String> returnListaStipendi() {
        return boundaryGestioneOrariEStipendi.returnListaStipendiQuery();
    }

    public void generaStipendi() {
        List<Dipendente> listaDipendenti = returnListaDipendenti();

        for (Dipendente dipendente : listaDipendenti) {
            int presenze = boundaryGestioneOrariEStipendi.prendiPresenzeQuery(dipendente.getMatricola());
            int oreStraordinario1 = boundaryGestioneOrariEStipendi.prediOreStraordinarioQuery(dipendente.getMatricola(),
                    1);
            int oreStraordinario2 = boundaryGestioneOrariEStipendi.prediOreStraordinarioQuery(dipendente.getMatricola(),
                    2);
            int oreStraordinario3 = boundaryGestioneOrariEStipendi.prediOreStraordinarioQuery(dipendente.getMatricola(),
                    3);
            int oreStraordinario4 = boundaryGestioneOrariEStipendi.prediOreStraordinarioQuery(dipendente.getMatricola(),
                    4);

            aggiornaStipendio(dipendente.getTipologia(), presenze, oreStraordinario1, oreStraordinario2,
                    oreStraordinario3, oreStraordinario4, dipendente.getMatricola());
        }
    }

    private void aggiornaStipendio(String tipologia, int presenze, int oreStraordinario1, int oreStraordinario2,
            int oreStraordinario3, int oreStraordinario4, String matricola) {
        boundaryGestioneOrariEStipendi.aggiornaStipendioQuery(tipologia, presenze, oreStraordinario1, oreStraordinario2,
                oreStraordinario3, oreStraordinario4, matricola);
    }

    private List<Dipendente> returnListaDipendenti() {
        return boundaryGestioneOrariEStipendi.returnListaDipendentiQuery();
    }

    public boolean isGenerati() {
        return boundaryGestioneOrariEStipendi.queryIsGenerati();
    }
}