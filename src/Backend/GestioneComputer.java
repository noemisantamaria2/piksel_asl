package Backend;

import java.util.ArrayList;

public class GestioneComputer extends GestioneTabella{

    public GestioneComputer(){

        super();

    }

    public String convertYInChar(int Y){
        String ListY=" ABCDEFGHIL";
        String YChar=ListY.substring(Y,Y+1);
        return YChar;
    }

    public void impostaNaveMatriceGestione(Nave n){

        ArrayList<Casella> caselle = n.getCaselle();

        for (Casella c : caselle) {

            int riga = c.getRiga();
            int colonna = c.getColonna();

            MatriceGestione[riga][colonna] = "T";

        }

    }

}
