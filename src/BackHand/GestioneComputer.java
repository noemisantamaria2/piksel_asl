package BackHand;
import java.util.*;
    public class GestioneComputer {
    Random rand= new Random();
    private int CoordinataX, CoordinataY;
    private String [][]MatriceGestione;   //Matrice invisibile
    private String [][]MatriceNavi;  //Matrice navi
    private String [][]MatriceDiAttacco= new String[10][10];

    public GestioneComputer(){

    }
    public String convertYInChar(){
        String ListY="LIHGFEDCBA";
        String YChar=ListY.substring(CoordinataY,CoordinataY+1);
        return YChar;
    }
    public int[] mioAttacco(){

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

        int[] xy= new int[2];
        xy[0]=x;
        xy[1]=y;
        return xy;
    }
 /*   public void matrice(){
        for(int i=0; i<5; i++){
            for(int k=0; k<5; k++){
                MatriceDiAttacco[i][k]=" ";
            }
        }
    }*/
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
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
    }
        public void riempimentoMatriceNonVis(){ //Metodo per riempire la Matrice non vista dall'utente
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    MatriceGestione[i][j]=" ";

                }
            }
            for(int i=0; i<10; i++){
                for(int k=0; k<10; k++){
                    MatriceDiAttacco[i][k]=" ";
                }
            }
        }

        public String attaccoDalGiocatore(int x,int Y) { //ok riceve le coordinate e controlla le due matrici
        String Hit="X";
        String NoHit="O";
        String Wrong="XO";
        String SegnoVuoto=" ";
        String SegnoX="X";
        // String SegnoO="O";
        if(MatriceNavi[x][Y].equals(SegnoX)){
            if(MatriceGestione[x][Y].equals(SegnoVuoto)){
                MatriceGestione[x][Y]="X";
                return Hit;
            }else return Wrong;
        }else if(MatriceGestione[x][Y].equals(SegnoVuoto)){
            MatriceGestione[x][Y]="O";
            return NoHit;
        }else return Wrong;
    }
    public boolean controllaVittoriaGiocatore(){                //ok Controlla la matrice non visualizzata e guarda se ci sono 17 X
        String SimboloX="X";
        int Tot=0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(MatriceGestione[i][j].equals(SimboloX)){
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
