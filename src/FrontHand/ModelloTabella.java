package FrontHand;

import javax.swing.table.AbstractTableModel;

public class ModelloTabella extends AbstractTableModel {

    private int righeColonne=10;
    private String [][] matrice = new String[righeColonne][righeColonne];

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
        for (int i=0;i<matrice.length;i++){
            for (int j=0;j<matrice[0].length;j++){
                if(matrice[i][j].equalsIgnoreCase("X")){
                    this.setValueAt(matrice[i][j],i,j);
                }
            }
        }
    }

    public void nuovatabella(){
        for (int i=0;i<matrice.length;i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                this.setValueAt("",i,j);
            }
        }
    }

    public boolean addXeO(String contenuto, int righa, int colonna) {
        if((contenuto.equalsIgnoreCase("X"))||(contenuto.equalsIgnoreCase("O"))){
            this.setValueAt(contenuto,righa,colonna);
            return true;
        }else{
            return false;
        }
    }

    public void setValueAt(String contenuto, int righa, int colonna){
        this.matrice[righa][colonna]=contenuto;
        fireTableCellUpdated(righa, colonna);
    }

    public String getValueAt(int righa, int colonna) {
        return matrice[righa][colonna];
    }
}
