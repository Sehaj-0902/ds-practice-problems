import java.util.*;
import java.io.*;

class Node1 {
    Node1 left;
    Node1 right;
    int data;

    Node1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LevelOrderTraversal {
    /*

    class Node1
    	int data;
    	Node1 left;
    	Node1 right;
	*/
    public static void levelOrder(Node1 root) {
        if (root == null) {
            return;
        }

        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node1 currNode = queue.remove();

            System.out.print(currNode.data + " ");

            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
    }

    public static Node1 insert(Node1 root, int data) {
        if(root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
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
        Node1 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}