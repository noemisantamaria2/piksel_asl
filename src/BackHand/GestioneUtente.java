package BackHand;

import java.util.Random;

public class GestioneUtente extends GestioneTabella{

    Random rand= new Random();
    private int CoordinataX, CoordinataY;

     private String ListY="ABCDEFGHIL";
     private String listY="abcdefghil";

     public GestioneUtente(){
         super();
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

    public String attaccoDalComputer() { //ritorna uno "X" o uno "O"

        MatriceNavi[1][1] = "X";

        stampa(getMatrice());
        stampa(getMatriceGestione());


        boolean matriceVuota = true;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                String casellaSelezionata = MatriceNavi[i][j];

                if(casellaSelezionata.equals("X")){

                    matriceVuota = false;

                }

            }

        }




        System.out.println(matriceVuota);


        if(matriceVuota){


            //int x = this.getCoordinataX();










            /*
            do {

                x=this.getCoordinataX();
                y=this.getCoordinataY();

                if(MatriceDiAttacco[x][y].equals(Vuoto))
                {
                    MatriceDiAttacco[x][y]="X";
                }
                else{
                    if(MatriceDiAttacco[x][y].equals(X)){
                        MatriceDiAttacco[x][y]="O";
                    }else{

                    }
                }
            }while(MatriceDiAttacco[x][y]!="X");

            */







        } else {

            //attacco mirato

        }






        return " ";

    }


    public String aggiornaPosizione(int x, int y){








         return " ";

    }

    public void setCoordinataX(){
        CoordinataX=this.randomWithRange();
    }

    public int randomWithRange()
    {
        int max=11, min=1;
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

