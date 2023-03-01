package CourseWork3;

import java.util.HashMap;

public class NodeListTree {
    public NodeList val;
    public NodeListTree left, right;
    HashMap<Character, Integer> map = new HashMap<>();

    // Constructor for situation 1 (input includes val, left, and right).
    public NodeListTree(NodeList val, NodeListTree left, NodeListTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    // Constructor for situation 2 (input only includes val).
    public NodeListTree(NodeList val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static String printFirst(NodeListTree root) {
        // If the root is null, then return an empty String.
        if (root == null) {
            return "";
        }
        // Initialize an output variable to the first value of the root's NodeList.
        String output = root.val.value;
        // Judge whether change the output.
        if (root.left != null) {
            output += printFirst(root.left);
        }
        if (root.right != null) {
            output += printFirst(root.right);
        }
        // Return the output.
        return output;
    }

    public static String printSecond(NodeListTree root) {
        // If the root is null, then return an empty String.
        if (root == null) {
            return "";
        }
        // Initialize an output variable to the second value of the root's NodeList.
        String output = root.val.next.value;
        // Judge whether change the output.
        if (root.left != null) {
            output += printSecond(root.left);
        }
        if (root.right != null) {
            output += printSecond(root.right);
        }
        // Return the output.
        return output;
    }

    public static int returnAns(NodeListTree root, char aim) {
        // If the root is null, return 0.
        if (root == null) {
            return 0;
        }
        // Initialize a count variable to 0.
        int count = 0;
        // Judge whether to increase count.
        if (root.val.next.value.toLowerCase().equals(aim)) {
        } else{
            count++;
        }
        if (root.left != null) {
            count ++;
        }
        if (root.right != null) {
            count ++;
        }
        // Return the total count.
        return count;
    }

    public static void main(String[] args) {
        // Create the NodeList objects.
        NodeList A = new NodeList("A", new NodeList("Hello", null));
        NodeList B = new NodeList("B", new NodeList("Everyone", null));
        NodeList C = new NodeList("C", new NodeList("Welcome", null));
        NodeList D = new NodeList("D", new NodeList("To", null));
        NodeList E = new NodeList("E", new NodeList("This", null));
        NodeList F = new NodeList("F", new NodeList("Course", null));

        // Create the NodeListTree object.
        NodeListTree root = new NodeListTree(A,
                new NodeListTree(B,
                        new NodeListTree(D),
                        new NodeListTree(E)),
                new NodeListTree(C,
                        null,
                        new NodeListTree(F))
        );
        // Print the results.
        System.out.println(printFirst(root));
        System.out.println(printSecond(root));
        System.out.println(returnAns(root,'c'));
    }
}