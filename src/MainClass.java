<<<<<<< master
import FrontHand.Battaglianavale;

=======
import BackHand.GestioneUtente;
import BackHand.GestioneUtente.*;
import java.util.*;
>>>>>>> Ticket #5: Aggiornamento dei metodi e prova
public class MainClass {

    public static void main (String[]args){
        //toDo dobbiamo aprire la finestra
        Scanner s=new Scanner(System.in);
        int columns = 10;
        int x,y;
        String o;
        int rows = 10;
        String[][] newArray = new String[columns][rows];
        newArray[0][0] = "X";
        newArray[0][1] = " ";

        newArray[1][0] = "X";
        newArray[1][1] = " ";
        String[][] ArrayA = new String[columns][rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.println(newArray[i][j]);

            }
        }
        System.out.println("Insert x: ");
        x=s.nextInt();
        System.out.println("Insert y: ");
        y=s.nextInt();
        System.out.println("Insert o: ");
        o=s.next();
        GestioneUtente g=new GestioneUtente();
    }
}
