package BackHand;

public class GestioneTabella {

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

        tabella[6][5] = "X";//togliere
        tabella[7][7] = "X";//togliere
        tabella[5][7] = "X";//togliere
        tabella[1][7] = "X";//togliere
        tabella[2][3] = "X";//togliere
        tabella[9][5] = "X";//togliere
        tabella[1][2] = "X";//togliere
        tabella[0][0] = "X";//togliere
        tabella[3][4] = "X";//togliere
        tabella[4][5] = "X";//togliere
        tabella[4][3] = "X";//togliere
        tabella[5][4] = "X";//togliere

        stampa(tabella);//togliere

        //todo gestire il ciclo finche non trova una posizione che gli va bene

        int riga = -1;
        int colonna = -1;
        int direzione = -1;

        //do { momentaneo

            riga = (int) (Math.random() * 10);
            colonna = (int) (Math.random() * 10);
            direzione = (int) (Math.random() * 4);


            riga = 9;//togliere
            colonna = 5;//togliere
            direzione = 0;//togliere


            boolean condizioneNavePosizionabile = controllaPosizioneNaveGenerale(new InfoCasella(riga, colonna, tabella, tabella[riga][colonna]), 5, direzione);

            System.out.println("La condizione è " + condizioneNavePosizionabile + " per le coordinate " + riga + " " + colonna + " con direzione " + direzione);//togliere

            /*
            if (condizioneNavePosizionabile) {

                posizionaNave(riga, colonna, 5, direzione, tabella);
                //break;//momentaneo

            }
            */

        //}while(true);//momentaneo

        //stampa(tabella);//togliere

        return tabella;

    }

    public boolean controllaPosizioneNaveGenerale(InfoCasella casellaSelezionata, int lunghezza, int direzione){

        InfoCasella copiaCasellaSelezionata = new InfoCasella(casellaSelezionata.getRiga(), casellaSelezionata.getColonna(), casellaSelezionata.getTabella());




        /*
        boolean condizionePrimaCasellaPosizionabile = true;
        boolean condizioneCasellaCodaPosizionabile = true;

        for (int i = 0; i < 4 && condizionePrimaCasellaPosizionabile; i++) {

            for (int j = 0; j < lunghezza; j++) {

                if(j == 0){



                }

            }

        }
        */









        /*
        boolean condizioneNavePosizionabile = true;

        for (int i = 0; (i < lunghezza) && condizioneNavePosizionabile; i++) {

            String valoreCasellaCheComponeLaNave = "null";//modificare in ""

            try{

                if(i == 0){

                    valoreCasellaCheComponeLaNave = getCasellaInRelazioneAPosizione(casellaCasualeSelezionata, direzione, 0, true).getValore();

                } else {

                    valoreCasellaCheComponeLaNave = getCasellaInRelazioneAPosizione(casellaCasualeSelezionata, direzione, 1, true).getValore();

                }


            }catch(Exception e){

                //condizioneNavePosizionabile = false;//momentaneo
                //break;//momentaneo

            }

            if(valoreCasellaCheComponeLaNave.equals("X")){

                //condizioneNavePosizionabile = false;//momentaneo
                //break;//momentaneo

            }

            System.out.print((i + 1) + ") " + getValoreStringaVuota(valoreCasellaCheComponeLaNave) + " : ");//togliere

            if(i == 0){

                //System.out.print("Si sta lavorando sulla casella iniziale + ");//togliere

                //condizioneNavePosizionabile =
                //controllaCaselleAdiacenti(casellaCasualeSelezionata, 0, true);

            } else {

                //System.out.print("Non si sta lavorando sulla casella iniziale");//togliere

                //condizioneNavePosizionabile =
                //controllaCaselleAdiacenti(casellaCasualeSelezionata, direzione, false);//in progress

            }

            //considerando la prima posizione della nave, se la condizione arrivata fino a qui è true, allora la prima casella va bene




            //System.out.print("La condizione della nave posizionabile è " + condizioneNavePosizionabile);//togliere

            System.out.println();//togliere


        }

        */

        return true;//

    }

    public boolean controllaCaselleAdiacenti(InfoCasella casellaSelezionata, int direzione, boolean selezionePrimaCasella){

        //todo creare nuovo oggetto per metodi

        boolean condizioneCasellaPosizionabile = true;
        int puntoCardinaleDaNonUtilizzare = getPuntoCardinaleOpposto(direzione);

        for (int i = 0; i < 4; i++) {

            if(selezionePrimaCasella || i != puntoCardinaleDaNonUtilizzare){

                String valoreCasellaAdiacente = "null";

                try{

                    valoreCasellaAdiacente = getCasellaInRelazioneAPosizione(casellaSelezionata, i, 1, false).getValore();

                }catch(Exception e){

                    //System.out.println(" + è stato generato errore");//togliere

                }


                if(valoreCasellaAdiacente.equals("X")){

                    //condizioneCasellaPosizionabile = false;//momentaneo
                    //break;//momentaneo

                }

                System.out.print(getValoreStringaVuota(valoreCasellaAdiacente) + ", ");//togliere

            }

        }

        return condizioneCasellaPosizionabile;

    }


    //ritorna le coordinate della casella in coda
    public InfoCasella getCasellaInRelazioneAPosizione(InfoCasella casellaSelezionata, int direzione, int lunghezza, boolean modificaCoordinate){

        String valoreCasellaSelezionata = "";
        String[][]tabella = casellaSelezionata.getTabella();
        int riga =          casellaSelezionata.getRiga();
        int colonna =       casellaSelezionata.getColonna();

        switch (direzione){

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

                //System.out.println("Errore");//togliere

        }

        if(modificaCoordinate){

            casellaSelezionata.setRiga(riga);
            casellaSelezionata.setColonna(colonna);

        }

        casellaSelezionata.setValore(tabella[riga][colonna]);

        return casellaSelezionata;

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

/*
c1 = true;
ccoda = true;

for(int i = 0; i < 4 && c1 == true; i++){

    for(int j = 0; j < lunghezza && c1 == true && ccoda == true; j++ ){

        if(j==0){

            se dopo tutte le condizioni NON funziona{

                c1 = false
                break;

            }

        } else if (j > 0 && metodo == true){

            se dopo tutte le condizioni NON funziona{

                ccoda = false

            }

        } else {

            break;

        }

        if(ccoda == false && c1 == true && giro <= 4){

            ricomincia giro
            giro++;
            => i = 0 e direzione = prossima();

        }

    }

}

*/