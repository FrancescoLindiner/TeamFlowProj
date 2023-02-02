package com.tf.teamflowcode.GestioneOrariEStipendi.GestioneOrariEStipendiControl;

import javafx.collections.ObservableList;
import com.tf.teamflowcode.Entity.Turno;
import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class GestioneTurniControl {

    AccountControl accountControl = new AccountControl();
    BoundaryDBMS boundaryGestioneOrariEStipendi = new BoundaryDBMS();

    public ObservableList<Turno>  prendiTurni() {
        return boundaryGestioneOrariEStipendi.prendiTurniQuery();
    }
}