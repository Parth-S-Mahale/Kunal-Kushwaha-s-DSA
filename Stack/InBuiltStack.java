import java.util.Stack;

public class InBuiltStack{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);

        System.out.println("First Element removed is: " + stack.pop());
        System.out.println("Second Element removed is: " + stack.pop());
        System.out.println("Third Element removed is: " + stack.pop());
        System.out.println("Fourth Element removed is: " + stack.pop());
        System.out.println("Fifth Element removed is: " + stack.pop());

        System.out.print(stack.pop()); //  Error - Java Exception in thread "main" java.util.EmptyStackException

    }
}