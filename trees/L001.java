
import java.util.*;

public class L001 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, -1, -1, -1, 3, -1, -1 };
        Node root = constructTree(arr);
        System.out.println(size(root));
        // display(root);
    }

    public static class Node {
        int val = 0;
        Node left;
        Node right;

        Node(int data) {
            this.val = data;
        }
    }

    static int idx = 0;

    public static Node constructTree(int[] arr) {
        if (idx >= arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node root = new Node(arr[idx]);
        idx++;
        root.left = constructTree(arr);
        root.right = constructTree(arr);
        return root;
    }

    public static void display(Node root) {
        if (root == null)
            return;
        String ans = "";
        if (root.left != null)
            ans += root.left.val;
        ans += " <--- ";
        ans += root.val;
        ans += " ---> ";
        if (root.right != null)
            ans += root.right.val;
        System.out.println(ans);
        display(root.left);
        display(root.right);
    }

    public static int size(Node root) {
        if (root == null)
            return 0;
        int lftsize = size(root.left);
        int rightsiz = size(root.right);
        return lftsize + rightsiz + 1;
    }

    public static int maximum(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int leftmax = maximum(root.left);
        int rightmax = maximum(root.right);
        return Math.max(leftmax, Math.max(rightmax, root.val));
    }

    public static int minimum(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int leftmax = minimum(root.left);
        int rightmax = minimum(root.right);
        return Math.min(leftmax, Math.min(rightmax, root.val));
    }

    public static int height(Node root) {
        if (root == null)
            return -1;
        int lftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(lftheight, rightheight) + 1;
    }

    static int flevel = -1;

    public static boolean find(Node root, int ele, int level) {

        if (root == null)
            return false;
        if (root.val == ele) {
            flevel = level;
            return true;
        }
        return find(root.left, ele, level + 1) || find(root.right, ele, level + 1);
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static boolean roottoNode(Node root, int givenval, ArrayList<Node> list) {
        if (root == null)
            return false;
        if (root.val == givenval) {
            list.add(root);
            return true;
        }
        boolean res = roottoNode(root.left, givenval, list) || roottoNode(root.right, givenval, list);
        if (res)
            list.add(root);
        return res;
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;

        int lefthei = height(root.left);
        int righthei = height(root.right);
        int mydia = lefthei + righthei + 2;
        int leftdia = diameter(root.left);
        int rightdia = diameter(root.right);

        int temp = Math.max(mydia, rightdia);
        return Math.max(leftdia, temp);
    }

    public static void levelorder(Node root) {
        ArrayList<Node> pque = new ArrayList<>();
        ArrayList<Node> sque = new ArrayList<>();
        int level = 0;
        pque.add(root);
        while (pque.size() != 0) {
            Node frnt = pque.remove(pque.size() - 1);
            System.out.print(frnt.val + " ");
            if (frnt.left != null)
                sque.add(frnt.left);
            if (frnt.right != null)
                sque.add(frnt.right);

            if (pque.size() == 0 && sque.size() != 0) {
                ArrayList<Node> temp = sque;
                sque = pque;
                pque = temp;
                level++;
                System.out.println();
                System.out.println("level: " + level + "-->");
            }
        }
    }


    
}