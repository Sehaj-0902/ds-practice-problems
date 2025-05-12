import java.util.*;
import java.io.*;

class Node2 {
    Node2 left;
    Node2 right;
    int data;

    Node2(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeTopView {
    /*

    class Node2
    	int data;
    	Node2 left;
    	Node2 right;
	*/
    public static void topView(Node2 root) {
        if (root == null) {
            return;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node2> queue = new LinkedList<>();
        Queue<Integer> distance = new LinkedList<>();

        queue.add(root);
        distance.add(0);

        while (!queue.isEmpty()) {
            Node2 currNode = queue.poll();
            int currDistance = distance.poll();

            if (!map.containsKey(currDistance)) {
                map.put(currDistance, currNode.data);
            }

            if (currNode.left != null) {
                queue.add(currNode.left);
                distance.add(currDistance - 1);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
                distance.add(currDistance + 1);
            }
        }

        for (int i : map.keySet()) {
            System.out.print(map.get(i) + " ");
        }
    }

    public static Node2 insert(Node2 root, int data) {
        if(root == null) {
            return new Node2(data);
        } else {
            Node2 cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node2 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}