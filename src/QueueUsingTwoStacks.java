import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Integer> enqueue = new Stack<>();
        Stack<Integer> dequeue = new Stack<>();

        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();

            if (query == 1) {
                int element = sc.nextInt();
                enqueue.push(element);
            }

            else if (query == 2) {
                if (dequeue.isEmpty()) {
                    while (!enqueue.isEmpty()) {
                        dequeue.push(enqueue.pop());
                    }
                }
                dequeue.pop();
            }

            else if (query == 3) {
                if (dequeue.isEmpty()) {
                    while (!enqueue.isEmpty()) {
                        dequeue.push(enqueue.pop());
                    }
                }
                System.out.println(dequeue.peek());
            }
        }
        sc.close();
    }
}