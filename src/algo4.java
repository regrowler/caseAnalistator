import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import algo4.*;

public class algo4 {
    public static void main(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BufferedReader reader=request.getReader();
        String string=reader.readLine();
        response.setContentType("text/plain;charset=UTF-16");
        PrintWriter writer=response.getWriter();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n6);
        String[] strings=string.split(" ");
        switch (strings[0]){
            case "1":
                System.out.println(strings[1]);
                StringBuilder stringBuilder=new StringBuilder();
                for(int i=1;i<strings.length;i++){
                    stringBuilder.append(strings[i]);
                }
                Brackets brackets=new Brackets();
                boolean ch=brackets.check(stringBuilder.toString());
                System.out.println(ch);
                writer.append("Скобки расставлены " + (ch ? "" : "не") + "правильно");
                break;
            case "2":
                if (IsLoop.isLoop(n1))writer.append("цикл есть");
                break;
            case "3":
                CloneLinked cloneLinked=new CloneLinked();
                writer.append(cloneLinked.printout());
                break;
            case "4":
                int i=strings.length;i--;i--;
                int[] mas=new int[i];
                for(int j=0;j<i;j++){
                    try {
                        mas[j]=Integer.parseInt(strings[j+2]);
                    }catch (Exception e){writer.append(e.toString());}
                }
                int size=0;
                try {
                    size=Integer.parseInt(strings[1]);
                }catch (Exception e){writer.append(e.toString()+"wrong size");}
                MaxInWindow max=new MaxInWindow();
                writer.append(max.printMax(mas,mas.length,size));
                break;
            case "5":
                i=strings.length;i--;
                mas=new int[i];
                for(int j=0;j<i;j++){
                    try {
                        mas[j]=Integer.parseInt(strings[j+1]);
                    }catch (Exception e){writer.append(e.toString());}
                }
                SearchInArray sr=new SearchInArray();
                System.out.println(sr.get(mas));
                writer.append(""+sr.get(mas));
                break;
                default:
                  writer.append("nothing");
        }



        writer.close();
    }
}
