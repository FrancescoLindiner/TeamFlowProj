package com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class RichiediPermessoControl {

    BoundaryDBMS boundaryGestionePresenze = new BoundaryDBMS();

    public boolean controllaTurno(String data) {
        return boundaryGestionePresenze.controllaTurnoQuery(data);
    }

    public boolean controllaTurnoEOra(String data, String oraInizio, String oraFine) {
        return boundaryGestionePresenze.controllaTurnoEOraQuery(data, oraInizio, oraFine);
    }

    public boolean controlla24HTurno(String data) {
        SimpleDateFormat f = new SimpleDateFormat("MM-dd");
        String fd = f.format(new Date());
        String giornoOggi = fd.substring(3, 5);
        String meseOggi = fd.substring(0, 2);
        int giornoIntegerOggi = Integer.parseInt(giornoOggi);
        int meseIntegerOggi = Integer.parseInt(meseOggi);

        String giornoPermesso = data.substring(8, 10);
        String mesePermesso = data.substring(5, 7);
        int giornoIntegerePermesso = Integer.parseInt(giornoPermesso);
        int meseIntegerPermesso = Integer.parseInt(mesePermesso);

        if (meseIntegerPermesso > meseIntegerOggi) {
            return true;
        } else if (meseIntegerPermesso == meseIntegerOggi) {
            if (giornoIntegerePermesso == giornoIntegerOggi + 1) {
                SimpleDateFormat ora = new SimpleDateFormat("HH");
                String oraDiOggi = ora.format(new Date());
                int oraDiOggiInteger = Integer.parseInt(oraDiOggi);
                String oraInizioTurno = prendiOra(data);
                int oraInizioTurnoInteger = Integer.parseInt(oraInizioTurno.substring(0, 2));
                if (oraDiOggiInteger < oraInizioTurnoInteger) {
                    return true;
                } else {
                    return false;
                }
            } else if (giornoIntegerePermesso > giornoIntegerOggi) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean controlla24HOra(String data, String oraInizio) {
        String dataDaControllare = data.substring(5, 10);
        SimpleDateFormat dataDiOggi = new SimpleDateFormat("MM-dd");
        String dataDiOggiString = dataDiOggi.format(new Date());

        String meseStringDaControllare = dataDaControllare.substring(0, 2);
        String giornoStringDaControllare = dataDaControllare.substring(3, 5);

        int meseIntDaControllare = Integer.parseInt(meseStringDaControllare);
        int giornoIntDaControllare = Integer.parseInt(giornoStringDaControllare);

        String meseDiOggi = dataDiOggiString.substring(0, 2);
        String giornoDiOggi = dataDiOggiString.substring(3, 5);

        int meseDiOggiInt = Integer.parseInt(meseDiOggi);
        int giornoDiOggiInt = Integer.parseInt(giornoDiOggi);

        if (meseIntDaControllare > meseDiOggiInt) {
            return true;
        } else if (meseIntDaControllare == meseDiOggiInt) {
            if (giornoIntDaControllare > giornoDiOggiInt) {
                return true;
            } else if (giornoIntDaControllare == giornoDiOggiInt) {
                String subStringOraTurno = oraInizio.substring(0, 2);
                SimpleDateFormat f = new SimpleDateFormat("HH");
                String fd = f.format(new Date());

                int oraOggi = Integer.parseInt(fd);
                int oraTurnoInteger = Integer.parseInt(subStringOraTurno);

                if (oraOggi < oraTurnoInteger) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private String prendiOra(String data) {
        return boundaryGestionePresenze.prendiOraQuery(data);
    }

    public boolean inserisciPermessoGiornoIntero(String data, String motivazione) {
        return boundaryGestionePresenze.inserisciPermessoGiornoInteroQuery(data, motivazione);
    }

    public boolean inserisciPermessoOre(String data, String oraInizio, String oraFine, String motivazione) {
        return boundaryGestionePresenze.inserisciPermessoOreQuery(data, oraInizio, oraFine, motivazione);
    }

    public boolean controllaOrari(String data, String orario) {
        return boundaryGestionePresenze.controllaOrariQuery(data, orario);
    }
}
