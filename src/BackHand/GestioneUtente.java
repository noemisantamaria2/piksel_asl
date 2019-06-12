package BackHand;
public class GestioneUtente {
     private String ListY="LIHGFEDCBA";
     private String [][]A;
     private String B[][];
    public GestioneUtente(String [][]p,String[][]l){
           

    }
            public boolean ControlloX(int X){
                if(X>=10&&X<=0){
                    return false;
                }
                else return true;
            }
            public boolean ControlloY(String Y){
                  boolean YCorrect=ListY.equals(Y);
                  if(YCorrect==true){
                      return true;
                  } else return false;
            }
            public int ConvertitoreY(String Y){
                 int YConvert=ListY.indexOf(Y);
                 return YConvert;
                }
            public boolean ControlloCoordinate(int x, String Y){
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


            public String attaccoDalComputer(int x,int Y) {
                String Hit="X";
                String NoHit="O";
                String Wrong="XO";
                if(B[x][Y].equals('X')){
                        if(A[x][Y].equals(' ')){
                            A[x][Y].replace(' ','X');
                            return Hit;
                        }else return Wrong;
                }else if(A[x][Y].equals(' ')){
                    A[x][Y].replace(' ','O');
                    return NoHit;
                }else return Wrong;
            }
            public boolean controllaVittoriaGiocatore(){
                int Tot=0;
                for(int k=0; k<10; k++){
                    for(int kk=0; k<10; kk++){
                        if(A[k][kk].equals('X')){
                            Tot++;
                            }
                        }
                    }
                if(Tot==5) {
                    return true;
                }
                    else return false;
                }

            }

