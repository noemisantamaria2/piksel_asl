package BackHand;
public class GestioneUtente {
     private String ListY="LIHGFEDCBA";
     private String listY="lihgfedcba";
     private String [][]MatriceNavi;      //Matrice contenente navi
     private String [][]MatriceGestione;      //Matrice che gestisce gli attacchi
    public GestioneUtente(String [][]p){
    MatriceNavi=p;
    }
            public boolean controlloX(int X){          //ok Controllo coordinata x
                if(X<10&&X>-1){
                    return true;
                }
                else return false;
            }
            public boolean controlloY(String Y){         //ok Controllo coordinata y
                  int YCorrect=ListY.indexOf(Y);
                if(YCorrect<10&&YCorrect>-1) {
                    return true;
                }else {
                    int ycorrect=listY.indexOf(Y);
                    if(ycorrect<10&&ycorrect>-1)
                    {
                        return true;
                    }else return false;
                }
            }
            public int convertitoreY(String Y){         //ok Converte la lettera in numero
                 int YConvert=ListY.indexOf(Y);
                if(YConvert<10&&YConvert>-1){
                    return YConvert;
                }
                else{
                    int yconvert=listY.indexOf(Y);
                    if(yconvert<10&&yconvert>-1){
                        return yconvert;
                    }
                }
                return -1;
    }
            public boolean controlloCoordinate(int x, String Y){  //ok Controllo la correttezza di entrambe le coordinate
                boolean CheckX=this.controlloX(x);
                boolean CheckY=this.controlloY(Y);
                if(CheckX==true){
                    if (CheckY == true) {
                        return true;
                    }
                    else return false;
                }
                else return false;
        }
 /*          public void  StampA(){
                for(int i = 0; i < 2; i++){
                    for(int j = 0; j < 2; j++){
                        System.out.println(MatriceA[i][j]);

                    }
                }
            }
            public void  StampB(){
                for(int i = 0; i < 2; i++){
                    for(int j = 0; j < 2; j++){
                        System.out.println(MatriceB[i][j]);

                }
            }
    }*/

            public void riempimentoMatriceNonVis(){ //Metodo per riempire la Matrice non vista dall'utente
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        MatriceGestione[i][j]=" ";

                    }
                }
            }

            public String attaccoDalComputer(int x,int Y) { //ok riceve le coordinate e controlla le due matrici
                String Hit="X";
                String NoHit="O";
                String Wrong="XO";
                String SegnoVuoto=" ";
                String SegnoX="X";
               // String SegnoO="O";
                if(MatriceNavi[x][Y].equals(SegnoX)){
                        if(MatriceGestione[x][Y].equals(SegnoVuoto)){
                            MatriceGestione[x][Y]="X";
                            return Hit;
                        }else return Wrong;
                }else if(MatriceGestione[x][Y].equals(SegnoVuoto)){
                    MatriceGestione[x][Y]="O";
                    return NoHit;
                }else return Wrong;
            }
            public boolean controllaVittoriaComputer(){                //ok Controlla la matrice non visualizzata e guarda se ci sono 17 X
        String SimboloX="X";
                int Tot=0;
                for(int i=0; i<10; i++){
                    for(int j=0; j<10; j++){
                        if(MatriceGestione[i][j].equals(SimboloX)){
                            Tot++;
                            }
                        }
                    }
                if(Tot==17) {
                    return true;
                }
                    else return false;
                }
    public String[][] getMatrice(){
        return MatriceNavi;
    }


}

