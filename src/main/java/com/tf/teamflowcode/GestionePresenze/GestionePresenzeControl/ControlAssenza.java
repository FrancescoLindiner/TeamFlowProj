package com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl;

import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class ControlAssenza {

    BoundaryDBMS boundaryPannelli = new BoundaryDBMS();

    public boolean verificaTurno(String data) {
        return boundaryPannelli.verificaTurnoQuery(data);
    }

}