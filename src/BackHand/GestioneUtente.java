package BackHand;
public class GestioneUtente {
     private String ListY="LIHGFEDCBA";
     private String listY="lihgfedcba";
     private String [][]MatriceB;      //Matrice contenenti navi
     private String [][]MatriceA;      //Matrice che gestisce gli attacchi
    public GestioneUtente(String [][]p){
    MatriceB=p;


    }
            public boolean ControlloX(int X){          //ok
                if(X<10&&X>-1){
                    return true;
                }
                else return false;
            }
            public boolean ControlloY(String Y){         //ok
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
            public int ConvertitoreY(String Y){         //ok
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
            public boolean ControlloCoordinate(int x, String Y){  //ok
                boolean CheckX=this.ControlloX(x);
                boolean CheckY=this.ControlloY(Y);
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

            public void RiempimentoMatriceNonVis(){ //Metodo per riempire la Matrice non vista dall'utente
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        MatriceA[i][j]=" ";

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
                if(MatriceB[x][Y].equals(SegnoX)){
                        if(MatriceA[x][Y].equals(SegnoVuoto)){
                            MatriceA[x][Y]="X";
                            return Hit;
                        }else return Wrong;
                }else if(MatriceA[x][Y].equals(SegnoVuoto)){
                    MatriceA[x][Y]="O";
                    return NoHit;
                }else return Wrong;
            }
            public boolean controllaVittoriaComputer(){                //ok Controlla la matrice non visualizzata e guarda se ci sono 17 X
        String SimboloX="X";
                int Tot=0;
                for(int i=0; i<10; i++){
                    for(int j=0; j<10; j++){
                        if(MatriceA[i][j].equals(SimboloX)){
                            Tot++;
                            }
                        }
                    }
                if(Tot==17) {
                    return true;
                }
                    else return false;
                }
    public String getMatrice(){
        return MatriceA[10][10];
    }


}

