package FrontHand;
import BackHand.Casella;
import BackHand.Nave;

import javax.swing.table.DefaultTableCellRenderer;
//import BackHand.Nave;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelloTabella extends AbstractTableModel {

    private int righeColonne=11;
    private String [][] matrice = new String[righeColonne][righeColonne];
    private String [] headersColumn,headersRow;

    public ModelloTabella(){
        headersColumn= new String[]{"","1","2","3","4","5","6","7","8","9","10"};
        headersRow= new String[]{"","A","B","C","D","E","F","G","H","I","L"};
        this.getColumnName();
        this.getRowName();
    }

    public void getColumnName () {
        for (int i=0;i<righeColonne;i++){
            setValueAt(headersColumn[i],0,i);
        }
    }

    public void getRowName () {
        for (int i=0;i<righeColonne;i++){
            setValueAt(headersRow[i],i,0);
        }
    }

//    public String getRowName (int righe){ return headersRow[righe];}

    @Override
    public int getRowCount() {
        return righeColonne;
    }

    @Override
    public int getColumnCount() {
        return righeColonne;
    }

    public boolean isCellEditable(int righa, int colonna) { return false; }

    public void addNaviGiocatore(String[][] matrice){
        for (int i=1;i<matrice.length;i++){
            for (int j=1;j<matrice[0].length;j++){
                if(matrice[i][j].equalsIgnoreCase("X")){
                    this.setValueAt("N",i,j);
                }
            }
        }
    }

    public void nuovatabella(){
        for (int i=1;i<matrice.length;i++) {
            for (int j = 1; j < matrice[0].length; j++) {
                this.setValueAt("",i,j);
            }
        }
    }

    public boolean addXeO(String contenuto, int righa, int colonna) {
        if((contenuto.equalsIgnoreCase("X"))||(contenuto.equalsIgnoreCase("O"))){
            if (matrice[righa][colonna].equalsIgnoreCase("N") && contenuto.equalsIgnoreCase("X")){
                this.setValueAt(contenuto,righa,colonna);
            }
            else{
                this.setValueAt(contenuto,righa,colonna);
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean affondata (Nave naveReturn){
        if (naveReturn!=null){
            ArrayList caselle = naveReturn.getCaselle();
            for (int i=0;i<naveReturn.getLunghezza();i++){
                Casella casella = (Casella) caselle.get(i);
                this.setValueAt("Y",casella.getRiga(),casella.getColonna());
            }
            return true;
        }
        return false;
    }

    public void setValueAt(String contenuto, int righa, int colonna){
        this.matrice[righa][colonna]=contenuto;
        fireTableCellUpdated(righa, colonna);
    }


    public String getValueAt(int righa, int colonna) {
        return matrice[righa][colonna];
    }
}
