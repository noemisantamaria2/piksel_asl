package BackHand;

public class InfoCasella {

    private int riga;
    private int colonna;
    private String[][]tabella;
    private String valore;

    public InfoCasella(int riga, int colonna, String[][] tabella, String valore) {

        this.riga = riga;
        this.colonna = colonna;
        this.tabella = tabella;
        this.valore = valore;

    }

    public InfoCasella(int riga, int colonna, String[][] tabella) {

        this.riga = riga;
        this.colonna = colonna;
        this.tabella = tabella;
        this.valore = null;

    }

    public int getRiga() {
        return riga;
    }

    public int getColonna() {
        return colonna;
    }

    public String[][] getTabella() {
        return tabella;
    }

    public String getValore() {
        return valore;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }

    public void setTabella(String[][] tabella) {
        this.tabella = tabella;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }
}
