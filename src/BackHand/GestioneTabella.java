package BackHand;

import javax.swing.*;

public class GestioneTabella {

    public void GestioneTabella(){




    }

    public JTable inizializzazioneTabella(){

        JTable tabella = new JTable(10, 10);

        String stringaVuota = "";

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                tabella.setValueAt(stringaVuota, i, j);

            }

        }


















        return tabella;

    }








}
