package BackHand;

import javax.swing.*;
import java.util.Calendar;

public class GestioneTabella {

    //todo xDomani: guardare foglio per specifiche. Le navi non si possono posizionare accanto

    public static void main (String [] args){

        GestioneTabella g = new GestioneTabella();

        g.inizializzazioneTabella();

    }


    public String[][]inizializzazioneTabella(){

        String[][]tabella = new String[10][10];

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                tabella[i][j] = "";

            }

        }


        tabella[6][5] = "X";//togliere
        tabella[7][7] = "X";//togliere
        tabella[5][7] = "X";//togliere
        tabella[1][7] = "X";//togliere
        tabella[0][0] = "X";//togliere
        tabella[2][3] = "X";//togliere
        tabella[9][5] = "X";//togliere


        stampa(tabella);//togliere

        //todo gestire il ciclo finche non trova una posizione che gli va bene

        int nRiga = -1;
        int nColonna = -1;
        int direzione = -1;

        do {

            nRiga = (int) (Math.random() * 10);
            nColonna = (int) (Math.random() * 10);
            direzione = (int) (Math.random() * 4);


            //nRiga = 0;//togliere
            //nColonna = 0;//togliere
            //direzione = 1;//togliere


            boolean condizioneNavePosizionabile = controllaPosizioneNave(nRiga, nColonna, 5, direzione, tabella);

            System.out.println("La condizione è " + condizioneNavePosizionabile + " per le coordinate " + nRiga + " " + nColonna + " con direzione " + direzione);//togliere

            if (condizioneNavePosizionabile) {

                posizionaNave(nRiga, nColonna, 5, direzione, tabella);
                break;

            }

        }while(true);

        stampa(tabella);

        return tabella;

    }

    public boolean controllaPosizioneNave(int riga, int colonna, int lunghezza, int direzione, String[][]tabella){

        boolean condizioneNavePosizionabile = true;


        //System.out.print("|");//togliere

        for (int i = 0; i < lunghezza; i++) {

            String valorePosizione = "null";//modificare in ""

            try{

                valorePosizione = getCasellaSuccessiva(riga, colonna, direzione, i, tabella);

            }catch(Exception e){

                condizioneNavePosizionabile = false;
                break;

            }

            if(valorePosizione.equals("X")){

                condizioneNavePosizionabile = false;
                break;

            }

            //System.out.print(valorePosizione + "|");//togliere

        }

        return condizioneNavePosizionabile;

    }

    public String getCasellaSuccessiva(int riga, int colonna, int direzione, int i, String[][]tabella){

        switch (direzione){

            case 0:

                return tabella[riga - i][colonna];

            case 1:

                return tabella[riga][colonna + i];

            case 2:

                return tabella[riga + i][colonna];

            case 3:

                return tabella[riga][colonna - i];

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

        for (int i = 0; i < 10; i++) {

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

}
