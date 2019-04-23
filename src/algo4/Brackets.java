package algo4;
import java.util.Stack;

public class Brackets {
    private Stack<Character> stack = new Stack<Character>();
    public boolean check(String string){
        for(int i=0;i<string.length();i++){
            char c=string.charAt(i);
            if(!stack.isEmpty()){
                char g=stack.peek();
                int j=0;
            }

            if(c=='['||c=='('||c=='{'){stack.push(c);}
            else if((c==']')&(!stack.isEmpty()&stack.peek()=='[')){
                stack.pop();
            }else if((c=='}')&(!stack.isEmpty())&stack.peek()=='{'){stack.pop();}
            else if((c==')')&(!stack.isEmpty())&stack.peek()=='('){stack.pop();}
            else return false;
        }
        return stack.isEmpty();
    }
}