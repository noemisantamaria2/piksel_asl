package Backend;

import java.util.ArrayList;
import java.util.Random;

public class GestioneUtente extends GestioneTabella{

    private Random rand= new Random();
    private int CoordinataX;
    private int CoordinataY;

    private String ListY="ABCDEFGHIL";
    private String listY="abcdefghil";
    private Nave naveUtilzzata;

    public GestioneUtente(){

        super();
        naveUtilzzata = null;
        CoordinataX = -1;
        CoordinataY = -1;

    }


    public static void main(String[] args) {

        GestioneUtente g = new GestioneUtente();

        g.stampa(g.getMatrice());
        g.stampa(g.getMatriceGestione());

        g.naveTrovata();

        g.attaccoDalComputer();

        g.attacco(g.getCoordinataX(), g.getCoordinataY());

        g.stampa(g.getMatriceGestione());


    }

    public boolean controlloX(int X){          //ok Controllo coordinata x
        if(X<11&&X>0){
            return true;
        }
        else return false;
    }
    public boolean controlloY(String Y){         //ok Controllo coordinata y
        int YCorrect=ListY.indexOf(Y);
        if(YCorrect<10&&YCorrect>-1) {
            return true;
        }else {
            int ycorrect=listY.indexOf(Y);
            if(ycorrect<10&&ycorrect>-1)
            {
                return true;
            }else return false;
        }
    }
    public int convertitoreY(String Y){         //ok Converte la lettera in numero
        int YConvert=ListY.indexOf(Y);
        if(YConvert<10&&YConvert>-1){
            return YConvert+1;
        }
        else{
            int yconvert=listY.indexOf(Y);
            if(yconvert<10&&yconvert>-1){
                return yconvert+1;
            }
        }
        return -1;
    }
    public boolean controlloCoordinate(int x, String Y){  //ok Controllo la correttezza di entrambe le coordinate

        boolean CheckX=this.controlloX(x);
        boolean CheckY=this.controlloY(Y);
        if(CheckX==true){
            if (CheckY == true) {
                return true;
            }
            else return false;
        }
        else return false;
    }

    public Casella attaccoDalComputer(){

        Casella casellaAdiacente = null;
        boolean casellaCorretta = false;

        for (int i = 1; i < MatriceGestione.length && !casellaCorretta; i++) {

            for (int j = 1; j < MatriceGestione[i].length && !casellaCorretta; j++) {

                String valore = MatriceGestione[i][j];

                if(valore.equals("X")){

                    int direzione = (int)(Math.random()*4);

                    for (int k = 0; k < 4 && !casellaCorretta; k++) {

                        casellaCorretta = false;
                        casellaAdiacente = null;

                        try{

                            casellaAdiacente = getCasellaAdiacente(MatriceGestione, i, j, k, 1);

                        }catch(Exception e){

                        }


                        if(casellaAdiacente != null){

                            if(casellaAdiacente.getValore() != null){

                                if(casellaAdiacente.getValore().equals(" ")){

                                    casellaCorretta = true;

                                }

                            }

                        }

                        if(casellaCorretta){

                            break;

                        } else {

                            direzione = prossimaDirezione(direzione);

                        }

                    }


                }

                if(casellaCorretta){

                    break;

                }

            }

            if(casellaCorretta){

                break;

            }

        }

        //va a

        if(casellaAdiacente == null){

            do{

                setCoordinataX();
                setCoordinataY();

                String valoreCasuale = MatriceGestione[CoordinataX][CoordinataY];

                if(valoreCasuale != null){

                    if(valoreCasuale == " "){

                        break;

                    }

                }

            }while(true);

            return new Casella(CoordinataX, CoordinataY, MatriceGestione, " ");

        } else {

            return casellaAdiacente;

        }

    }

    public void impostaNaveMatriceGestione(Nave n){

        ArrayList<Casella> caselle = n.getCaselle();


        for (int i = 0; i < caselle.size(); i++) {

            Casella c = caselle.get(i);

            int riga = c.getRiga();
            int colonna = c.getColonna();
            int direzione = n.getDirezione();

            MatriceGestione[riga][colonna] = "T";

            if(i == 0){

                for (int j = 0; j < 4; j++) {

                    if(j != direzione){

                        Casella casellaAdiacente = getCasellaAdiacenteEsistenteNoNull(MatriceGestione, riga, colonna, j);

                        if(casellaAdiacente != null){

                            int rigaCasellaAdiacente = casellaAdiacente.getRiga();
                            int colonnaCasellaAdiacente = casellaAdiacente.getColonna();

                            MatriceGestione[rigaCasellaAdiacente][colonnaCasellaAdiacente] = "O";

                        }

                    }

                }

            } else if(i == (caselle.size() - 1)){

                int nuovaDirezione = getPuntoCardinaleOpposto(direzione);

                for (int j = 0; j < 4; j++) {

                    if(j != nuovaDirezione){

                        Casella casellaAdiacente = getCasellaAdiacenteEsistenteNoNull(MatriceGestione, riga, colonna, j);

                        if(casellaAdiacente != null){

                            int rigaCasellaAdiacente = casellaAdiacente.getRiga();
                            int colonnaCasellaAdiacente = casellaAdiacente.getColonna();

                            MatriceGestione[rigaCasellaAdiacente][colonnaCasellaAdiacente] = "O";

                        }

                    }

                }

            } else {

                int nuovaDirezione = getPuntoCardinaleOpposto(direzione);

                for (int j = 0; j < 4; j++) {

                    if(j != direzione && j != nuovaDirezione){

                        Casella casellaAdiacente = getCasellaAdiacenteEsistenteNoNull(MatriceGestione, riga, colonna, j);

                        if(casellaAdiacente != null){

                            int rigaCasellaAdiacente = casellaAdiacente.getRiga();
                            int colonnaCasellaAdiacente = casellaAdiacente.getColonna();

                            MatriceGestione[rigaCasellaAdiacente][colonnaCasellaAdiacente] = "O";

                        }

                    }

                }

            }

        }


    }

    public Casella getCasellaAdiacenteEsistenteNoNull(String[][] tabella, int riga, int colonna, int direzione){

        Casella c = null;
        boolean casellaDisponibile = true;

        try{

            c = getCasellaAdiacente(tabella, riga, colonna, direzione, 1);

        }catch (Exception e){

            casellaDisponibile = false;

        }

        if(casellaDisponibile){

            if(c != null){

                int rigaCasellaAdiacente = c.getRiga();
                int colonnaCasellaAdiacente = c.getColonna();

                MatriceGestione[rigaCasellaAdiacente][colonnaCasellaAdiacente] = "O";

            }

        }

        return c;

    }


    public void setCoordinataX(){
        CoordinataX=this.randomWithRange();
    }

    public int randomWithRange()
    {
        int max=10, min=1;
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }


    public void setCoordinataY(){

        CoordinataY=this.randomWithRange();
    }
    public int getCoordinataX(){
        return CoordinataX;
    }
    public int getCoordinataY(){
        return CoordinataY;
    }

    public String convertYInChar() {
        String ListY = "ZABCDEFGHIL";
        String YChar = ListY.substring(CoordinataY, CoordinataY + 1);
        return YChar;
    }

}

