/*package FrontHand;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import FrontEnd.PannelloUtente;
import BackEnd.GestioneTabella;

public class Battaglianavale extends JFrame{

    public static void main(String args[]){
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

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem Nuovapartita, esci;
    private JPanel contentPane, pannelloComputer, pannelloGiocatore;
    private JTable tablellaComputer, tabellaGiocatore;
    private JLabel giocatore;

    public Battaglianavale () {
        setTitle("BattleShip");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,500,500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        menuBar = new JMenuBar();
        contentPane.add(menuBar,BorderLayout.NORTH);

        menu = new JMenu("File");
        menuBar.add(menu);

        Nuovapartita = new JMenuItem("Nuova Prtita");
        Nuovapartita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PannelloUtente finestraUtente = new PannelloUtente();
                finestraUtente.setVisible(true);
                //pannelloComputer.setVisible(true);
                //pannelloGiocatore.setVisible(true);
                System.out.println("si funziona!");

            }
        });
        menu.add(Nuovapartita);

        esci = new JMenuItem("Esci");
        esci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pannelloComputer.setVisible(false);
                //pannelloGiocatore.setVisible(false);
            }
        });
        menu.add(esci);

        pannelloGiocatore = new JPanel();
        pannelloGiocatore.setVisible(false);
        contentPane.add(pannelloGiocatore,BorderLayout.WEST);

        giocatore = new Jlabel();
        giocatore.setEnabled(false);
        giocatore.setBackground(null);
        giocatore.setText(PannelloUtente.getNuomeUtente());
        pannelloGiocatore.add(giocatore);

        tabellaGiocatore = GestioneTablella.inizializzazioneTabella();
        pannelloGiocatore.add(tabellaGiocatore);

        pannelloComputer = new JPanel();
        pannelloComputer.setVisible(false);
        contentPane.add(pannelloComputer,BorderLayout.WEST);

        tablellaComputer = GestioneTablella.inizializzazioneTabella();
        pannelloGiocatore.add(tablellaComputer);






    }


}*/
