package algo4;
public class SearchInArray {
    private static int element;
    private static void findElement(int[] mas){
        int slow_1=0,slow_2=0;
        int fast_1=3,fast_2=3;
        while(slow_1<mas.length){
            slow_2=mas[slow_1];
            fast_2=mas[fast_1];
            if(mas[slow_1]==mas[fast_2]&& slow_1!=fast_2) {
                element=mas[slow_1];break;}
            if(mas[slow_2]==mas[fast_1] && slow_2!=fast_1) {
                element=mas[slow_2];break;}
            slow_1++;
            fast_1+=2;
            if(fast_1>=mas.length) fast_1=1;
        }
    }
    public static int getElement(int[] mas) {
        findElement(mas);
        return element;
    }
    public static int get(int[] mas){
        if(mas.length<=1)return -1;
        int slow=mas[0];
        int fast=mas[mas[0]];
        while (slow!=fast){
            slow=mas[slow];
            fast=mas[mas[fast]];
        }
        fast=0;
        while (slow!=fast){
            slow=mas[slow];
            fast=mas[fast];
        }
        return slow;
    }
}
