package BackHand;

import javax.swing.*;
import java.util.Calendar;

public class GestioneTabella {

    //todo xDomani: guardare cosa dice ultimo todo

    public static void main (String [] args){

        GestioneTabella g = new GestioneTabella();

        g.getMatrice();

    }


    public String[][]getMatrice(){

        String[][]tabella = new String[10][10];

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                tabella[i][j] = "";

            }

        }


        //tabella[6][5] = "X";//togliere
        //tabella[7][7] = "X";//togliere
        //tabella[5][7] = "X";//togliere
        //tabella[1][7] = "X";//togliere
        //tabella[2][3] = "X";//togliere
        //tabella[9][5] = "X";//togliere
        //tabella[1][2] = "X";//togliere
        tabella[0][0] = "X";//togliere
        tabella[3][4] = "X";//togliere
        tabella[4][5] = "X";//togliere
        tabella[4][3] = "X";//togliere
        //tabella[5][4] = "X";//togliere

        stampa(tabella);//togliere

        //todo gestire il ciclo finche non trova una posizione che gli va bene

        int nRiga = -1;
        int nColonna = -1;
        int direzione = -1;

        //do { momentaneo

            nRiga = (int) (Math.random() * 10);
            nColonna = (int) (Math.random() * 10);
            direzione = (int) (Math.random() * 4);


            nRiga = 9;//togliere
            nColonna = 0;//togliere
            direzione = 3;//togliere


            boolean condizioneNavePosizionabile = controllaPosizioneNave(nRiga, nColonna, 5, direzione, tabella);

            System.out.println("La condizione è " + condizioneNavePosizionabile + " per le coordinate " + nRiga + " " + nColonna + " con direzione " + direzione);//togliere

            /*
            if (condizioneNavePosizionabile) {

                posizionaNave(nRiga, nColonna, 5, direzione, tabella);
                //break;//momentaneo

            }
            */

        //}while(true);//momentaneo

        //stampa(tabella);//togliere

        return tabella;

    }

    public boolean controllaPosizioneNave(int riga, int colonna, int lunghezza, int direzione, String[][]tabella){

        boolean condizioneNavePosizionabile = true;

        for (int i = 0; (i < lunghezza) && condizioneNavePosizionabile; i++) {

            String valorePosizione = "null";//modificare in ""

            try{

                valorePosizione = getCasellaInRelazioneAPosizione(riga, colonna, direzione, i, tabella);

            }catch(Exception e){

                //condizioneNavePosizionabile = false;//momentaneo
                //break;//momentaneo

            }

            if(valorePosizione.equals("X")){

                //condizioneNavePosizionabile = false;//momentaneo
                //break;//momentaneo

            }

            System.out.print((i + 1) + ") " + getValoreStringaVuota(valorePosizione) + " : ");//togliere

            if(i == 0){

                //System.out.print("Si sta lavorando sulla casella iniziale + ");//togliere

                condizioneNavePosizionabile = controllaCaselleAdiacenti(riga, colonna, tabella, 0, true);

            } else {

                //System.out.print("Non si sta lavorando sulla casella iniziale");//togliere

                //todo aggiornare la riga e la colonna con una quella aggiornata



                controllaCaselleAdiacenti(riga, colonna, tabella, direzione, false);

            }

            //System.out.print("La condizione della nave posizionabile è " + condizioneNavePosizionabile);//togliere

            System.out.println();//togliere


        }

        return condizioneNavePosizionabile;

    }

    public boolean controllaCaselleAdiacenti(int riga, int colonna, String[][]tabella, int direzione, boolean selezionePrimaCasella){

        boolean condizioneCasellaPosizionabile = true;
        int puntoCardinaleDaNonUtilizzare = getPuntoCardinaleOpposto(direzione);

        for (int i = 0; i < 4; i++) {

            if(selezionePrimaCasella || i != puntoCardinaleDaNonUtilizzare){

                String valoreCasellaSelezionata = "null";

                try{

                    valoreCasellaSelezionata = getCasellaInRelazioneAPosizione(riga, colonna, i, 1, tabella);

                }catch(Exception e){

                    //System.out.println(" + è stato generato errore");//togliere

                }


                if(valoreCasellaSelezionata.equals("X")){

                    //condizioneCasellaPosizionabile = false;//momentaneo
                    //break;//momentaneo

                }

                System.out.print(getValoreStringaVuota(valoreCasellaSelezionata) + ", ");//togliere

            }

        }

        return condizioneCasellaPosizionabile;

    }

    public String getCasellaInRelazioneAPosizione(int riga, int colonna, int direzione, int lunghezza, String[][]tabella){

        switch (direzione){

            case 0:

                return tabella[riga - lunghezza][colonna];

            case 1:

                return tabella[riga][colonna + lunghezza];

            case 2:

                return tabella[riga + lunghezza][colonna];

            case 3:

                return tabella[riga][colonna - lunghezza];

            default:

                System.out.println("Errore");//togliere
                return "errore";

        }

    }


    public void posizionaNave(int riga, int colonna, int lunghezza, int direzione, String[][]tabella){

        for (int i = 0; i < lunghezza; i++) {

            setCasellaSuccessiva(riga, colonna, direzione, i, tabella, "X");

        }

    }

    public void setCasellaSuccessiva(int riga, int colonna, int direzione, int i, String[][]tabella, String simbolo){

        switch (direzione){

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
                break;

            default:

                System.out.println("Errore");//togliere

        }

    }


    public void stampa(String[][]t){ //metodo da togliere

        System.out.println("\\ 0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {

            System.out.print(i + "|");

            for (int j = 0; j < 10; j++) {

                String valore = t[i][j];

                if(valore.isEmpty()){

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

    public String getValoreStringaVuota(String valore){//metodo da togliere

        if(valore == null){



        }

        if(valore.isEmpty()){

            return "/";

        } else {

            return valore;

        }

    }

    public int getPuntoCardinaleOpposto(int puntoCardinale){

        switch(puntoCardinale){

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




}
