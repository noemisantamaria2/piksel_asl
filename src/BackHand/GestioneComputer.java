package BackHand;
import java.util.*;
    public class GestioneComputer {
    Random rand= new Random();
    private int CoordinataX, CoordinataY=rand.nextInt(10);
    private String [][]MatriceLogica;
    private String [][]MatriceVista;
    public GestioneComputer(){

    }
    public String convertYInChar(){
        String ListY="LIHGFEDCBA";
        String YChar=ListY.substring(CoordinataY,CoordinataY+1);
        return YChar;
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
    public String attaccoDalGiocatore(int x,int Y) { //ok riceve le coordinate e controlla le due matrici
        String Hit="X";
        String NoHit="O";
        String Wrong="XO";
        String SegnoVuoto=" ";
        String SegnoX="X";
        // String SegnoO="O";
        if(MatriceVista[x][Y].equals(SegnoX)){
            if(MatriceLogica[x][Y].equals(SegnoVuoto)){
                MatriceLogica[x][Y]="X";
                return Hit;
            }else return Wrong;
        }else if(MatriceLogica[x][Y].equals(SegnoVuoto)){
            MatriceLogica[x][Y]="O";
            return NoHit;
        }else return Wrong;
    }
    public boolean controllaVittoriaGiocatore(){                //ok Controlla la matrice non visualizzata e guarda se ci sono 17 X
        String SimboloX="X";
        int Tot=0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(MatriceLogica[i][j].equals(SimboloX)){
                    Tot++;
                }
            }
        }
        if(Tot==17) {
            return true;
        }
        else return false;
    }
}
