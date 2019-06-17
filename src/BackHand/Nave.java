package BackHand;

public class Nave {

    private int riga;
    private int colonna;
    private int direzione;
    private int lunghezza;

    public Nave(int riga, int colonna, int direzione, int lunghezza) {
        this.riga = riga;
        this.colonna = colonna;
        this.direzione = direzione;
        this.lunghezza = lunghezza;
    }

    public Nave(int lunghezza) {
        this.lunghezza = lunghezza;
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
