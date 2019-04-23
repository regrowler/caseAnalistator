package algo5_1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class algo5_1run {
    public static void main(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BufferedReader reader=request.getReader();
        String string=reader.readLine();
        int money=0;
        try {
            money=Integer.parseInt(string);
        }catch (Exception e){

        }
        PrintWriter writer=response.getWriter();
        ArrayList<Element> elements=new ArrayList<>();
        while ((string=reader.readLine())!=null&string!=""){
            String[] params=string.split(" ");
            if(params.length!=3){
                writer.append("ошибка в формировании");return;
            }else {
                int i,j=0;
                try{
                    i=Integer.parseInt(params[1]);
                    j=Integer.parseInt(params[2]);
                }catch (Exception e){
                    writer.append("неверное число");return;
                }
                double d=(i+0.0)/100;
                d*=j;
                i=(int)Math.round(d);
                Element element=new Element(params[0],i,j);
                elements.add(element);
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        response.setContentType("text/plain;charset=UTF-16LE");
        Finder finder1=new Finder(money+0.0);
        finder1.MakeAllSets(elements);
        Finder.knapsack(elements,money);
        ArrayList<Element> res=finder1.GetBestSet();
        stringBuilder.append("пидр: <br>");
        for(int o=0;o<res.size();o++){
            stringBuilder.append(res.get(o).Name+"<br>");
        }
        writer.append(stringBuilder.toString());
        writer.close();
    }
}
class Finder{
    private ArrayList<Element> best;
    private double maxW;
    private double bestPrice;
    public Finder(double _maxw){
        maxW=_maxw;
    }
    static int knapsack(ArrayList<Element> mas, int needed) {
        int n = mas.size();
        int dp[][] = new int[needed + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= needed; w++) {
                if (mas.get(j-1).Price <= w) {
                    dp[w][j] = Math.max(dp[w][j - 1], dp[w - mas.get(j-1).Price][j - 1] + mas.get(j-1).Size);
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }
        return dp[needed][n];
    }
    private double CalcWeigth(ArrayList<Element> items)
    {
        double sumW = 0;
        for(int i=0;i<items.size();i++){
            sumW+=items.get(i).Price;
        }
        return sumW;
    }
    private double CalcPrice(List<Element> items)
    {
        double sumPrice = 0;
        for(int i=0;i<items.size();i++){
            sumPrice+=items.get(i).Size;
        }
        return sumPrice;
    }
    private void CheckSet(ArrayList<Element> items)
    {
        if (best == null)
        {
            if (CalcWeigth(items) <= maxW)
            {
                best = items;
                bestPrice = CalcPrice(items);
            }
        }
        else
        {
            if(CalcWeigth(items) <= maxW && CalcPrice(items) > bestPrice)
            {
                best = items;
                bestPrice = CalcPrice(items);
            }
        }
    }
    public void MakeAllSets(ArrayList<Element> items)
    {
        if (items.size() > 0) CheckSet(items);
        for (int i = 0; i < items.size(); i++)
        {
            ArrayList<Element> newSet = new ArrayList<Element>(items);
            newSet.remove(i);
            MakeAllSets(newSet);
        }
    }
    public ArrayList<Element> GetBestSet()
    {
        return best;
    }
}
class Element
{
    public String Name;
    public int Size;
    public int Price;

    public Element(String Name, int Size, int Price)
    {
        this.Name = Name;
        this.Size = Size;
        this.Price = Price;
    }
}
