import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProvaTabella extends JFrame{

    private String [][] matriceColori = new String [11][11];
    private  CustomTableCellRenderer personalizzato;
    private Modello modello;
    private  JTable tabella;
    JFrame finestra = this;

    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ProvaTabella frame = new ProvaTabella();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProvaTabella () {
        setTitle("ciao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,720);
        JPanel contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(250,500,250,500));
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        modello = new Modello();
        tabella = new JTable(modello);
//        tabella.setBorder(new EmptyBorder(250,500,250,500));



        this.costruisciMatriceColori();
        if(!this.inserisciColoreInMatrice("RED",1,1)){
            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
        }
        if(!this.inserisciColoreInMatrice("RED",0,0)){
            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
        }
        if(!this.inserisciColoreInMatrice("BLACK",5,5)){
            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
        }
        if(!this.inserisciColoreInMatrice("CYAN",3,3)){
            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
        }
        if(!this.inserisciColoreInMatrice("BLACK",7,7)){
            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
        }
        if(!this.inserisciColoreInMatrice("RED",7,7)){
            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
        }

        personalizzato = new CustomTableCellRenderer(matriceColori);
//        tabella.setDefaultRenderer(Object.class, new CustomTableCellRenderer(matriceColori));
        tabella.setDefaultRenderer(Object.class, personalizzato);

        this.printMatriceColori();

        modello.nuovatabella();
        tabella.setFillsViewportHeight(true);
        tabella.setVisible(true);
        contentPane.add(tabella,BorderLayout.CENTER);

//        if(!this.inserisciColoreInMatrice("RED",10,10)){
//            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
//        }
//        if(!this.inserisciColoreInMatrice("RED",10,0)){
//            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
//        }
//        if(!this.inserisciColoreInMatrice("BLACK",5,8)){
//            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
//        }
//        if(!this.inserisciColoreInMatrice("CYAN",9,3)){
//            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
//        }
//        if(!this.inserisciColoreInMatrice("BLACK",7,4)){
//            JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
//        }
//        if(!this.inserisciColoreInMatrice("RED",5,7))
//            JOptionPane.showMessageDialog(finestra, JOptionPane.WARNING_MESSAGE);
//
////        tabella.setDefaultRenderer(Object.class, new CustomTableCellRenderer(matriceColori));
//
////                tabella = new JTable(modello);
//        personalizzato = new CustomTableCellRenderer(matriceColori);
//        tabella.setDefaultRenderer(Object.class, personalizzato);



        JButton bottone = new JButton("OK");
        contentPane.add(bottone,BorderLayout.SOUTH);
        bottone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProvaTabella prov = new ProvaTabella();
                if(!prov.inserisciColoreInMatrice("RED",10,10)){
                    JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
                }
                if(!prov.inserisciColoreInMatrice("RED",10,0)){
                    JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
                }
                if(!prov.inserisciColoreInMatrice("BLACK",5,8)){
                    JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
                }
                if(!prov.inserisciColoreInMatrice("CYAN",9,3)){
                    JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
                }
                if(!prov.inserisciColoreInMatrice("BLACK",7,4)){
                    JOptionPane.showMessageDialog(finestra,JOptionPane.WARNING_MESSAGE);
                }
                if(!prov.inserisciColoreInMatrice("RED",5,7))
                    JOptionPane.showMessageDialog(finestra, JOptionPane.WARNING_MESSAGE);

//        tabella.setDefaultRenderer(Object.class, new CustomTableCellRenderer(matriceColori));

//                tabella = new JTable(modello);
                personalizzato = new CustomTableCellRenderer(matriceColori);
                prov.printMatriceColori();
                tabella.setDefaultRenderer(Object.class, personalizzato);
                System.out.println("#############");
                prov.printMatriceColori();



            }

        });



    }



    public void printMatriceColori(){
        for (int i=0;i<matriceColori.length;i++){
            for (int j=0;j<matriceColori[0].length;j++){
                System.out.print(matriceColori[i][j] + " | ");
            }
            System.out.println();
        }

    }





    public String [][] costruisciMatriceColori(){
        for (int i=0;i<matriceColori.length;i++){
            for (int j=0;j<matriceColori[0].length;j++){
                if (i==0 || j==0){
                    matriceColori[i][j] = "GRAY";
                }
                else{
                    matriceColori[i][j] = "WHITE";
                }
            }
        }
        return matriceColori;
    }

    public boolean inserisciColoreInMatrice (String colore, int riga, int colonna) {
        if (!colore.equalsIgnoreCase("RED")){
            if (matriceColori[riga][colonna].equalsIgnoreCase("WHITE")) {
                matriceColori[riga][colonna] = colore;
                System.out.println("true non rosso");
                return true;
            }else {
                System.out.println("false non rosso");
                return false;
            }
        }
        else {
            if (matriceColori[riga][colonna].equalsIgnoreCase("BLACK")) {
                matriceColori[riga][colonna] = colore;
                System.out.println("true rosso");
                return true;
            }else {
                System.out.println("false rosso");
                return false;
            }
        }
    }

}


 class Modello extends AbstractTableModel{

    private int righeColonne=11;
//    private Component [][] matrice = new Component[][][righeColonne][righeColonne];
    private String [][] matrice = new String[righeColonne][righeColonne];
    private String [] headersColumn,headersRow;

    public Modello(){
            headersColumn= new String[]{"","1","2","3","4","5","6","7","8","9","10"};
            headersRow= new String[]{"","L","I","H","G","F","E","D","C","B","A"};
            this.setColumnName();
            this.setRowName();
        }

    public void setColumnName () {
        for (int i=0;i<righeColonne;i++){
            setValueAt(headersColumn[i],0,i);
        }
    }

    public void setRowName () {
        for (int i=0;i<righeColonne;i++){
            setValueAt(headersRow[i],i,0);
        }
    }

    public String getColumnName (int colonna) {
        return headersColumn[colonna];
    }

    public String getRowName (int riga) {
        return headersRow[riga];
    }

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
                    this.setValueAt(matrice[i][j],i,j);
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
            this.setValueAt(contenuto,righa,colonna);
            return true;
        }else{
            return false;
        }
    }

    public void setValueAt(String contenuto, int righa, int colonna){
        this.matrice[righa][colonna]=contenuto;
//        this.matrice[righa][colonna].setText
        fireTableCellUpdated(righa, colonna);
    }

    public String getValueAt(int righa, int colonna) {
        return matrice[righa][colonna];
    }

//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//
//        Component cell = new Component();
//        Modello modello = new Modello();
//
//        if(row >0&&column>0){
//            setBackground(Color.GREEN);
//        }
//
////        if (column==0 && row==1){
////            setBackground(Color.GRAY);
////            setText(modello.getRowName(1));
////        }
//
////        setForeground(Color.BLACK);
//
//        return this;
//    }

}

 class CustomTableCellRenderer extends DefaultTableCellRenderer {

    private int contgiri;
    private String [][] matriceColori = new String[11][11];

     public CustomTableCellRenderer (String [][] matriceColori){
        super();
        this.matriceColori = matriceColori;
     }

    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell;
        cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

        if (matriceColori[row][column].equalsIgnoreCase("GRAY")){
            cell.setBackground(Color.LIGHT_GRAY);
//            System.out.println("GRAY");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("WHITE")){
            cell.setBackground(Color.WHITE);
//            System.out.println("WHITE");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("BLACK")){
            cell.setBackground(Color.BLACK);
//            System.out.println("BLACK");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("RED")){
            cell.setBackground(Color.RED);
//            System.out.println("RED");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("CYAN")){
            cell.setBackground(Color.CYAN);
//            System.out.println("CYAN");
        }

//        contgiri++;
//        System.out.println(contgiri + " | " + row + " | " + column);

         return cell;
     }

}
