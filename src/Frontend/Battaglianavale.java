package Frontend;
import Backend.Casella;
import Backend.GestioneUtente;
import Backend.GestioneComputer;

import static javax.swing.GroupLayout.Alignment.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


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
    private JMenu menu, menuLegenda;
    private JMenuItem Nuovapartita, esci, legendaX, legendaO, legendaY, legendaN;
    private JPanel contentPane, pannelloComputer, pannelloGiocatore, componentiPannelloGiocatore, tabellaPannelloGiocatore, componentiPannelloComputer, tabellaPannelloComputer, pannelloPunti;
    private JTable tabellaComputer, tabellaGiocatore;
    private ModelloTabella modelloTabellaGiocatore,modelloTabellaComputer;
    private JLabel giocatoreX, giocatoreY, spazio, computerX, computerY, giocatore, computer, coordinateGiocatore, coordinateComputer, trattinoPunti, puntiGiocatore, puntiComputer, scrittaPunti;
    private JButton bottoneFuoco;
    private JTextField giocatoreCoordinataX, giocatoreCoordinataY;
    private JTextArea computerCoordinataX, computerCoordinataY;
    private String [][] matriceColoriTabellaGiocatore = new String [11][11];
    private String [][] matriceColoritabellaComputer = new String [11][11];

//    private GestioneTabella gestioneTabella = new GestioneTabella();
    private GestioneComputer gestioneComputer;
    private GestioneUtente gestioneUtente;

    private JFrame questaFinestra = this;
    //private GroupLayout groupLayout;
    //private GridBagConstraints gbc;

    public boolean logicaVittoria(JFrame questaFinestra, boolean vittoriaComputer, boolean vittoriaGiocatore) {
        if (!vittoriaComputer) {
            if (vittoriaGiocatore) {
                Battaglianavale.finePartita(questaFinestra, true);
                System.out.println("true");
                puntiGiocatore.setText(String.valueOf(Integer.parseInt(puntiGiocatore.getText())+1));
                return true;
            }
        } else {
            if (!vittoriaGiocatore) {
                Battaglianavale.finePartita(questaFinestra, false);
                System.out.println("false");
                puntiComputer.setText(String.valueOf(Integer.parseInt(puntiComputer.getText())+1));
                return false;
            }
        }
        return false;
    }


    public static void finePartita(JFrame questaFinestra, boolean vittoria){
        if (vittoria){
            JOptionPane.showMessageDialog(questaFinestra,"Hai Vinto!");
        }else{
            JOptionPane.showMessageDialog(questaFinestra,"Hai Perso!");
        }

    }

    public void printMatriceColoriGiocatore(){
        for (int i=0;i<matriceColoriTabellaGiocatore.length;i++){
            for (int j=0;j<matriceColoriTabellaGiocatore[0].length;j++){
                System.out.print(matriceColoriTabellaGiocatore[i][j] + " | ");
            }
            System.out.println();
        }

    }


    public void printMatriceColoriComputer(){
        for (int i=0;i<matriceColoritabellaComputer.length;i++){
            for (int j=0;j<matriceColoritabellaComputer[0].length;j++){
                System.out.print(matriceColoritabellaComputer[i][j] + " | ");
            }
            System.out.println();
        }

    }

    public void printMatriceColori(String [][] matriceColori){
        for (int i=0;i<matriceColori.length;i++){
            for (int j=0;j<matriceColori[0].length;j++){
                System.out.print(matriceColori[i][j] + " | ");
            }
            System.out.println();
        }

    }


    public void costruisciMatriceColori(String [][] matriceColori){
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
    }

    public void costruisciMatriceColoriGiocatore(){
        for (int i=0;i<matriceColoriTabellaGiocatore.length;i++){
            for (int j=0;j<matriceColoriTabellaGiocatore[0].length;j++){
                if (i==0 || j==0){
                    matriceColoriTabellaGiocatore[i][j] = "GRAY";
                }
                else{
                    matriceColoriTabellaGiocatore[i][j] = "WHITE";
                }
            }
        }
    }

    public void costruisciMatriceColoriComputer(){
        for (int i=0;i<matriceColoritabellaComputer.length;i++){
            for (int j=0;j<matriceColoritabellaComputer[0].length;j++){
                if (i==0 || j==0){
                    matriceColoritabellaComputer[i][j] = "GRAY";
                }
                else{
                    matriceColoritabellaComputer[i][j] = "WHITE";
                }
            }
        }
    }

    public boolean inserisciColoreInMatrice (String [][] matriceColori, String colore, int riga, int colonna) {
        if (!colore.equalsIgnoreCase("RED")){
            if (matriceColori[riga][colonna].equalsIgnoreCase("WHITE")) {
                matriceColori[riga][colonna] = colore;
                return true;
            }else {
                return false;
            }
        }
        else {
            if (matriceColori[riga][colonna].equalsIgnoreCase("BLACK")) {
                matriceColori[riga][colonna] = colore;
                return true;
            }else {
                return false;
            }
        }
    }

    public void  esciDalGioco(){
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
        pannelloGiocatore.setVisible(false);
        pannelloComputer.setVisible(false);
        tabellaPannelloGiocatore.setVisible(false);
        menuLegenda.setVisible(false);
        componentiPannelloGiocatore.setVisible(false);
        componentiPannelloComputer.setVisible(false);
        tabellaPannelloComputer.setVisible(false);
        pannelloPunti.setVisible(false);
    }

//    public String convertiContenutoInColori (String contenuto){
//        if (contenuto)
//            ret
//    }

    public Battaglianavale () {
        setTitle("BattleShip");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        contentPane.setAutoscrolls(true);
        setContentPane(contentPane);

        menuBar = new JMenuBar();
        contentPane.add(menuBar,BorderLayout.NORTH);

        menu = new JMenu("File");
        menuBar.add(menu);
        menuLegenda = new JMenu("Legenda");
        menuBar.add(menuLegenda);
        menuLegenda.setVisible(false);


        legendaX = new JMenuItem("X = Colpito");
        legendaO = new JMenuItem("O = Acqua");
        legendaY = new JMenuItem("Y = Affondato");
        legendaN = new JMenuItem("N = Nave");
        menuLegenda.add(legendaN);
        menuLegenda.add(legendaX);
        menuLegenda.add(legendaO);
        menuLegenda.add(legendaY);


        Nuovapartita = new JMenuItem("Nuova Partita");
        Nuovapartita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeUtente=JOptionPane.showInputDialog(questaFinestra,"Inserisci Nome");
                System.out.println(nomeUtente);
                pannelloGiocatore.setVisible(true);
                tabellaPannelloGiocatore.setVisible(true);
                pannelloComputer.setVisible(true);
                coordinateComputer.setVisible(true);
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
                computer.setVisible(true);
                computerX.setVisible(true);
                computerCoordinataX.setVisible(true);
                computerCoordinataX.setText("");
                computerY.setVisible(true);
                computerCoordinataY.setVisible(true);
                componentiPannelloGiocatore.setVisible(true);
                componentiPannelloComputer.setVisible(true);
                tabellaPannelloComputer.setVisible(true);
                computerCoordinataY.setText("");
                tabellaGiocatore.setVisible(true);
                modelloTabellaGiocatore.nuovatabella();
                menuLegenda.setVisible(true);
                gestioneUtente = new GestioneUtente();
                gestioneComputer = new GestioneComputer();
                pannelloPunti.setVisible(true);

                modelloTabellaGiocatore.addNaviGiocatore(gestioneUtente.getMatrice());

                tabellaComputer.setVisible(true);
                modelloTabellaComputer.nuovatabella();
//                GestioneComputer.riempimentoMatriceNonVis();



            }
        });
        menu.add(Nuovapartita);

        esci = new JMenuItem("Esci");
        esci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent esci) {

                esciDalGioco();

            }
        });
        menu.add(esci);



        pannelloGiocatore = new JPanel();
        pannelloGiocatore.setLayout(new BorderLayout());
        contentPane.add(pannelloGiocatore,BorderLayout.WEST);
        //pannelloGiocatore.setBackground(Color.green);
        pannelloGiocatore.setVisible(false);

        pannelloComputer = new JPanel();
        pannelloComputer.setLayout(new BorderLayout());
        contentPane.add(pannelloComputer,BorderLayout.EAST);
        pannelloComputer.setBackground(Color.CYAN);
        pannelloComputer.setVisible(false);

        componentiPannelloGiocatore = new JPanel(new GridBagLayout());
        pannelloGiocatore.add(componentiPannelloGiocatore, BorderLayout.NORTH);
        //componentiPannelloGiocatore.setBackground(Color.blue);
        componentiPannelloGiocatore.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createEmptyBorder(80,-200,1,0),BorderFactory.createEmptyBorder(0,0,0,0)));
        componentiPannelloGiocatore.setVisible(false);

        tabellaPannelloGiocatore = new JPanel();
        pannelloGiocatore.add(tabellaPannelloGiocatore, BorderLayout.CENTER);
        //tebellaPannelloGiocatore.setBackground(Color.yellow);
        tabellaPannelloGiocatore.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createEmptyBorder(40,0,0,0),BorderFactory.createEmptyBorder(0,0,0,0)));
        tabellaPannelloGiocatore.setVisible(false);

        componentiPannelloComputer = new JPanel(new GridBagLayout());
        pannelloComputer.add(componentiPannelloComputer, BorderLayout.NORTH);
        //componentiPannelloComputer.setBackground(Color.blue);
        componentiPannelloComputer.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createEmptyBorder(90,0,1,-190),BorderFactory.createEmptyBorder(0,0,0,0)));
        componentiPannelloComputer.setVisible(false);

        tabellaPannelloComputer = new JPanel();
        pannelloComputer.add(tabellaPannelloComputer, BorderLayout.CENTER);
        //tabellaPannelloComputer.setBackground(Color.yellow);
        tabellaPannelloComputer.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createEmptyBorder(40,0,0,0),BorderFactory.createEmptyBorder(0,0,0,0)));
        tabellaPannelloComputer.setVisible(false);

        pannelloPunti = new JPanel(new GridBagLayout());
//        pannelloPunti.setBackground(Color.green);
        contentPane.add(pannelloPunti, BorderLayout.CENTER);
        pannelloPunti.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createEmptyBorder(-800,0,0,0),BorderFactory.createEmptyBorder(0,0,0,0)));
        pannelloPunti.setVisible(false);

        spazio = new JLabel("          ");

        giocatore = new JLabel();
        giocatore.setEnabled(false);
        giocatore.setBackground(null);
        giocatore.setText(nomeUtente);
        giocatore.setBounds(20,20, 50,20);
        giocatore.setVisible(false);
        //componentiPannelloGiocatore.add(giocatore, BorderLayout.NORTH);

        coordinateGiocatore = new JLabel("Coordinate     ");
        coordinateGiocatore.setVisible(false);
        coordinateGiocatore.setBounds(10,80,10,10);
        //componentiPannelloGiocatore.add(coordinateGiocatore);

        giocatoreX = new JLabel("   X   ");
        giocatoreX.setBounds(10,40,10,10);
        //componentiPannelloGiocatore.add(giocatoreX);
        giocatoreX.setVisible(false);

        giocatoreCoordinataX = new JTextField();
        giocatoreCoordinataX.setBounds(10,40,10,10);
        //componentiPannelloGiocatore.add(giocatoreCoordinataX);
        giocatoreCoordinataX.setVisible(false);
        giocatoreCoordinataX.setColumns(2);

        giocatoreY = new JLabel("Y  ");
        giocatoreY.setBounds(10,40,10,10);
        //componentiPannelloGiocatore.add(giocatoreY);
        giocatoreY.setVisible(false);

        giocatoreCoordinataY = new JTextField();
        giocatoreCoordinataY.setBounds(10,40,10,10);
        //componentiPannelloGiocatore.add(giocatoreCoordinataY);
        giocatoreCoordinataY.setVisible(false);
        giocatoreCoordinataY.setColumns(2);

        bottoneFuoco = new JButton("Fire");
        bottoneFuoco.setBounds(200,50,20,60);
        //componentiPannelloGiocatore.add(bottoneFuoco);
        bottoneFuoco.setVisible(false);
        bottoneFuoco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenuto = new String();


                //test (prova)
//                /*sconfitta giocatore*/ Battaglianavale.logicaVittoria(questaFinestra,true,false);
//                /*vittoria giocatore*/ Battaglianavale.logicaVittoria(questaFinestra,false,true);

//                System.out.println("'"+giocatoreCoordinataX.getText().trim()+"'");


                try{
                    if(!gestioneUtente.controlloCoordinate(Integer.parseInt(giocatoreCoordinataX.getText().trim()),giocatoreCoordinataY.getText().trim())){
                        JOptionPane.showMessageDialog(questaFinestra,"Le Coordinate non sono corrette","ERRORE",JOptionPane.ERROR_MESSAGE);
                        giocatoreCoordinataX.setText("");
                        giocatoreCoordinataY.setText("");
                    }
                    else {
                        contenuto = gestioneComputer.attacco(gestioneUtente.convertitoreY(giocatoreCoordinataY.getText().trim()),Integer.parseInt(giocatoreCoordinataX.getText().trim()));
                        if (!modelloTabellaComputer.addXeO(contenuto,gestioneUtente.convertitoreY(giocatoreCoordinataY.getText().trim()),Integer.parseInt(giocatoreCoordinataX.getText().trim()))){
                            JOptionPane.showMessageDialog(questaFinestra,"Casella già colpita, Riprova","ERRORE",JOptionPane.WARNING_MESSAGE);
                            giocatoreCoordinataX.setText("");
                            giocatoreCoordinataY.setText("");
                        }
                        else{
                            giocatoreCoordinataX.setText("");
                            giocatoreCoordinataY.setText("");

                            if (modelloTabellaComputer.affondata(gestioneComputer.naveTrovata())) {
                                JOptionPane.showMessageDialog(questaFinestra, "Nave Affondata", "INFO", JOptionPane.INFORMATION_MESSAGE);
                            }
                            if (!logicaVittoria(questaFinestra,gestioneUtente.controllaVittoria(),gestioneComputer.controllaVittoria())){


                                Casella casella = gestioneUtente.attaccoDalComputer();
//                            computerCoordinataY.setText(String.valueOf(casella.getRiga()));
                                computerCoordinataY.setText(gestioneComputer.convertYInChar(casella.getRiga()));
                                computerCoordinataX.setText(String.valueOf(casella.getColonna()));

                                contenuto = gestioneUtente.attacco(casella.getRiga(),casella.getColonna());
                                modelloTabellaGiocatore.addXeO(contenuto,casella.getRiga(),casella.getColonna());

                                

                                JOptionPane.showMessageDialog(questaFinestra, "Colpo effettuato dal Computer in "+gestioneComputer.convertYInChar(casella.getRiga())+" "+casella.getColonna(), "ATTACCO DEL PC", JOptionPane.INFORMATION_MESSAGE);

                                if (modelloTabellaGiocatore.affondata(gestioneUtente.naveTrovata())) {
                                    JOptionPane.showMessageDialog(questaFinestra, "Computer ti ha Affondato una Nave", "INFO", JOptionPane.INFORMATION_MESSAGE);
                                }
                                if(logicaVittoria(questaFinestra,gestioneUtente.controllaVittoria(),gestioneComputer.controllaVittoria())){
                                    esciDalGioco();
                                }
                            }
                            else{
                                esciDalGioco();
                            }

//




                        }

                    }
                }catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(questaFinestra,"La coordinata X deve essere un numero","ATTENZIONE",JOptionPane.ERROR_MESSAGE);
                }

            }
        });



        computer = new JLabel("Computer  ");
        //pannelloComputer.add(computer);
        computer.setVisible(false);

        coordinateComputer = new JLabel("Coordinate");
        coordinateComputer.setVisible(false);
        //coordinateComputer.setBounds(10,80,10,10);
        //pannelloComputer.add(coordinateComputer);

        computerX = new JLabel("   X   ");
        //computerX.setBounds(10,40,10,10);
        //pannelloComputer.add(computerX);
        computerX.setVisible(false);

        computerCoordinataX = new JTextArea();
        //computerCoordinataX.setBounds(10,40,10,10);
        //pannelloComputer.add(computerCoordinataX);
        computerCoordinataX.setVisible(false);
        computerCoordinataX.setColumns(2);
        computerCoordinataX.setEnabled(false);

        computerY = new JLabel("     Y   ");
        //computerY.setBounds(10,40,10,10);
        //pannelloComputer.add(computerY);
        computerY.setVisible(false);

        computerCoordinataY = new JTextArea();
        //computerCoordinataY.setBounds(10,40,10,10);
        //pannelloComputer.add(computerCoordinataY);
        computerCoordinataY.setVisible(false);
        computerCoordinataY.setColumns(2);
        computerCoordinataY.setEnabled(false);


        modelloTabellaGiocatore = new ModelloTabella();
        //ToDo appena implementata la classe GestioneUtenete
//        modelloTabellaGiocatore.addNaviGiocatore(GestioneUtente.getMatrice);
        tabellaGiocatore = new JTable(modelloTabellaGiocatore);
        tabellaGiocatore.setFillsViewportHeight(false);
        tabellaGiocatore.setVisible(false);
//        tabellaGiocatore.setSize(100,100);
//        JScrollPane pannelloTabellaGiocatore = new JScrollPane(this.tabellaComputer);
//        pannelloGiocatore.add(new JScrollPane(this.tabellaGiocatore));
        tabellaPannelloGiocatore.add(tabellaGiocatore, CENTER);
        //tebellaPannelloGiocatore.setSize(500,500);
        costruisciMatriceColori(matriceColoriTabellaGiocatore);
        tabellaGiocatore.setDefaultRenderer(Object.class, new CustomTableCellRenderer(matriceColoriTabellaGiocatore));
        tabellaGiocatore.setRowHeight(70);


        JLabel allineamtentoTab2 = (JLabel) tabellaGiocatore.getDefaultRenderer(Object.class);
        allineamtentoTab2.setHorizontalAlignment(SwingConstants.CENTER);


        modelloTabellaComputer = new ModelloTabella();
        tabellaComputer = new JTable(modelloTabellaComputer);
        tabellaComputer.setFillsViewportHeight(false);
        tabellaComputer.setVisible(false);
//        JScrollPane pannelloTabellaComputer = new JScrollPane(this.tabellaComputer);
//        pannelloTabellaComputer.setBackground(null);
//        pannelloComputer.add(pannelloTabellaComputer);
//        tabellaComputer.setSize(100,100);
//        pannelloComputer.add(new JScrollPane(this.tabellaComputer));
        tabellaPannelloComputer.add(tabellaComputer, CENTER);
        costruisciMatriceColori(matriceColoritabellaComputer);
        tabellaComputer.setDefaultRenderer(Object.class, new CustomTableCellRenderer(matriceColoritabellaComputer));
        tabellaComputer.setRowHeight(70);


        JLabel allineamtentoTab = (JLabel) tabellaComputer.getDefaultRenderer(Object.class);
        allineamtentoTab.setHorizontalAlignment(SwingConstants.CENTER);



        GridBagConstraints gbcGiocatore = new GridBagConstraints();
        GridBagConstraints gbcComputer = new GridBagConstraints();
        GridBagConstraints punti = new GridBagConstraints();

        gbcGiocatore.gridx = 0;
        gbcGiocatore.gridy = 0;
        componentiPannelloGiocatore.add(giocatore, gbcGiocatore);


        gbcGiocatore.gridx = 0;
        gbcGiocatore.gridy = 2;
        componentiPannelloGiocatore.add(coordinateGiocatore, gbcGiocatore);

        gbcGiocatore.gridx = 1;
        gbcGiocatore.gridy = 2;
        componentiPannelloGiocatore.add(giocatoreY, gbcGiocatore);

        gbcGiocatore.gridx = 2;
        gbcGiocatore.gridy = 2;
        componentiPannelloGiocatore.add(giocatoreCoordinataY, gbcGiocatore);

        gbcGiocatore.gridx = 3;
        gbcGiocatore.gridy = 2;
        componentiPannelloGiocatore.add(giocatoreX, gbcGiocatore);

        gbcGiocatore.gridx = 4;
        gbcGiocatore.gridy = 2;
        componentiPannelloGiocatore.add(giocatoreCoordinataX, gbcGiocatore);

        gbcGiocatore.gridx = 5;
        gbcGiocatore.gridy = 2;
        componentiPannelloGiocatore.add(spazio, gbcGiocatore);

        gbcGiocatore.gridx = 6;
        gbcGiocatore.gridy = 2;
        componentiPannelloGiocatore.add(bottoneFuoco, gbcGiocatore);


        ///////////////////////////////////////////////////////////////


        gbcComputer.gridx = 0;
        gbcComputer.gridy = 0;
        componentiPannelloComputer.add(computer, gbcComputer);

        gbcComputer.gridx = 0;
        gbcComputer.gridy = 2;
        componentiPannelloComputer.add(coordinateComputer, gbcComputer);

        gbcComputer.gridx = 1;
        gbcComputer.gridy = 2;
        componentiPannelloComputer.add(computerY, gbcComputer);

        gbcComputer.gridx = 2;
        gbcComputer.gridy = 2;
        componentiPannelloComputer.add(computerCoordinataY, gbcComputer);

        gbcComputer.gridx = 3;
        gbcComputer.gridy = 2;
        componentiPannelloComputer.add(computerX, gbcComputer);

        gbcComputer.gridx = 4;
        gbcComputer.gridy = 2;
        componentiPannelloComputer.add(computerCoordinataX, gbcComputer);

        //////////////////////////////////////////////////////////////////

        scrittaPunti = new JLabel("Punti:");
        trattinoPunti = new JLabel(" - ");
        puntiGiocatore = new JLabel("0");
        puntiComputer = new JLabel("0");
        pannelloPunti.add(puntiGiocatore);
        pannelloPunti.add(trattinoPunti);
        pannelloPunti.add(puntiComputer);

        punti.gridx = 0;
        punti.gridy = 1;
        pannelloPunti.add(puntiGiocatore, punti);

        punti.gridx = 1;
        punti.gridy = 0;
        pannelloPunti.add(scrittaPunti, punti);

        punti.gridx = 1;
        punti.gridy = 1;
        pannelloPunti.add(trattinoPunti, punti);

        punti.gridx = 2;
        punti.gridy = 1;
        pannelloPunti.add(puntiComputer, punti);




    }
}