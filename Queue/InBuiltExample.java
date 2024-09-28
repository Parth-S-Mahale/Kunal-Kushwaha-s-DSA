import java.util.Queue;
import java.util.LinkedList;
public class InBuiltExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(19);
        queue.add(1);

        System.out.println("First Element removed is: " + queue.remove());
        System.out.println("Second Element removed is: " + queue.remove());
    }
}