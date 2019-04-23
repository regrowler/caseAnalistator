package Caser;
/*
    type-1-int-numb
         2-float-point or fix-point
         3-error
 */
public class CaserConst {
    String string;
    int pos;
    int Inum;
    public int type;
    public CaserConst(String s,int pos){
        try {
            string=s;
            this.pos=pos;
            Inum=Integer.parseInt(s);
            if(Inum<-32768|Inum>32767) {
                string = "целое число за рамками значений на позиции " + this.pos;
                type=3;
            }else type=1;
        }catch (NumberFormatException e){
            string=s;type=2;
        }
    }
    public String toString(){
        return string;
    }
    public boolean equals(CaserConst c){
        return this.string.equals(c.string);
    }
}
