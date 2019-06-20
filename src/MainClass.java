/*import Backend.GestioneComputer;
import Backend.GestioneUtente;
import Backend.GestioneUtente.*;
import java.util.*;

public class MainClass {

    public static void main (String[]args){
        //toDo dobbiamo aprire la finestra
        Scanner s=new Scanner(System.in);
        int columns = 2;
        int x,y;
        String o;
        int rows = 2;
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
        o=s.next();
        GestioneUtente g=new GestioneUtente(newArray);
        boolean l=g.ControlloX(x);
        System.out.println(" X: "+l);
        boolean t=g.ControlloY(o);
        System.out.println(" y: "+t);
        int q=g.ConvertitoreY(o);
        System.out.println("YConvert: "+q);
        boolean f=g.ControlloCoordinate(x,o);
        System.out.println(" Wow: "+f);
        y=s.nextInt();
        g.RiempimentoMatriceNonVis();
        g.StampA();
        System.out.println("-------------------------");
        g.StampB();
        System.out.println("-------------------------");

        String att=null;
        att=g.attaccoDalComputer(x,y);
        System.out.println(" "+att);
        System.out.println("-------------------------");
        g.StampA();
        System.out.println("-------------------------");
        g.StampB();
        System.out.println("-------------------------");
        att=g.attaccoDalComputer(x,y);
        System.out.println(" "+att);
        System.out.println("-------------------------");
        boolean z= g.controllaVittoriaComputer();
        System.out.println(" " +z);


        GestioneComputer lo=new GestioneComputer();

        lo.riempimentoMatriceNonVis();
        int []f= new int[2];
        for(int k=0; k<25; k++) {
            f = lo.mioAttacco();
            System.out.println(lo.getCoordinataX());
            System.out.println(lo.getCoordinataY());
            System.out.println("----------------"+k);
            lo.stopProcesso();
        }
    }

}
*/

import Frontend.Battaglianavale;

import java.awt.*;

public class MainClass {
    public static void main (String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Battaglianavale frame = new Battaglianavale();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
