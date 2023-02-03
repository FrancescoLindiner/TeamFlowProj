package com.tf.teamflowcode.GestioneOrariEStipendi.GestioneOrariEStipendiControl;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import com.tf.teamflowcode.Entity.Dipendente;
import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

public class GeneraOrarioControl {

    String ora_inizioMattina = "08:00";
    String ora_fineMattina = "12:00";

    String ora_inizio2Mattina = "12:00";
    String ora_fine2Mattina = "15:00";

    String ora_inizioPome = "15:00";
    String ora_finePome = "18:00";

    String ora_inizio2Pome = "18:00";
    String ora_fine2Pome = "22:00";

    String oraNotteInizio = "22:00";
    String oraNotteFine = "06:00";

    String ora_inizio3Mattina = "05:00";
    String ora_fine3Mattina = "08:00";

    String ora_inizio3Pome = "15:00";
    String ora_fine3Pome = "18:00";

    boolean notte = false;

    BoundaryDBMS boundaryGestioneOrariEStipendi = new BoundaryDBMS();

    public boolean isGenerato() {
        Statement stmt = null;
        Connection conn = null;

        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        DateFormat anno2 = new SimpleDateFormat("yyyy-MM-dd");
        Date anno3 = new Date();
        String annoDiOggi = anno2.format(anno3);
        String annoNew = annoDiOggi.replaceAll("28", "31");

        try {
            Class.forName(DRIVER).getConstructor().newInstance();

            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto?", "root", "root");

            String sql = "SELECT data FROM turno";

            System.out.println("Checking record into the table...");

            stmt = conn.createStatement();
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("data").equals(annoNew)) {
                    return true;
                }
            }
            return false;

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

    public void generaOrari(int counterGiorni) {

        DateFormat anno = new SimpleDateFormat("yyyy");
        Date anno2 = new Date();
        String dataDiOggiAnno = anno.format(anno2);

        int numeroRandom = 1;
        List<Dipendente> listaTuttiImpiegati = boundaryGestioneOrariEStipendi.prendiTuttiGliImpiegati();
        // GENERA TUPLE STIPENDI
        for (Dipendente dipendente : listaTuttiImpiegati) {
            DateFormat mese = new SimpleDateFormat("MM");
            Date mese2 = new Date();
            String dataDiOggiMese = mese.format(mese2);
            int meseInteger = Integer.parseInt(dataDiOggiMese);
            int meseCount = meseInteger;
            for (int i = 1; i <= 3; i++) {
                boundaryGestioneOrariEStipendi.inserisciTupleStipendiQuery(dipendente.getMatricola(),
                        dataDiOggiAnno,
                        meseCount);
                meseCount++;
            }
        }

        BoundaryDBMS boundaryDBMS = new BoundaryDBMS();
        boundaryDBMS.eliminaPeriodoRossoVecchio();

        AccountControl accountControl = new AccountControl();

        List<Dipendente> listaImpiegati = prendiImpiegati();
        for (Dipendente dipendente : listaImpiegati) {

            if (numeroRandom == 4) {
                numeroRandom = 1;
            }
            if (numeroRandom == 1) {
                int counter = 1;
                while (counter < counterGiorni) {
                    if (counter % 7 == 5) {
                        caricaTurnoNotturno(dipendente.getMatricola(), getData(counter), oraNotteInizio, oraNotteFine);
                        counter += 2;
                    } else if (counter % 7 == 3) {
                        caricaITurni1(dipendente.getMatricola(), getData(counter), ora_inizioMattina, ora_fineMattina,
                                ora_inizioPome, ora_finePome);
                        counter++;
                        caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                        counter++;
                    } else {
                        caricaITurni1(dipendente.getMatricola(), getData(counter), ora_inizioMattina, ora_fineMattina,
                                ora_inizioPome, ora_finePome);
                        counter++;
                    }
                }
                numeroRandom++;
            } else if (numeroRandom == 2) {
                int counter = 1;
                while (counter < counterGiorni) {
                    if (counter % 7 == 2) {
                        caricaTurnoNotturno(dipendente.getMatricola(), getData(counter), oraNotteInizio, oraNotteFine);
                        counter += 2;
                    } else if (counter % 7 == 4) {
                        caricaITurni2(dipendente.getMatricola(), getData(counter), ora_inizio2Mattina, ora_fine2Mattina,
                                ora_inizio2Pome, ora_fine2Pome);
                        counter++;
                        caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                        counter++;
                    } else {
                        caricaITurni2(dipendente.getMatricola(), getData(counter), ora_inizio2Mattina, ora_fine2Mattina,
                                ora_inizio2Pome, ora_fine2Pome);
                        counter++;
                    }
                }
                numeroRandom++;
            } else {
                int counter = 1;
                while (counter < counterGiorni) {
                    if (counter % 7 == 1) {
                        caricaTurnoNotturno(dipendente.getMatricola(), getData(counter), oraNotteInizio, oraNotteFine);
                        counter += 2;
                    } else if (counter % 7 == 6) {
                        caricaITurni3(dipendente.getMatricola(), getData(counter), ora_inizio3Mattina, ora_fine3Mattina,
                                ora_inizio3Pome, ora_fine3Pome);
                        counter++;
                        caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                        counter++;
                    } else {
                        caricaITurni3(dipendente.getMatricola(), getData(counter), ora_inizio3Mattina, ora_fine3Mattina,
                                ora_inizio3Pome, ora_fine3Pome);
                        counter++;
                    }
                }
                numeroRandom++;
            }
        }

        List<Dipendente> listaImpiegatiConFerie = boundaryGestioneOrariEStipendi.prendiImpiegatiConFerie();
        if (listaImpiegatiConFerie.size() != 0) {
            boolean ferie;
            // prendi data inizio ferie e fine ferie
            for (Dipendente dipendente : listaImpiegatiConFerie) {
                ferie = false;
                String dataInizioFerie = boundaryGestioneOrariEStipendi.prendiDataFerie(dipendente.getMatricola(),
                        "inizio");
                String dataFineFerie = boundaryGestioneOrariEStipendi.prendiDataFerie(dipendente.getMatricola(),
                        "fine");
                LocalDate localDateInizioFerie = LocalDate.parse(dataInizioFerie);
                LocalDate localDateFineFerie = LocalDate.parse(dataFineFerie);
                // prendi tutti gli immpiegati di quel servizio
                int impiegatiTotali = accountControl.prendiImpiegati(dipendente.getTipologia());
                int i = 0;
                LocalDate date = localDateInizioFerie;
                while (!date.isEqual(localDateFineFerie)) {
                    // prendi gli impiegati che lavorano quel giorno
                    int impiegati = boundaryGestioneOrariEStipendi
                            .prendiImpiegatiQuelGiorno(localDateInizioFerie.toString(), dipendente.getTipologia());
                    // se gli impiegati totali meno l'impiegato selezionato sono tali da essere
                    // maggiori del 60%
                    if (impiegati - 1 >= (60 * impiegatiTotali) / 100) {
                        ferie = true;
                        // vengono concesse le ferie e vengono generati gli orari modificati
                    } else {
                        ferie = false;
                        break;
                        // altrimenti non vengono concesse e vengono generati gli orari normali
                    }
                    date = localDateInizioFerie.plusDays(i);
                    i++;
                }
                if (ferie) {
                    System.out.println(dipendente + "\nFerie Concesse");
                    generaOrariModificati(dipendente, 92);
                } else {
                    System.out.println(dipendente + "\nFerie non concesse");
                    generaOrariNormali(dipendente, 92);
                }

            }
        }
    }

    private void generaOrariNormali(Dipendente dipendente, int counterGiorni) {
        int numeroRandom = 1;
        if (numeroRandom == 4) {
            numeroRandom = 1;
        }
        if (numeroRandom == 1) {
            int counter = 0;
            while (counter < counterGiorni) {
                if (counter % 7 == 5) {
                    caricaTurnoNotturno(dipendente.getMatricola(), getData(counter), oraNotteInizio, oraNotteFine);
                    counter += 2;
                } else if (counter % 7 == 3) {
                    caricaITurni1(dipendente.getMatricola(), getData(counter), ora_inizioMattina, ora_fineMattina,
                            ora_inizioPome, ora_finePome);
                    counter++;
                    caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                    counter++;
                } else {
                    caricaITurni1(dipendente.getMatricola(), getData(counter), ora_inizioMattina, ora_fineMattina,
                            ora_inizioPome, ora_finePome);
                    counter++;
                }
            }
            numeroRandom++;
        } else if (numeroRandom == 2) {
            int counter = 0;
            while (counter < counterGiorni) {
                if (counter % 7 == 3) {
                    caricaTurnoNotturno(dipendente.getMatricola(), getData(counter), oraNotteInizio, oraNotteFine);
                    counter += 2;
                } else if (counter % 7 == 5) {
                    caricaITurni2(dipendente.getMatricola(), getData(counter), ora_inizio2Mattina, ora_fine2Mattina,
                            ora_inizio2Pome, ora_fine2Pome);
                    counter++;
                    caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                    counter++;
                } else {
                    caricaITurni2(dipendente.getMatricola(), getData(counter), ora_inizio2Mattina, ora_fine2Mattina,
                            ora_inizio2Pome, ora_fine2Pome);
                    counter++;
                }
            }
            numeroRandom++;
        } else {
            int counter = 0;
            while (counter < counterGiorni) {
                if (counter % 7 == 4) {
                    caricaTurnoNotturno(dipendente.getMatricola(), getData(counter), oraNotteInizio, oraNotteFine);
                    counter += 2;
                } else if (counter % 7 == 2) {
                    caricaITurni3(dipendente.getMatricola(), getData(counter), ora_inizio3Mattina, ora_fine3Mattina,
                            ora_inizio3Pome, ora_fine3Pome);
                    counter++;
                    caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                    counter++;
                } else {
                    caricaITurni3(dipendente.getMatricola(), getData(counter), ora_inizio3Mattina, ora_fine3Mattina,
                            ora_inizio3Pome, ora_fine3Pome);
                    counter++;
                }
            }
            numeroRandom++;
        }
    }

    private void generaOrariModificati(Dipendente dipendente, int counterGiorni) {
        String dataInizioFerie = boundaryGestioneOrariEStipendi.prendiDataFerie(dipendente.getMatricola(),
                "inizio");
        String dataFineFerie = boundaryGestioneOrariEStipendi.prendiDataFerie(dipendente.getMatricola(),
                "fine");

        int numeroRandom = 1;
        LocalDate localDateInizioFerie = LocalDate.parse(dataInizioFerie);
        LocalDate localDateFineFerie = LocalDate.parse(dataFineFerie);
        long daysBetween = ChronoUnit.DAYS.between(localDateInizioFerie,
                localDateFineFerie);

        if (numeroRandom == 4) {
            numeroRandom = 1;
        }
        if (numeroRandom == 1) {
            int counter = 0;
            while (counter < counterGiorni) {
                if (getData(counter).equals(dataInizioFerie)) {
                    for (int i = 0; i <= daysBetween; i++) {
                        boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                getData(counter));
                        counter++;
                    }
                }
                if (counter % 7 == 0) {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaTurnoNotturno(dipendente.getMatricola(), getData(counter),
                            oraNotteInizio,
                            oraNotteFine);
                    counter++;

                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                    counter++;

                } else if (counter % 7 == 3) {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaITurni1(dipendente.getMatricola(), getData(counter), ora_inizioMattina,
                            ora_fineMattina,
                            ora_inizioPome, ora_finePome);
                    counter++;
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                    counter++;

                } else {
                    caricaITurni1(dipendente.getMatricola(), getData(counter), ora_inizioMattina,
                            ora_fineMattina,
                            ora_inizioPome, ora_finePome);
                    counter++;
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                }
            }
            numeroRandom++;
        } else if (numeroRandom == 2) {
            int counter = 0;
            while (counter < counterGiorni) {
                if (getData(counter).equals(dataInizioFerie)) {
                    for (int i = 0; i <= daysBetween; i++) {
                        boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                getData(counter));
                        counter++;
                    }
                }
                if (counter % 7 == 3) {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaTurnoNotturno(dipendente.getMatricola(), getData(counter),
                            oraNotteInizio,
                            oraNotteFine);
                    counter += 2;
                } else if (counter % 7 == 5) {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaITurni2(dipendente.getMatricola(), getData(counter),
                            ora_inizio2Mattina,
                            ora_fine2Mattina,
                            ora_inizio2Pome, ora_fine2Pome);
                    counter++;
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                    counter++;
                } else {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaITurni2(dipendente.getMatricola(), getData(counter),
                            ora_inizio2Mattina,
                            ora_fine2Mattina,
                            ora_inizio2Pome, ora_fine2Pome);
                    counter++;
                }
            }
            numeroRandom++;
        } else {
            int counter = 0;
            while (counter < counterGiorni) {
                if (getData(counter).equals(dataInizioFerie)) {
                    for (int i = 0; i <= daysBetween; i++) {
                        boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                getData(counter));
                        counter++;
                    }
                }
                if (counter % 7 == 4) {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaTurnoNotturno(dipendente.getMatricola(), getData(counter),
                            oraNotteInizio,
                            oraNotteFine);
                    counter += 2;
                } else if (counter % 7 == 2) {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaITurni3(dipendente.getMatricola(), getData(counter),
                            ora_inizio3Mattina,
                            ora_fine3Mattina,
                            ora_inizio3Pome, ora_fine3Pome);
                    counter++;
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaGiornoLibero(dipendente.getMatricola(), getData(counter));
                    counter++;
                } else {
                    if (getData(counter).equals(dataInizioFerie)) {
                        for (int i = 0; i <= daysBetween; i++) {
                            boundaryGestioneOrariEStipendi.caricaFerie(dipendente.getMatricola(),
                                    getData(counter));
                            counter++;
                        }
                    }
                    caricaITurni3(dipendente.getMatricola(), getData(counter),
                            ora_inizio3Mattina,
                            ora_fine3Mattina,
                            ora_inizio3Pome, ora_fine3Pome);
                    counter++;
                }
            }
            numeroRandom++;
        }
    }

    private void caricaGiornoLibero(String matricola, String data) {
        boundaryGestioneOrariEStipendi.caricaGiornoLiberoQuery(matricola, data);
    }

    private void caricaTurnoNotturno(String matricola, String data, String oraNotteInizio2, String oraNotteFine2) {
        boundaryGestioneOrariEStipendi.caricaTurnoNotturnoQuery(matricola, data, oraNotteInizio2, oraNotteFine2);
    }

    private void caricaITurni1(String matricola, String data, String ora_inizioMattina2, String ora_fineMattina2,
            String ora_inizioPome2, String ora_finePome2) {
        boundaryGestioneOrariEStipendi.caricaITurni1Query(matricola, data, ora_inizioMattina2, ora_fineMattina2,
                ora_inizioPome2, ora_finePome2);
    }

    private void caricaITurni2(String matricola, String data, String ora_inizioMattina2, String ora_fineMattina2,
            String ora_inizioPome2, String ora_finePome2) {
        boundaryGestioneOrariEStipendi.caricaITurni2Query(matricola, data, ora_inizioMattina2, ora_fineMattina2,
                ora_inizioPome2, ora_finePome2);
    }

    private void caricaITurni3(String matricola, String data, String ora_inizioMattina2, String ora_fineMattina2,
            String ora_inizioPome2, String ora_finePome2) {
        boundaryGestioneOrariEStipendi.caricaITurni3Query(matricola, data, ora_inizioMattina2, ora_fineMattina2,
                ora_inizioPome2, ora_finePome2);
    }

    private String getData(int giorno) {
        String s;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DATE, giorno-1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        s = formatter.format(date);
        return s;
    }

    public int numeroRandom() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    public List<Dipendente> prendiImpiegati() {
        return boundaryGestioneOrariEStipendi.prendiImpiegatiQuery();
    }

    public void eliminaOrari() {
        boundaryGestioneOrariEStipendi.eliminaOrariQuery();
    }
}
