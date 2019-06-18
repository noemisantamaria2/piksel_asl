package FrontHand;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

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
            System.out.println("GRAY");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("WHITE")){
            cell.setBackground(Color.WHITE);
            System.out.println("WHITE");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("BLACK")){
            cell.setBackground(Color.BLACK);
            System.out.println("BLACK");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("RED")){
            cell.setBackground(Color.RED);
            System.out.println("RED");
        }
        else if (matriceColori[row][column].equalsIgnoreCase("CYAN")){
            cell.setBackground(Color.CYAN);
            System.out.println("CYAN");
        }

//        contgiri++;
//        System.out.println(contgiri + " | " + row + " | " + column);

        return cell;
    }

}