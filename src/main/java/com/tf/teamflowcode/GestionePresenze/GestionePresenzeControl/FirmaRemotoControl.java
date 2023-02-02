package com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl;

import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class FirmaRemotoControl {

    BoundaryDBMS boundaryGestionePresenze = new BoundaryDBMS();
    
    public boolean controllaFirma() {
        return boundaryGestionePresenze.controllaFirmaQuery();
    }

    public boolean aggiornaPresenza() {
        return boundaryGestionePresenze.aggiornaPresenzaQuery();
    }

}