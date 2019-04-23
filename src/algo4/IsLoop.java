package algo4;
public class IsLoop {
   public static boolean isLoop(Node slow){
       Node fast=slow;
       while (fast.getNext()!=null && fast!=null){
           slow=slow.getNext();
           fast=fast.getNext().getNext();
           if(slow==fast) return true;
       }
       return false;
   }
}

