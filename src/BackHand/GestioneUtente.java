package BackHand;
import java.util.*;

public class GestioneUtente {
     private String ListY="LIHGFEDCBA";
    Scanner s=new Scanner(System.in);
    public void CoordinateX( int PlayerX){
        if(PlayerX>=10&&PlayerX<=0){
            System.out.println("Errore nell'inserimento della coordinata");
        }
        else if(  PlayerX  ){

        }
    }
    public void CoordinateY(char PlayerY){
        for(int k=0; k<10; k++){
            if( PlayerY==ListY[k]){
                int j=k;
            }
            else{
                System.out.println("Errore nell'inserimento della coordinata Y");
            }

        }}
    public void Fire(JTable t) {
        if (t[PlayerX][j] == ' ') {//t.setValuex
            t[PlayerX][j] = 'O';
        } else if (t[PlayerX][j] == 'X') {
            t[PlayerX][j] = '\033[31;1mX';
        } else if (t[PlayerX][j] == 'O')
            System.out.pritln("Casella già colpita");

        public static void main (String[]args){
        }

    }









}
