package BackHand;

import java.util.ArrayList;
import java.util.Random;

public class GestioneUtente extends GestioneTabella{

    Random rand= new Random();
    private int CoordinataX, CoordinataY;

     private String ListY="ABCDEFGHIL";
     private String listY="abcdefghil";
     private Nave naveUtilzzata;

     public GestioneUtente(){

         super();
         naveUtilzzata = null;

     }

    public static void main(String[] args) {

         GestioneUtente g = new GestioneUtente();

         g.attaccoDalComputer();


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




    public void attaccoDalComputer(){


         stampa(MatriceGestione);


        boolean tabellaVuota = true;

        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 11; j++) {

                String valore = MatriceGestione[i][j];

                if(valore != null){

                    if(valore.equals("X")){

                        tabellaVuota = false;

                    }

                }

            }

        }

        System.out.println("La tabella è vuota? " + tabellaVuota);

        if(tabellaVuota){

            if(naveUtilzzata == null){

                //casuale

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

                System.out.println(CoordinataX);
                System.out.println(CoordinataY);

                //finish

            } else {

                //controlla nave

                ArrayList<Casella> caselle = naveUtilzzata.getCaselle();

                boolean naveTrovata = true;

                for (int i = 0; i < naveUtilzzata.getLunghezza(); i++) {

                    int rigaNave = naveUtilzzata.getRiga();
                    int colonnaNave = naveUtilzzata.getColonna();

                    if(MatriceGestione[rigaNave][colonnaNave] != "X"){



                    }





                }










            }












        }






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

