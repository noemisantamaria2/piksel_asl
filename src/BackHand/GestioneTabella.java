package BackHand;

import java.util.ArrayList;

public class GestioneTabella {

    protected String [][]MatriceNavi;      //Matrice contenente navi
    protected String [][]MatriceGestione;      //Matrice che gestisce gli attacchi
    protected ArrayList<Nave> navi;



    public GestioneTabella(){

        navi = new ArrayList<Nave>();
        MatriceNavi = inizializzaMatrice();
        MatriceGestione = getMatriceVuota(11);
        stampa(MatriceNavi);

    }

    public void stopProcesso(){     //ok
        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
        }
    }

    public Nave naveTrovata(){

        Nave naveReturn = null;


        for (Nave n : navi) {

            ArrayList<Casella> caselle = n.getCaselle();


            boolean naveRiempita = true;

            for(Casella c : caselle){

                int riga = c.getRiga();
                int colonna = c.getColonna();

                if(MatriceGestione[riga][colonna].equals(" ") || MatriceGestione[riga][colonna].equals("T")){

                    //System.out.println("riga /" + riga + "/ colonna: /" + colonna + "/");

                    naveRiempita = false;
                    break;

                }

            }
            if(naveRiempita){

                naveReturn = n;

                impostaNaveMatriceGestione(n);

                break;

            }

        }

        stampa(MatriceGestione);

        return naveReturn;

    }

    public void impostaNaveMatriceGestione(Nave n){

        System.out.println("Sei in gestioneTabella!");

    }

    public boolean controllaVittoria(){ //ok Controlla la matrice non visualizzata e guarda se ci sono 17 X
        String SimboloX="T";
        int Tot=0;
        for(int i=1; i<11; i++){
            for(int j=1; j<11; j++){
                if(MatriceGestione[i][j].equals(SimboloX)){
                    Tot++;
                }
            }
        }
        if(Tot==17) {
            return true;
        }
        else return false;
    }

    public String attacco(int x,int Y) { //ok riceve le coordinate e controlla le due matrici
        String Hit="X";
        String NoHit="O";
        String Wrong="XO";
        String SegnoVuoto=" ";
        String SegnoX="X";
        // String SegnoO="O";
        if(MatriceNavi[x][Y].equals(SegnoX)){
            if(MatriceGestione[x][Y].equals(SegnoVuoto)){
                MatriceGestione[x][Y]="X";
                return Hit;
            }else return Wrong;
        }else if(MatriceGestione[x][Y].equals(SegnoVuoto)){
            MatriceGestione[x][Y]="O";
            return NoHit;
        }else return Wrong;
    }


    public String[][]getMatrice(){

        return MatriceNavi;

    }


    public String[][]getMatriceGestione(){

        return MatriceGestione;

    }


    public String[][]getMatriceVuota(int lunghezza){

        String[][] tabella = new String[lunghezza][lunghezza];

        if(lunghezza == 10){

            for (int i = 0; i < lunghezza; i++) {

                for (int j = 0; j < lunghezza; j++) {

                    tabella[i][j] = " ";

                }

            }


        } else if(lunghezza == 11){

            for (int i = 0; i < lunghezza; i++) {

                if(i == 0){

                    for (int j = 0; j < 11; j++) {

                        tabella[i][j] = null;

                    }

                } else if(i > 0){

                    for (int j = 0; j < lunghezza; j++) {

                        if(j == 0){

                            tabella[i][j] = null;

                        } else {

                            tabella[i][j] = " ";

                        }

                    }

                }

            }

        }

        return tabella;

    }

    public String[][] inizializzaMatrice() {

        String[][] tabella = getMatriceVuota(10);

        int[] lunghezze = {5, 4, 3, 3, 2};


        for (int i = 0; i < lunghezze.length; i++) {

            Nave nave = ricercaPosizionePerNave(tabella, lunghezze[i]);

            int riga = nave.getRiga();
            int colonna = nave.getColonna();
            int direzione = nave.getDirezione();

            ArrayList<Casella> caselle = posizionaNave(riga, colonna, tabella, direzione, lunghezze[i]);

            nave.setCaselle(caselle);

            navi.add(nave);

        }

        String[][] tabellaNuova = getMatriceVuota(11);

        for (int i = 0; i < tabella.length; i++) {

            for (int j = 0; j < tabella[i].length; j++) {

                tabellaNuova[i + 1][j + 1] = tabella[i][j];

            }

        }



        return tabellaNuova;

    }

    public Nave ricercaPosizionePerNave(String[][] tabella, int lunghezza) {

        boolean navePosizionabile = false;

        int riga = -1;
        int colonna = -1;
        int direzione = -1;

        do {

            navePosizionabile = false;

            boolean primaCasellaPosizionabile = true;

            riga = (int) (Math.random() * 10);
            colonna = (int) (Math.random() * 10);
            direzione = (int) (Math.random() * 4);

            primaCasellaPosizionabile = controllaCasellaNave(riga, colonna, tabella, 0, 0, true);

            for (int i = 0; i < 4 && primaCasellaPosizionabile && !navePosizionabile; i++) {

                for (int j = 1; j < lunghezza; j++) {

                    navePosizionabile = controllaCasellaNave(riga, colonna, tabella, direzione, j, false);

                    if (!navePosizionabile) {

                        break;

                    }

                }

                if (!navePosizionabile) {

                    direzione = prossimaDirezione(direzione);

                }

            }

        } while (!navePosizionabile);

        return new Nave(riga, colonna, direzione, lunghezza);

    }

    public boolean controllaCasellaNave(int riga, int colonna, String[][] tabella, int direzione, int distanzaDallaPrima, boolean condizionePrimaCasella) {

        boolean condizione = true;

        Casella casellaNave = null;

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

            for (int i = 0; i < 4; i++) {

                if (!condizionePrimaCasella && i != direzioneOpposta || condizionePrimaCasella) {

                    Casella casellaAdiacente = getCasellaNaveControllataInX(rigaCasellaNave, colonnaCasellaNave, tabella, i, 1);

                    if (casellaAdiacente == null) {

                        condizione = false;
                        break;

                    } else {

                        int rigaCasellaAdiacente = casellaAdiacente.getRiga();
                        int colonnaCasellaAdiacente = casellaAdiacente.getColonna();
                        String valoreCasellaAdiacente = casellaAdiacente.getValore();

                    }

                }

            }

        }

        return condizione;

    }

    public Casella getCasellaAdiacente(String[][] tabella, int riga, int colonna, int direzione, int lunghezza) {


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

        return (new Casella(riga, colonna, tabella, tabella[riga][colonna]));

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

    public void stampa(String[][] tabella) { //metodo da togliere


        for (int i = 0; i < tabella.length; i++) {

            if(i == 0){

                System.out.println("\\ 0 1 2 3 4 5 6 7 8 9");

            } else {

                for (int j = 0; j < tabella[i].length; j++) {

                    if(j == 0){

                        System.out.print(i - 1);

                    } else {

                        System.out.print(tabella[i][j]);

                    }

                    System.out.print("|");

                }

                System.out.println();

            }









        }






    }

    public String getValoreStringaVuota(String valore) {//metodo da togliere

        if (valore == " ") {

            return " ";

        } else {

            return valore;

        }

    }

    public Casella getCasellaNaveControllataInXeNull(int riga, int colonna, String[][] tabella, int direzione, int lunghezza) {

        boolean condizione = true;

        Casella casella = null;
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

    public Casella getCasellaNaveControllataInX(int riga, int colonna, String[][] tabella, int direzione, int lunghezza) {

        boolean condizione = true;
        Casella casella = null;
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

                return new Casella(-1, -1, tabella, "null");

            } else {

                return casella;

            }


        }

    }

    public Casella getCasellaNaveControllataInNull(int riga, int colonna, String[][] tabella, int direzione, int lunghezza) {

        boolean condizione = true;

        Casella casella = null;

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

    public ArrayList<Casella> posizionaNave(int riga, int colonna, String[][] tabella, int direzione, int lunghezza) {



        ArrayList<Casella> caselle = new ArrayList<Casella>();

        for (int i = 0; i < lunghezza; i++) {

            Casella casella = setCasellaSuccessiva(riga, colonna, tabella, direzione, lunghezza, i);



            caselle.add(casella);

        }

        return caselle;

    }

    public Casella setCasellaSuccessiva(int riga, int colonna, String[][] tabella, int direzione, int lunghezza, int i) {

        switch (direzione) {

            case 0:

                riga -= i;
                break;

            case 1:

                colonna += i;
                break;

            case 2:

                riga += i;
                break;

            case 3:

                colonna -= i;

            default:

        }

        tabella[riga][colonna] = "X";
        return new Casella(riga + 1, colonna + 1, tabella, "X");

    }

}