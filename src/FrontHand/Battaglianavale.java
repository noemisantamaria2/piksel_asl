
import sun.misc.JarIndex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
//import FrontEnd.PannelloUtente;
//import BackEnd.GestioneUtente;
//import BackEnd.GestioneComputer;

public class Battaglianavale extends JFrame {

    public static void main(String args[]) {
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

    private String nomeUtente;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem Nuovapartita, esci;
    private JPanel contentPane, pannelloComputer, pannelloGiocatore;
    private JTable tablellaComputer, tabellaGiocatore;
    private JLabel giocatoreX, giocatoreY;
    private JLabel computerX, computerY;
    private JLabel giocatore;
    private JLabel computer;
    private JLabel coordinateGiocatore;
    private JLabel coordinateComputer;
    private JButton bottoneFuoco;
    private JTextField giocatoreCoordinataX, giocatoreCoordinataY;
    private JTextField computerCoordinataX, computerCoordinataY;
    private JFrame questaFinestra = this;

    public static void logicaVittoria(JFrame questaFinestra, boolean vittoriaCoputer, boolean vittoriaGiocatore) {
        if (!vittoriaCoputer) {
            if (vittoriaGiocatore) {
                Battaglianavale.finePartita(questaFinestra, true);
            }
        } else {
            if (!vittoriaGiocatore) {
                Battaglianavale.finePartita(questaFinestra, false);
            }
        }
    }


    public static void finePartita(JFrame questaFinestra, boolean vittoria){
        if (vittoria){
            JOptionPane.showMessageDialog(questaFinestra,"Hai Vinto!");
        }else{
            JOptionPane.showMessageDialog(questaFinestra,"Hai Perso!");
        }

    }

    public Battaglianavale () {
        setTitle("BattleShip");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,500,500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,100,100));
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
                //PannelloUtente finestraUtente = new PannelloUtente();
                //finestraUtente.setVisible(true);
                nomeUtente=JOptionPane.showInputDialog(questaFinestra,"Inserisci Nome");
                System.out.println(nomeUtente);
                giocatore.setText(nomeUtente);
                giocatore.setVisible(true);
                bottoneFuoco.setVisible(true);
                giocatoreCoordinataX.setVisible(true);
                giocatoreCoordinataY.setVisible(true);
                giocatoreX.setVisible(true);
                giocatoreY.setVisible(true);
                coordinateGiocatore.setVisible(true);
                coordinateComputer.setVisible(true);
                computer.setVisible(true);
                computerX.setVisible(true);
                computerCoordinataX.setVisible(true);
                computerY.setVisible(true);
                computerCoordinataY.setVisible(true);
//              System.out.println("si funziona!");

            }
        });
        menu.add(Nuovapartita);

        esci = new JMenuItem("Esci");
        esci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pannelloComputer.setVisible(false);
                //pannelloGiocatore.setVisible(false);
                giocatore.setVisible(false);
                bottoneFuoco.setVisible(false);
                giocatoreCoordinataX.setVisible(false);
                giocatoreCoordinataY.setVisible(false);
                giocatoreX.setVisible(false);
                giocatoreY.setVisible(false);
                coordinateGiocatore.setVisible(false);
                coordinateComputer.setVisible(false);
                computer.setVisible(false);
                computerX.setVisible(false);
                computerCoordinataX.setVisible(false);
                computerY.setVisible(false);
                computerCoordinataY.setVisible(false);
            }
        });
        menu.add(esci);

        pannelloComputer = new JPanel();
        contentPane.add(pannelloComputer,BorderLayout.EAST);

        pannelloGiocatore = new JPanel();
        contentPane.add(pannelloGiocatore,BorderLayout.WEST);
        contentPane.setBounds(200,200,4000,4000);

        giocatore = new JLabel();
        giocatore.setEnabled(false);
        //giocatore.setBackground(null);
        //giocatore.setText(nomeUtente);
        giocatore.setBounds(20,20, 50,20);
        pannelloGiocatore.add(giocatore, BorderLayout.NORTH);

        coordinateGiocatore = new JLabel("Coordinate");
        coordinateGiocatore.setVisible(false);
        coordinateGiocatore.setBounds(10,80,10,10);
        pannelloGiocatore.add(coordinateGiocatore);

        giocatoreX = new JLabel("X");
        giocatoreX.setBounds(10,40,10,10);
        pannelloGiocatore.add(giocatoreX);
        giocatoreX.setVisible(false);

        giocatoreCoordinataX = new JTextField();
        giocatoreCoordinataX.setBounds(10,40,10,10);
        pannelloGiocatore.add(giocatoreCoordinataX);
        giocatoreCoordinataX.setVisible(false);
        giocatoreCoordinataX.setColumns(2);

        giocatoreY = new JLabel("Y");
        giocatoreY.setBounds(10,40,10,10);
        pannelloGiocatore.add(giocatoreY);
        giocatoreY.setVisible(false);

        giocatoreCoordinataY = new JTextField();
        giocatoreCoordinataY.setBounds(10,40,10,10);
        pannelloGiocatore.add(giocatoreCoordinataY);
        giocatoreCoordinataY.setVisible(false);
        giocatoreCoordinataY.setColumns(2);

        bottoneFuoco = new JButton("Fire");
        bottoneFuoco.setBounds(200,50,20,60);
        pannelloGiocatore.add(bottoneFuoco);
        bottoneFuoco.setVisible(false);
        bottoneFuoco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                GestioneUtente.controlloCordinate(giocatoreCoordinataX,giocatoreCoordinataY);
//                GestioneComputer.attaccoDalGiocatore(giocatoreCoordinataX,GestioneUtente.convertitore(giocatoreCoordinataY));
//                Battaglianavale.logicaVittoria(questaFinestra,GestioneUtente.controlloVittoriaCoputer(),GestioneCoputer.controlloVittoriaGiocatore()))
//                GestioneComputer.attaccoDalComputer(gestioneComputer.getCoordinataX(),gestioneComputer.getCoordinataY());
//                Battaglianavale.logicaVittoria(questaFinestra,GestioneUtente.controlloVittoriaCoputer(),GestioneCoputer.controlloVittoriaGiocatore());
            }
        });

        computer = new JLabel("Computer");
        pannelloComputer.add(computer);
        computer.setVisible(false);

        coordinateComputer = new JLabel("Coordinate");
        coordinateComputer.setVisible(false);
        coordinateComputer.setBounds(10,80,10,10);
        pannelloComputer.add(coordinateComputer);

        computerX = new JLabel("X");
        computerX.setBounds(10,40,10,10);
        pannelloComputer.add(computerX);
        computerX.setVisible(false);

        computerCoordinataX = new JTextField();
        computerCoordinataX.setBounds(10,40,10,10);
        pannelloComputer.add(computerCoordinataX);
        computerCoordinataX.setVisible(false);
        computerCoordinataX.setColumns(2);

        computerY = new JLabel("Y");
        computerY.setBounds(10,40,10,10);
        pannelloComputer.add(computerY);
        computerY.setVisible(false);

        computerCoordinataY = new JTextField();
        computerCoordinataY.setBounds(10,40,10,10);
        pannelloComputer.add(computerCoordinataY);
        computerCoordinataY.setVisible(false);
        computerCoordinataY.setColumns(2);

        //tabellaGiocatore = GestioneUtente.getTable();
        //pannelloGiocatore.add(tabellaGiocatore);


        //tablellaComputer = new JTable();
        //pannelloGiocatore.add(tablellaComputer);

    }


}
