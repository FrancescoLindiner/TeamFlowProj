package com.tf.teamflowcode.GestioneAccount.GestioneAccountControl;

import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class RecuperoControl {

    BoundaryDBMS boundaryGestioneAccount = new BoundaryDBMS();

    public boolean controllaEmail(String email) {
        return boundaryGestioneAccount.controllaEmailQuery(email);
    }
}