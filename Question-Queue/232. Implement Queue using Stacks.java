import java.util.Stack;

class Solution {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public Solution() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) throws Exception {
        while (!first.isEmpty()) {
            int popped = first.pop(); // popped from first stack
            second.push(popped); // added the popped item in the second stack
        }

        first.push(item);

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() throws Exception {
        return first.pop();
    }

    public int peek() throws Exception {
        return first.peek();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }
}
