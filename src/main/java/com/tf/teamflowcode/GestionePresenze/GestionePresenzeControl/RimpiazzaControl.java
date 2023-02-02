package com.tf.teamflowcode.GestionePresenze.GestionePresenzeControl;

import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class RimpiazzaControl {

    final String DRIVER = "com.mysql.cj.jdbc.Driver";

    BoundaryDBMS boundaryGestionePresenze = new BoundaryDBMS();

    public void rimpiazzaAmministratoreGiornoIntero(String data, String matricola, String nomeECognome) {
        Dipendente dipendente;

        String giorno = data.substring(8, 10);
        int giornoInt = Integer.parseInt(giorno);
        int giornoPrecedente = giornoInt - 1;
        String stringGiornoPrecedente = Integer.toString(giornoPrecedente);
        String dataPrecedente = data.replace(giorno, stringGiornoPrecedente);

        if (dataPrecedente.equals("2023-01-01")) {
            dataPrecedente = "2022-12-31";
        } else if (dataPrecedente.equals("2023-02-01")) {
            dataPrecedente = "2023-01-31";
        } else if (dataPrecedente.equals("2023-03-01")) {
            dataPrecedente = "2023-02-27";
        } else if (dataPrecedente.equals("2023-04-01")) {
            dataPrecedente = "2023-03-31";
        } else if (dataPrecedente.equals("2023-05-01")) {
            dataPrecedente = "2023-04-30";
        } else if (dataPrecedente.equals("2023-06-01")) {
            dataPrecedente = "2023-05-31";
        } else if (dataPrecedente.equals("2023-07-01")) {
            dataPrecedente = "2023-06-30";
        } else if (dataPrecedente.equals("2023-08-01")) {
            dataPrecedente = "2023-07-31";
        } else if (dataPrecedente.equals("2023-09-01")) {
            dataPrecedente = "2023-08-31";
        } else if (dataPrecedente.equals("2023-10-01")) {
            dataPrecedente = "2023-09-30";
        } else if (dataPrecedente.equals("2023-11-01")) {
            dataPrecedente = "2023-10-31";
        } else if (dataPrecedente.equals("2023-12-01")) {
            dataPrecedente = "2023-11-30";
        }
        String matricolaImpiegato = "";
        String ora_inizio_turno_mattina = prendiOraInizio(matricola, "mattina");
        String ora_fine_turno_mattina = prendiOraFine(matricola, "mattina");
        String ora_inizio_turno_pomeriggio = prendiOraInizio(matricola, "pomeriggio");
        String ora_fine_turno_pomeriggio = prendiOraFine(matricola, "pomeriggio");
        try {
            do {
                dipendente = prendiAmministratore(matricola, nomeECognome);
                matricolaImpiegato = dipendente.getMatricola();
            } while (!controllaGiornoLibero(data, matricolaImpiegato).equals("libero") &&
                    !controllaGiornoLibero(data, matricolaImpiegato).equals("ferie")
                    && controllaNotte(dataPrecedente, Integer.parseInt(matricolaImpiegato))
                    && ora_inizio_turno_mattina.equals(prendiOraInizio(dipendente.getMatricola(), "mattina")));
        } catch (NullPointerException e) {
            int count2 = 0;
            do {
                dipendente = prendiAmministratore(getRuolo(matricola), nomeECognome);
                count2++;
            } while (count2 <= 3
                    || ora_inizio_turno_mattina.equals(prendiOraInizio(dipendente.getMatricola(), "mattina")));

            System.out.println("Primo amministratore " + dipendente);
            assegnaStraordinarioMattina(ora_inizio_turno_mattina, ora_fine_turno_mattina, data,
                    dipendente.getMatricola(), matricola, getRuolo(matricola));
            int count = 0;
            do {
                dipendente = prendiAltroAmministratore(getRuolo(matricola), nomeECognome, dipendente.getNome(),
                        dipendente.getCognome());
                count++;
            } while (count < 3
                    && ora_inizio_turno_pomeriggio.equals(prendiOraInizio(dipendente.getMatricola(), "pomeriggio")));

            System.out.println("Secondo amministratore " + dipendente);
            assegneStraordinarioPomeriggio(ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio, data,
                    dipendente.getMatricola(), matricola, getRuolo(matricola));
            return;
        }
        System.out.println(dipendente);
        if (ora_inizio_turno_mattina.equals(null)) {
            System.out.println("GIORNO LIBERO");
            return;
        }

        aggiornaOrari(dipendente.getMatricola(), data, ora_inizio_turno_mattina, ora_fine_turno_mattina,
                ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio);

        String giornoLibero = prendiGiornoLibero(matricola, data);

        ora_inizio_turno_mattina = prendiOraInizio(dipendente.getMatricola(), "mattina");
        ora_fine_turno_mattina = prendiOraFine(dipendente.getMatricola(), "mattina");
        ora_inizio_turno_pomeriggio = prendiOraInizio(dipendente.getMatricola(), "pomeriggio");
        ora_fine_turno_pomeriggio = prendiOraFine(dipendente.getMatricola(), "pomeriggio");

        aggiornaOrari2(matricola, giornoLibero, ora_inizio_turno_mattina,
                ora_fine_turno_mattina,
                ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio);
    }

    private Dipendente prendiAltroAmministratore(String ruolo, String nomeECognome, String nome, String cognome) {
        return boundaryGestionePresenze.prendiAltroAmministratoreQuery(ruolo, nomeECognome, nome, cognome);
    }

    private Dipendente prendiAmministratore(String matricola, String nomeECognome) {
        return boundaryGestionePresenze.prendiAmministratoreQuery(matricola, nomeECognome);
    }

    public void rimpiazzaImpiegatoGiornoIntero(String data, String matricola, String nomeECognome) {
        Dipendente dipendente;

        String giorno = data.substring(8, 10);
        int giornoInt = Integer.parseInt(giorno);
        int giornoPrecedente = giornoInt - 1;
        String stringGiornoPrecedente = Integer.toString(giornoPrecedente);
        String dataPrecedente = data.replace(giorno, stringGiornoPrecedente);

        if (dataPrecedente.equals("2023-01-01")) {
            dataPrecedente = "2022-12-31";
        } else if (dataPrecedente.equals("2023-02-01")) {
            dataPrecedente = "2023-01-31";
        } else if (dataPrecedente.equals("2023-03-01")) {
            dataPrecedente = "2023-02-27";
        } else if (dataPrecedente.equals("2023-04-01")) {
            dataPrecedente = "2023-03-31";
        } else if (dataPrecedente.equals("2023-05-01")) {
            dataPrecedente = "2023-04-30";
        } else if (dataPrecedente.equals("2023-06-01")) {
            dataPrecedente = "2023-05-31";
        } else if (dataPrecedente.equals("2023-07-01")) {
            dataPrecedente = "2023-06-30";
        } else if (dataPrecedente.equals("2023-08-01")) {
            dataPrecedente = "2023-07-31";
        } else if (dataPrecedente.equals("2023-09-01")) {
            dataPrecedente = "2023-08-31";
        } else if (dataPrecedente.equals("2023-10-01")) {
            dataPrecedente = "2023-09-30";
        } else if (dataPrecedente.equals("2023-11-01")) {
            dataPrecedente = "2023-10-31";
        } else if (dataPrecedente.equals("2023-12-01")) {
            dataPrecedente = "2023-11-30";
        }
        String matricolaImpiegato = "";
        String ora_inizio_turno_mattina = prendiOraInizio(matricola, "mattina");
        String ora_fine_turno_mattina = prendiOraFine(matricola, "mattina");
        String ora_inizio_turno_pomeriggio = prendiOraInizio(matricola, "pomeriggio");
        String ora_fine_turno_pomeriggio = prendiOraFine(matricola, "pomeriggio");
        try {
            do {
                dipendente = prendiImpiegato(getRuolo(matricola), nomeECognome);
                matricolaImpiegato = dipendente.getMatricola();
            } while (!controllaGiornoLibero(data, matricolaImpiegato).equals("libero")
                    && !controllaGiornoLibero(data, matricolaImpiegato).equals("ferie")
                    && controllaNotte(dataPrecedente, Integer.parseInt(matricolaImpiegato)));
            System.out.println(
                    "Assegnato ad un impiegato che è libero e il giorno\nprima non ha fatto la notte: " + dipendente);
        } catch (NullPointerException e) {
            int count3 = 0;
            do {
                dipendente = prendiImpiegato(getRuolo(matricola), nomeECognome);
                count3++;
            } while (count3 <= 10
                    || ora_inizio_turno_mattina.equals(prendiOraInizio(dipendente.getMatricola(), "mattina")));

            System.out.println("Primo impiegato scelto per lo straordinario: " + dipendente);

            assegnaStraordinarioMattina(ora_inizio_turno_mattina, ora_fine_turno_mattina, data,
                    dipendente.getMatricola(), matricola, getRuolo(matricola));
            int count4 = 0;
            do {
                dipendente = prendiAltroImpiegato(getRuolo(matricola), nomeECognome, dipendente.getNome(),
                        dipendente.getCognome());
                count4++;
            } while (count4 < 10
                    && ora_inizio_turno_pomeriggio.equals(prendiOraInizio(dipendente.getMatricola(), "pomeriggio")));

            System.out.println("Secondo impiegato scelto per lo straordinario: " + dipendente);
            assegneStraordinarioPomeriggio(ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio, data,
                    dipendente.getMatricola(), matricola, getRuolo(matricola));
            return;
        }

        if (ora_inizio_turno_mattina.equals(null)) {
            System.out.println("GIORNO LIBERO");
            return;
        }

        aggiornaOrari(dipendente.getMatricola(), data, ora_inizio_turno_mattina, ora_fine_turno_mattina,
                ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio);

        String giornoLibero = prendiGiornoLibero(matricola, data);

        ora_inizio_turno_mattina = prendiOraInizio(dipendente.getMatricola(), "mattina");
        ora_fine_turno_mattina = prendiOraFine(dipendente.getMatricola(), "mattina");
        ora_inizio_turno_pomeriggio = prendiOraInizio(dipendente.getMatricola(), "pomeriggio");
        ora_fine_turno_pomeriggio = prendiOraFine(dipendente.getMatricola(), "pomeriggio");

        aggiornaOrari2(matricola, giornoLibero, ora_inizio_turno_mattina,
                ora_fine_turno_mattina,
                ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio);
    }

    private Dipendente prendiAltroImpiegato(String ruolo, String nomeECognome, String nome, String cognome) {
        return boundaryGestionePresenze.prendiAltroImpiegatoQuery(ruolo, nomeECognome, nome, cognome);
    }

    private void assegneStraordinarioPomeriggio(String ora_inizio_turno_pomeriggio, String ora_fine_turno_pomeriggio,
            String data, String matricola, String matricolaPermesso, String ruoloImpiegatoPermesso) {
        boundaryGestionePresenze.assegneStraordinarioPomeriggioQuery(ora_inizio_turno_pomeriggio,
                ora_fine_turno_pomeriggio, data, matricola, matricolaPermesso, ruoloImpiegatoPermesso);
    }

    private void assegnaStraordinarioMattina(String ora_inizio_turno_mattina, String ora_fine_turno_mattina,
            String data, String matricola, String matricolaImpiegatoPermesso, String ruoloImpiegatoPermesso) {
        boundaryGestionePresenze.assegnaStraordinarioMattinaQuery(ora_inizio_turno_mattina, ora_fine_turno_mattina,
                data, matricola, matricolaImpiegatoPermesso, ruoloImpiegatoPermesso);
    }

    public String prendiGiornoLibero(String matricola, String data_p) {
        return boundaryGestionePresenze.prendiGiornoLiberoQuery(matricola, data_p);
    }

    private void aggiornaOrari2(String matricolaImpiegatoSelezionato, String data,
            String ora_inizio_turno_mattina, String ora_fine_turno_mattina, String ora_inizio_turno_pomeriggio,
            String ora_fine_turno_pomeriggio) {
        boundaryGestionePresenze.aggiornaOrari2Query(matricolaImpiegatoSelezionato, data, ora_inizio_turno_mattina,
                ora_fine_turno_mattina, ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio);
    }

    private void aggiornaOrari(String matricolaImpiegatoSelezionato, String data,
            String ora_inizio_turno_mattina, String ora_fine_turno_mattina, String ora_inizio_turno_pomeriggio,
            String ora_fine_turno_pomeriggio) {
        boundaryGestionePresenze.aggiornaOrariQuery(matricolaImpiegatoSelezionato, data, ora_inizio_turno_mattina,
                ora_fine_turno_mattina, ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio);
    }

    public void rimpiazzaImpiegatoOre(String data, String oraInizio, String oraFine, String matricola,
            String nomeECognome) {
        Dipendente dipendente;
        String descrizione = "";
        int oraInizioInteger = Integer.parseInt(oraInizio.substring(0, 2));
        if (oraInizioInteger >= 5 && oraInizioInteger < 15) {
            descrizione = "mattina";
        } else if (oraInizioInteger >= 15 && oraInizioInteger < 22) {
            descrizione = "pomeriggio";
        } else {
            descrizione = "notte";
        }
        do {
            dipendente = prendiImpiegato(getRuolo(matricola), nomeECognome);

        } while (oraInizio
                .equals(boundaryGestionePresenze.prendiOraInizioQuery(dipendente.getMatricola(), descrizione)));

        System.out.println("Impiegato scelto per lo straordinario: " + dipendente);

        int ora_inizio = Integer.parseInt(oraInizio.substring(0, 2));
        int ora_fine = Integer.parseInt(oraFine.substring(0, 2));

        if (ora_inizio >= 5 && ora_fine <= 15) {
            assegnaStraordinarioMattina(oraInizio, oraFine, data,
                    dipendente.getMatricola(), matricola, getRuolo(matricola));
        } else {
            assegneStraordinarioPomeriggio(oraInizio, oraFine, data, dipendente.getMatricola(), matricola,
                    getRuolo(matricola));
        }

    }

    public boolean controllaNotte(String data_p, int p_matricola) {
        return boundaryGestionePresenze.controllaNotteQuery(data_p, p_matricola);
    }

    public void rimpiazzaImpiegatoNotte(String data_p, int matricola, String nomeECognome) {
        // selezionare un impiegato

        String matricolaString = Integer.toString(matricola);

        String ruolo = getRuolo(matricolaString);
        Dipendente dipendenteSelezionato = prendiImpiegato(ruolo, nomeECognome);
        while (matricolaString.equals(dipendenteSelezionato.getMatricola())) {
            dipendenteSelezionato = prendiImpiegato(ruolo, nomeECognome);
        }
        System.out.println(dipendenteSelezionato);
        // prendere le ore "normali" di questo impiegato
        String ora_inizio_turno_mattina = prendiOraInizio(dipendenteSelezionato.getMatricola(), "mattina");
        String ora_fine_turno_mattina = prendiOraFine(dipendenteSelezionato.getMatricola(), "mattina");
        String ora_inizio_turno_pomeriggio = prendiOraInizio(dipendenteSelezionato.getMatricola(), "pomeriggio");
        String ora_fine_turno_pomeriggio = prendiOraFine(dipendenteSelezionato.getMatricola(), "pomeriggio");

        if (ora_inizio_turno_mattina.equals(null)) {
            dipendenteSelezionato = prendiImpiegato(ruolo, nomeECognome);
        }

        aggiornaTurnoNotteImpiegatoSelezionato(dipendenteSelezionato.getMatricola(), data_p); // mette la notte e il
                                                                                              // giorno successivo ed
                                                                                              // elimina i turni vecchi
        String dataNotte = prendiGiornoNotte(dipendenteSelezionato.getMatricola(), data_p);
        System.out.println(dataNotte);
        assegnaTurniNuovi(ora_inizio_turno_mattina, ora_fine_turno_mattina, ora_inizio_turno_pomeriggio,
                ora_fine_turno_pomeriggio, dataNotte, dipendenteSelezionato.getMatricola()); // mette i nuovi turni
                                                                                             // eliminando il turno di
        // notte vecchio

        ora_inizio_turno_mattina = prendiOraInizio(matricolaString, "mattina");
        ora_fine_turno_mattina = prendiOraFine(matricolaString, "mattina");
        ora_inizio_turno_pomeriggio = prendiOraInizio(matricolaString, "pomeriggio");
        ora_fine_turno_pomeriggio = prendiOraFine(matricolaString, "pomeriggio");
        assegnaTurniNuovi(ora_inizio_turno_mattina, ora_fine_turno_mattina, ora_inizio_turno_pomeriggio,
                ora_fine_turno_pomeriggio, data_p, matricolaString); // mette i turni nuovi ed
                                                                     // elimina il turno di notte
        aggiornaTurnoNotteImpiegatoSelezionato(matricolaString, dataNotte); // mette la notte al vecchio impiegato

    }

    private String getRuolo(String matricolaString) {
        return boundaryGestionePresenze.getRuoloQuery(matricolaString);
    }

    private void assegnaTurniNuovi(String ora_inizio_turno_mattina, String ora_fine_turno_mattina,
            String ora_inizio_turno_pomeriggio, String ora_fine_turno_pomeriggio, String dataNotte, String matricola) {
        boundaryGestionePresenze.assegnaTurniNuoviQuery(ora_inizio_turno_mattina, ora_fine_turno_mattina,
                ora_inizio_turno_pomeriggio, ora_fine_turno_pomeriggio, dataNotte, matricola);
    }

    private String prendiGiornoNotte(String matricola, String data_p) {
        return boundaryGestionePresenze.prendiGiornoNotteQuery(matricola, data_p);
    }

    private void aggiornaTurnoNotteImpiegatoSelezionato(String matricola, String data_p) {
        boundaryGestionePresenze.aggiornaTurnoNotteImpiegatoSelezionatoQuery(matricola, data_p);
    }

    private String controllaGiornoLibero(String data_p, String matricola) {
        return boundaryGestionePresenze.controllaGiornoLiberoQuery(data_p, matricola);
    }

    private String prendiOraFine(String matricola, String descrizione) {
        return boundaryGestionePresenze.prendiOraFineQuery(matricola, descrizione);
    }

    private String prendiOraInizio(String matricola, String descrizione) {
        return boundaryGestionePresenze.prendiOraInizioQuery(matricola, descrizione);
    }

    private Dipendente prendiImpiegato(String ruolo, String nomeECognome) {
        return boundaryGestionePresenze.prendiImpiegatoQuery(ruolo, nomeECognome);
    }

    public void rimpiazzaAmministratoreNotte(String data, int matricola, String nomeECognome) {
        String matricolaString = Integer.toString(matricola);

        Dipendente dipendenteSelezionato = prendiAmministratore(Integer.toString(matricola), nomeECognome);
        while (matricolaString.equals(dipendenteSelezionato.getMatricola())) {
            dipendenteSelezionato = prendiAmministratore(Integer.toString(matricola), nomeECognome);
        }
        System.out.println(dipendenteSelezionato);
        // prendere le ore "normali" di questo impiegato
        String ora_inizio_turno_mattina = prendiOraInizio(dipendenteSelezionato.getMatricola(), "mattina");
        String ora_fine_turno_mattina = prendiOraFine(dipendenteSelezionato.getMatricola(), "mattina");
        String ora_inizio_turno_pomeriggio = prendiOraInizio(dipendenteSelezionato.getMatricola(), "pomeriggio");
        String ora_fine_turno_pomeriggio = prendiOraFine(dipendenteSelezionato.getMatricola(), "pomeriggio");

        if (ora_inizio_turno_mattina.equals(null)) {
            dipendenteSelezionato = prendiAmministratore(Integer.toString(matricola), nomeECognome);
        }

        aggiornaTurnoNotteImpiegatoSelezionato(dipendenteSelezionato.getMatricola(), data); // mette la notte e il
                                                                                            // giorno successivo ed
                                                                                            // elimina i turni vecchi
        String dataNotte = prendiGiornoNotte(dipendenteSelezionato.getMatricola(), data);
        System.out.println("\n\nData notte successiva: " + dataNotte + "\n\n");
        assegnaTurniNuovi(ora_inizio_turno_mattina, ora_fine_turno_mattina, ora_inizio_turno_pomeriggio,
                ora_fine_turno_pomeriggio, dataNotte, dipendenteSelezionato.getMatricola()); // mette i nuovi turni
                                                                                             // eliminando il turno di
        // notte vecchio

        ora_inizio_turno_mattina = prendiOraInizio(matricolaString, "mattina");
        ora_fine_turno_mattina = prendiOraFine(matricolaString, "mattina");
        ora_inizio_turno_pomeriggio = prendiOraInizio(matricolaString, "pomeriggio");
        ora_fine_turno_pomeriggio = prendiOraFine(matricolaString, "pomeriggio");
        assegnaTurniNuovi(ora_inizio_turno_mattina, ora_fine_turno_mattina, ora_inizio_turno_pomeriggio,
                ora_fine_turno_pomeriggio, data, matricolaString); // mette i turni nuovi ed
                                                                   // elimina il turno di notte
        aggiornaTurnoNotteImpiegatoSelezionato(matricolaString, dataNotte); // mette la notte al vecchio impiegato
    }

    public void rimpiazzaAmministratoreOre(String data, String oraInizio, String oraFine, String returnMatricola,
            String nomeECognome) {
        Dipendente dipendente = prendiAmministratore(returnMatricola, nomeECognome);

        System.out.println(dipendente);

        int ora_inizio = Integer.parseInt(oraInizio.substring(0, 2));
        int ora_fine = Integer.parseInt(oraFine.substring(0, 2));

        if (ora_inizio >= 5 && ora_fine <= 15) {
            assegnaStraordinarioMattina(oraInizio, oraFine, data,
                    dipendente.getMatricola(), returnMatricola, getRuolo(returnMatricola));
        } else {
            assegneStraordinarioPomeriggio(oraInizio, oraFine, data, dipendente.getMatricola(), returnMatricola,
                    getRuolo(returnMatricola));
        }
    }
}