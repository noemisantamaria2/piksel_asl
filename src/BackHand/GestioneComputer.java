package BackHand;
import java.util.*;
    public class GestioneComputer extends GestioneTabella{

    Random rand= new Random();
    private int CoordinataX, CoordinataY;

    private String [][]MatriceDiAttacco = new String[10][10];

    public GestioneComputer(){

        MatriceDiAttacco = getMatriceVuota();

    }

    public String convertYInChar(){
        String ListY="LIHGFEDCBA";
        String YChar=ListY.substring(CoordinataY,CoordinataY+1);
        return YChar;
    }
    public void mioAttacco(){

        String X="X";
        String Vuoto=" ";
        int x,y;
        do {
            setCoordinataY();
            setCoordinataX();
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
                        setCoordinataX();
                        setCoordinataY();
                }
            }
        }while(MatriceDiAttacco[x][y]!="X");

        
        }

    public void setCoordinataX(){
        CoordinataX=rand.nextInt(10);
    }
    public void setCoordinataY(){
        CoordinataY=rand.nextInt(10);
    }
    public int getCoordinataX(){
        return CoordinataX;
    }
    public int getCoordinataY(){
        return CoordinataY;
    }
    public void stopProcesso(){     //ok
        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
        }
    }

}
