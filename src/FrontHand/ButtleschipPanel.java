package FrontHand;
import java.awt.*;
import javax.swing.*;
public class ButtleschipPanel extends JFrame{

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem Nuovapartita, esci;


    public ButtleschipPanel () {
        setTitle("ButtleShip");
        setBounds(100, 100, 660, 403);​
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        Nuovapartita = new JMenuItem("Nuova Prtita");
        esci = new JMenuItem("Esci");
        menu.add(Nuovapartita);
        menu.add(esci);
        contentPane.add(menuBar,BorderLayout.NORTH);
        //ciao

    }

}
