package BackHand;

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

