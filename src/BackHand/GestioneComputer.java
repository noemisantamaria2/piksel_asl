package BackHand;
import java.util.*;
    public class GestioneComputer extends GestioneTabella{

    Random rand= new Random();
    private int CoordinataX, CoordinataY;

    private String [][]MatriceDiAttacco;

    public GestioneComputer(){

        MatriceDiAttacco = getMatriceVuota();

    }
/*
    public String convertYInChar(){
        String ListY="ABCDEFGHIL";
        String YChar=ListY.substring(CoordinataY,CoordinataY+1);
        return YChar;
    }
*/



    public void mioAttacco(){

        String X = "X";
        String Vuoto = " ";
        int x,y;

        /*

        se il valore precedente è stato una x

        metodo di ricerca

        altrimenti

        casuale

        }




         */



        String valore = MatriceDiAttacco[1][1];


        System.out.println(getValoreStringaVuota(valore));





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




        
        }


    public void stopProcesso(){     //ok
        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
        }
    }

}
