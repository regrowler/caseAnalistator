import Caser.Analisator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class caseA {
    public static void Case(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BufferedReader reader=request.getReader();
        String string=reader.readLine();
        response.setContentType("text/plain;charset=UTF-16LE");
        PrintWriter writer=response.getWriter();
        Analisator analisator=new Analisator();
        String st2=analisator.analyse(string);
        int i=0;
        if (st2.charAt(0)=='e'){
            st2=st2.substring(1);
            String[] array=st2.split(" ");
            i=Integer.parseInt(array[array.length-1]);
        }
        System.out.println(i);
        System.out.println(st2);
        StringBuilder stringBuilder=new StringBuilder();
        try {
            if(i!=0){

                stringBuilder.append(string.substring(0,i));
                System.out.println("a");
                //stringBuilder.append("<P>");
                stringBuilder.append("<u>");
                stringBuilder.append(string.charAt(i));
                System.out.println("a");
                stringBuilder.append("</u>");
                stringBuilder.append(string.substring(i+1));
                System.out.println("a");

            }


        }catch (Exception e){
            System.out.println(e.toString());
        }
        stringBuilder.append("<br>");
        stringBuilder.append(st2);
        System.out.println(string.charAt(i));
        writer.append(stringBuilder.toString());
        writer.close();
    }
}
