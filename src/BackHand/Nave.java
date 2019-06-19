package BackHand;

import java.util.ArrayList;

public class Nave {

    private int riga;
    private int colonna;
    private int direzione;
    private int lunghezza;
    private ArrayList<Casella> caselle;
    private boolean condizione;

    public Nave(int riga, int colonna, int direzione, int lunghezza) {
        this.riga = riga;
        this.colonna = colonna;
        this.direzione = direzione;
        this.lunghezza = lunghezza;
        this.caselle = new ArrayList<Casella>();
        condizione = false;

    }

    public Nave(int lunghezza) {
        this.riga = -1;
        this.colonna = -1;
        this.direzione = -1;
        this.lunghezza = lunghezza;
        this.caselle = new ArrayList<Casella>();
        this.condizione = false;
    }

    public ArrayList<Casella> getCaselle() {
        return caselle;
    }

    public void setCaselle(ArrayList<Casella> caselle) {
        this.caselle = caselle;
    }

    public int getRiga() {
        return riga;
    }

    public int getColonna() {
        return colonna;
    }

    public int getDirezione() {
        return direzione;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }

    public void setDirezione(int direzione) {
        this.direzione = direzione;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }
}
