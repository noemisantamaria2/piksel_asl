package FrontHand;
import BackHand.GestioneUtente;
import BackHand.GestioneComputer;
import sun.misc.JarIndex;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
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
    private JTable tabellaComputer, tabellaGiocatore;
    private ModelloTabella modelloTabellaGiocatore,modelloTabellaComputer;
    private JLabel giocatoreX, giocatoreY;
    private JLabel computerX, computerY;
    private JLabel giocatore;
    private JLabel computer;
    private JLabel coordinateGiocatore;
    private JLabel coordinateComputer;
    private JButton bottoneFuoco;
    private JTextField giocatoreCoordinataX, giocatoreCoordinataY;
    private JTextArea computerCoordinataX, computerCoordinataY;
    private JFrame questaFinestra = this;
    private GroupLayout groupLayout;

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
        setSize(1280,720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        menuBar = new JMenuBar();
        contentPane.add(menuBar,BorderLayout.NORTH);

        menu = new JMenu("File");
        menuBar.add(menu);


        Nuovapartita = new JMenuItem("Nuova Partita");
        Nuovapartita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeUtente=JOptionPane.showInputDialog(questaFinestra,"Inserisci Nome");
                System.out.println(nomeUtente);

                pannelloGiocatore.setVisible(true);
                pannelloComputer.setVisible(true);

                giocatore.setText(nomeUtente);
                giocatore.setVisible(true);
                coordinateGiocatore.setVisible(true);
                giocatoreX.setVisible(true);
                giocatoreCoordinataX.setVisible(true);
                giocatoreCoordinataX.setText("");
                giocatoreY.setVisible(true);
                giocatoreCoordinataY.setVisible(true);
                giocatoreCoordinataY.setText("");
                bottoneFuoco.setVisible(true);

                coordinateComputer.setVisible(true);
                computer.setVisible(true);
                computerX.setVisible(true);
                computerCoordinataX.setVisible(true);
                computerCoordinataX.setText("");
                computerY.setVisible(true);
                computerCoordinataY.setVisible(true);
                computerCoordinataY.setText("");
//              System.out.println("si funziona!");



                tabellaGiocatore.setVisible(true);
                modelloTabellaGiocatore.nuovatabella();
//                modelloTabellaGiocatore.addNaviGiocatore();
//                GestioneUtente.riempimentoMatriceNonVis();

                tabellaComputer.setVisible(true);
                modelloTabellaComputer.nuovatabella();
//                GestioneComputer.riempimentoMatriceNonVis();



            }
        });
        menu.add(Nuovapartita);

        esci = new JMenuItem("Esci");
        esci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ToDo appena merge ticket#7
//                pannelloComputer.setVisible(false);
                //ToDo appena merge ticket#7
//                pannelloGiocatore.setVisible(false);
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

        pannelloGiocatore = new JPanel();
        //pannelloGiocatore.setLayout( new GroupLayout());
        //contentPane.add(pannelloGiocatore,BorderLayout.WEST);
        pannelloGiocatore.setBackground(Color.green);
        pannelloGiocatore.setVisible(false);

        giocatore = new JLabel();
        giocatore.setEnabled(false);
        //giocatore.setBackground(null);
        //giocatore.setText(nomeUtente);
        giocatore.setBounds(20,20, 50,20);
        //pannelloGiocatore.add(giocatore, BorderLayout.NORTH);

        coordinateGiocatore = new JLabel("Coordinate");
        coordinateGiocatore.setVisible(false);
        coordinateGiocatore.setBounds(10,80,10,10);
        //pannelloGiocatore.add(coordinateGiocatore);

        giocatoreX = new JLabel("X");
        giocatoreX.setBounds(10,40,10,10);
        //pannelloGiocatore.add(giocatoreX);
        giocatoreX.setVisible(false);

        giocatoreCoordinataX = new JTextField();
        giocatoreCoordinataX.setBounds(10,40,10,10);
        //pannelloGiocatore.add(giocatoreCoordinataX);
        giocatoreCoordinataX.setVisible(false);
        giocatoreCoordinataX.setColumns(2);

        giocatoreY = new JLabel("Y");
        giocatoreY.setBounds(10,40,10,10);
        //pannelloGiocatore.add(giocatoreY);
        giocatoreY.setVisible(false);

        giocatoreCoordinataY = new JTextField();
        giocatoreCoordinataY.setBounds(10,40,10,10);
        //pannelloGiocatore.add(giocatoreCoordinataY);
        giocatoreCoordinataY.setVisible(false);
        giocatoreCoordinataY.setColumns(2);

        bottoneFuoco = new JButton("Fire");
        bottoneFuoco.setBounds(200,50,20,60);
        //pannelloGiocatore.add(bottoneFuoco);
        bottoneFuoco.setVisible(false);
        bottoneFuoco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenuto = new String();

                giocatoreCoordinataX.setText("");
                giocatoreCoordinataY.setText("");
                computerCoordinataX.setText("");
                computerCoordinataY.setText("");

                //test (prova)
//                /*sconfitta giocatore*/ Battaglianavale.logicaVittoria(questaFinestra,true,false);
//                /*vittoria giocatore*/ Battaglianavale.logicaVittoria(questaFinestra,false,true);

                //ToDO appena implementato il package BackEnd
//                GestioneUtente.controlloCordinate((giocatoreCoordinataX.getText()-1),giocatoreCoordinataY.getText());

                //ToDO appena implementato il package BackEnd
//                contenuto = GestioneComputer.attaccoDalGiocatore(Integer.parseInt(giocatoreCoordinataX.getText())-1,GestioneUtente.convertitore(giocatoreCoordinataY));
//                modelloTabellaComputer.addXeO(contenuto,Integer.parseInt(giocatoreCoordinataX.getText())-1,GestioneUtente.convertitore(giocatoreCoordinataY));

                //ToDO appena implementato il package BackEnd
//                logicaVittoria(questaFinestra,GestioneUtente.controlloVittoriaCoputer(),GestioneCoputer.controlloVittoriaGiocatore()))

                //ToDO appena implementato il package BackEnd
//                contenuto = GestioneUtente.attaccoDalComputer(GestioneComputer.getCoordinataX(),GestioneComputer.getCoordinataY());
//                computerCoordinataX.setText(GestioneComputer.getCoordinataX());
//                computerCoordinataY.setText(GestioneComputer.convertitoreYComputer);
//                modelloTabellaGiocatore.addXeO(contenuto,GestioneComputer.getCoordinataX(),GestioneComputer.getCoordinataY());

                //ToDO appena implementato il package BackEnd
//               logicaVittoria(questaFinestra,GestioneUtente.controlloVittoriaCoputer(),GestioneCoputer.controlloVittoriaGiocatore());
            }
        });

        pannelloComputer = new JPanel();
        contentPane.add(pannelloComputer,BorderLayout.EAST);
        pannelloComputer.setBackground(Color.CYAN);
        pannelloComputer.setVisible(false);

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

        computerCoordinataX = new JTextArea();
        computerCoordinataX.setBounds(10,40,10,10);
        pannelloComputer.add(computerCoordinataX);
        computerCoordinataX.setVisible(false);
        computerCoordinataX.setColumns(2);
        computerCoordinataX.setEnabled(false);

        computerY = new JLabel("Y");
        computerY.setBounds(10,40,10,10);
        pannelloComputer.add(computerY);
        computerY.setVisible(false);

        computerCoordinataY = new JTextArea();
        computerCoordinataY.setBounds(10,40,10,10);
        pannelloComputer.add(computerCoordinataY);
        computerCoordinataY.setVisible(false);
        computerCoordinataY.setColumns(2);
        computerCoordinataY.setEnabled(false);


        modelloTabellaGiocatore = new ModelloTabella();
        //ToDo appena implementata la classe GestioneUtenete
//        modelloTabellaGiocatore.addNaviGiocatore(GestioneUtente.getMatrice);
        tabellaGiocatore = new JTable(modelloTabellaGiocatore);
//        tabellaGiocatore.setFillsViewportHeight(true);
        tabellaGiocatore.setVisible(false);
//        tabellaGiocatore.setSize(100,100);
//        JScrollPane pannelloTabellaGiocatore = new JScrollPane(this.tabellaComputer);
        pannelloGiocatore.add(new JScrollPane(this.tabellaGiocatore));
//        pannelloGiocatore.add(tabellaGiocatore);



        modelloTabellaComputer = new ModelloTabella();
        tabellaComputer = new JTable(modelloTabellaComputer);
        tabellaComputer.setFillsViewportHeight(true);
        tabellaComputer.setVisible(false);
//        JScrollPane pannelloTabellaComputer = new JScrollPane(this.tabellaComputer);
//        pannelloTabellaComputer.setBackground(null);
//        pannelloComputer.add(pannelloTabellaComputer);
//        tabellaComputer.setSize(100,100);
//        pannelloComputer.add(new JScrollPane(this.tabellaComputer));
        pannelloComputer.add(tabellaComputer);

        groupLayout = new GroupLayout(pannelloGiocatore);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        pannelloGiocatore.setLayout(groupLayout);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addComponent(giocatore)
                .addComponent(coordinateGiocatore)
                .addGroup(groupLayout.createParallelGroup()
                                .addComponent(coordinateGiocatore)
                                .addComponent(giocatoreX)
                                .addComponent(giocatoreCoordinataX)
                                .addComponent(giocatoreY)
                                .addComponent(giocatoreCoordinataY)
                                .addComponent(bottoneFuoco)));

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(BASELINE))
                .addComponent(giocatore)
                .addComponent(coordinateGiocatore)
                .addComponent(coordinateGiocatore)
                .addComponent(giocatoreX)
                .addComponent(giocatoreCoordinataX)
                .addComponent(giocatoreY)
                .addComponent(giocatoreCoordinataY)
                .addComponent(bottoneFuoco));


        pannelloGiocatore.setLayout(groupLayout);



    }

}