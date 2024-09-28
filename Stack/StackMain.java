public class StackMain {
    public static void main(String[] args) throws StackException{
        CustomStack stack = new DynamicStack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(89);

        System.out.println("First Element removed is: " + stack.pop());
        System.out.println("Second Element removed is: " + stack.pop());
        System.out.println("Third Element removed is: " + stack.pop());
        System.out.println("Fourth Element removed is: " + stack.pop());
        System.out.println("Fifth Element removed is: " + stack.pop());
        System.out.println("sixth Element removed is: " + stack.pop());
    }
}
