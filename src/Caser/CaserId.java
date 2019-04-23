package Caser;

public class CaserId {
    public String id;
    public int pos;
    public boolean er;
    public CaserId(String s,int pos){
        this.pos=pos;
        id=s;er=false;
        switch (s.toLowerCase()){
            case "div": case"mod": case"else": case"of": case"end": case"case":
               id="id на позиции "+pos+" совпадает со служебным словом";
               er=true;
               break;
            default:break;
        }
        if(s.length()>8){id="Слишком длинный идентификатор на позиции "+pos;}
    }
    public boolean equals(CaserId id){
        return this.id.equals(id.id);
    }
}
