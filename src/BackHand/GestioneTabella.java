package BackHand;

import javax.sound.sampled.Line;

public class GestioneTabella {

    public static void main(String[] args) {

        GestioneTabella g = new GestioneTabella();

        g.getMatrice();

    }


    public String[][] getMatrice() {

        String[][] tabella = new String[10][10];

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                tabella[i][j] = "";

            }

        }

        int[] lunghezze = {5, 4, 3, 3, 2};

        stampa(tabella);//togliere

        for (int i = 0; i < lunghezze.length; i++) {

            Nave nave = ricercaPosizionePerNave(tabella, lunghezze[i]);

            int riga = nave.getRiga();
            int colonna = nave.getColonna();
            int direzione = nave.getDirezione();

            posizionaNave(riga, colonna, tabella, direzione, lunghezze[i], "X");

            stampa(tabella);

        }

        return tabella;

    }

    public Nave ricercaPosizionePerNave(String[][] tabella, int lunghezza) {


        boolean condizionePrimaCasellaCorretta = true;
        boolean navePosizionabile = false;

        int riga = -1;
        int colonna = -1;
        int direzione = -1;

        do {

            navePosizionabile = false;
            condizionePrimaCasellaCorretta = true;

            riga = (int) (Math.random() * 10);
            colonna = (int) (Math.random() * 10);

            condizionePrimaCasellaCorretta = controllaCasellaNave(riga, colonna, tabella, 0, 0, true);

            System.out.println();

            direzione = (int) (Math.random() * 4);

            for (int i = 0; i < 4 && condizionePrimaCasellaCorretta && !navePosizionabile; i++) {

                System.out.println("Direzione " + direzione);

                for (int j = 1; j < lunghezza; j++) {

                    navePosizionabile = controllaCasellaNave(riga, colonna, tabella, direzione, j, false);

                    if (!navePosizionabile) {

                        break;

                    }

                    System.out.println();

                }

                if (!navePosizionabile) {

                    direzione = prossimaDirezione(direzione);

                }


                System.out.println();
                System.out.println("condizione casella coda " + navePosizionabile);

                System.out.println();

            }

            System.out.println("condizione prima casella " + condizionePrimaCasellaCorretta);


        } while (!navePosizionabile);


        Nave nave = new Nave(riga, colonna, direzione, lunghezza);

        return nave;

    }

    public boolean controllaCasellaNave(int riga, int colonna, String[][] tabella, int direzione, int distanzaDallaPrima, boolean condizionePrimaCasella) {

        boolean condizione = true;

        InfoCasella casellaNave = null;

        if (condizionePrimaCasella) {

            casellaNave = getCasellaNaveControllataInXeNull(riga, colonna, tabella, 0, 0);

        } else {

            casellaNave = getCasellaNaveControllataInNull(riga, colonna, tabella, direzione, distanzaDallaPrima);

        }

        if (casellaNave == null) {

            condizione = false;

        } else {

            int rigaCasellaNave = casellaNave.getRiga();
            int colonnaCasellaNave = casellaNave.getColonna();
            String valoreCasellaNave = casellaNave.getValore();
            int direzioneOpposta = getPuntoCardinaleOpposto(direzione);

            System.out.print((distanzaDallaPrima + 1) + ") " + rigaCasellaNave + "" + colonnaCasellaNave + getValoreStringaVuota(valoreCasellaNave) + ": ");

            for (int i = 0; i < 4; i++) {

                if (!condizionePrimaCasella && i != direzioneOpposta || condizionePrimaCasella) {

                    InfoCasella casellaAdiacente = getCasellaNaveControllataInX(rigaCasellaNave, colonnaCasellaNave, tabella, i, 1);

                    if (casellaAdiacente == null) {

                        condizione = false;
                        break;

                    } else {

                        int rigaCasellaAdiacente = casellaAdiacente.getRiga();
                        int colonnaCasellaAdiacente = casellaAdiacente.getColonna();
                        String valoreCasellaAdiacente = casellaAdiacente.getValore();

                        System.out.print(rigaCasellaAdiacente + "" + colonnaCasellaAdiacente + "" + getValoreStringaVuota(valoreCasellaAdiacente) + ", ");//togliere

                    }

                }

            }

        }

        return condizione;

    }

    public InfoCasella getCasellaAdiacente(String[][] tabella, int riga, int colonna, int direzione, int lunghezza) {


        switch (direzione) {

            case 0:

                riga = riga - lunghezza;
                break;

            case 1:

                colonna = colonna + lunghezza;
                break;

            case 2:

                riga = riga + lunghezza;
                break;

            case 3:

                colonna = colonna - lunghezza;

            default:

        }

        return (new InfoCasella(riga, colonna, tabella, tabella[riga][colonna]));

    }

    public int getPuntoCardinaleOpposto(int puntoCardinale) {

        switch (puntoCardinale) {

            case 0:

                return 2;

            case 1:

                return 3;

            case 2:

                return 0;

            case 3:

                return 1;

            default:

                return -1;

        }

    }

    public void stampa(String[][] t) { //metodo da togliere

        System.out.println("\\ 0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {

            System.out.print(i + "|");

            for (int j = 0; j < 10; j++) {

                String valore = t[i][j];

                if (valore.isEmpty()) {

                    System.out.print(" ");

                } else {

                    System.out.print(valore);

                }


                System.out.print("|");

            }

            System.out.println();

        }

        System.out.println();

    }

    public String getValoreStringaVuota(String valore) {//metodo da togliere

        if (valore.isEmpty()) {

            return "/";

        } else {

            return valore;

        }

    }

    public InfoCasella getCasellaNaveControllataInXeNull(int riga, int colonna, String[][] tabella, int direzione, int lunghezza) {

        boolean condizione = true;

        InfoCasella casella = null;
        String valoreCasellaCoda = "null";

        try {

            casella = getCasellaAdiacente(tabella, riga, colonna, direzione, lunghezza);

        } catch (Exception e) {

            condizione = false;

        }

        if (condizione) {

            valoreCasellaCoda = casella.getValore();

            if (valoreCasellaCoda.equals("X")) {

                condizione = false;

            }


        }

        if (condizione) {

            return casella;

        } else {

            return null;

        }

    }

    public InfoCasella getCasellaNaveControllataInX(int riga, int colonna, String[][] tabella, int direzione, int lunghezza) {

        boolean condizione = true;
        InfoCasella casella = null;
        String valoreCasellaCoda = "null";

        try {

            casella = getCasellaAdiacente(tabella, riga, colonna, direzione, lunghezza);
            valoreCasellaCoda = casella.getValore();

        } catch (Exception e) {

        }

        if (valoreCasellaCoda.equals("X")) {

            return null;

        } else {

            if (casella == null) {

                return new InfoCasella(-1, -1, tabella, "null");

            } else {

                return casella;

            }


        }

    }

    public InfoCasella getCasellaNaveControllataInNull(int riga, int colonna, String[][] tabella, int direzione, int lunghezza) {

        boolean condizione = true;

        InfoCasella casella = null;

        try {

            casella = getCasellaAdiacente(tabella, riga, colonna, direzione, lunghezza);

        } catch (Exception e) {

            condizione = false;

        }


        if (condizione) {

            return casella;

        } else {

            return null;

        }

    }

    public int prossimaDirezione(int direzione) {

        if (direzione >= 0 && direzione <= 2) {

            direzione++;

        } else {

            direzione = 0;

        }

        return direzione;

    }

    public void posizionaNave(int riga, int colonna, String[][] tabella, int direzione, int lunghezza, String simbolo) {

        for (int i = 0; i < lunghezza; i++) {

            setCasellaSuccessiva(riga, colonna, tabella, direzione, lunghezza, simbolo, i);

        }

    }

    public void setCasellaSuccessiva(int riga, int colonna, String[][] tabella, int direzione, int lunghezza, String simbolo, int i) {

        switch (direzione) {

            case 0:

                tabella[riga - i][colonna] = simbolo;
                break;

            case 1:

                tabella[riga][colonna + i] = simbolo;
                break;

            case 2:

                tabella[riga + i][colonna] = simbolo;
                break;

            case 3:

                tabella[riga][colonna - i] = simbolo;

            default:

        }

    }

}