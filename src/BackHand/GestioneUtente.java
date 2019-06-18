package BackHand;
public class GestioneUtente extends GestioneTabella{


     private String ListY="LIHGFEDCBA";
     private String listY="lihgfedcba";

     public GestioneUtente(){  }

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

}

