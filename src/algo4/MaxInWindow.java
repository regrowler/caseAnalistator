package algo4;
import java.io.Console;
import java.util.Deque;
import java.util.LinkedList;
public class MaxInWindow {
     static int count=0;
    public static String printMax(int arr[],int n, int k)
    {
        StringBuilder stringBuilder=new StringBuilder();
        Deque<Integer> Qi = new LinkedList<Integer>();
        int i;
        for(i = 0; i < k; ++i)
        {
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
            { Qi.removeLast();
            count++;}
            Qi.addLast(i);
        }
        for( ;i < n; ++i)
        {
            System.out.print(arr[Qi.peek()] + " ");
            stringBuilder.append(arr[Qi.peek()] + " ");
            while((!Qi.isEmpty()) && Qi.peek() <= i-k) {
                Qi.removeFirst();count++;
            }
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
                count++;
            }
            Qi.addLast(i);
        }
        System.out.print(arr[Qi.peek()]+" ");
        stringBuilder.append(arr[Qi.peek()] + " ");
        return stringBuilder.toString();

    }


}


