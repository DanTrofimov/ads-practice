import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        BinaryTree bin = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            bin.add(arr[i]);
        }
        bin.delete(1);
        bin.breadthFirstSearch();
        System.out.println();
        bin.deepFirstSearch(bin.root);
    }

    // корневой элемент
    public Node root;

    // элемент дерева
    class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    // конструкторы
    public BinaryTree() {
        this.root = null;
    };

    public BinaryTree(int root) {
        add(root);
    }

    // добавление элемента
    public Node addNode(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.value) {
            currentNode.left = addNode(currentNode.left, value);
        } else if (currentNode.value < value) {
            currentNode.right = addNode(currentNode.right, value);
        } else return currentNode;
        return currentNode;
    }

    public void add(int value) {
        root = addNode(root, value);
    }

    // удаление элемента
    public Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (value == currentNode.value) {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            if (currentNode.right == null) {
                return currentNode.left;
            }
            if (currentNode.left == null) {
                return currentNode.right;
            }
            int smallestValue = findSmallestValue(currentNode.right);
            currentNode.value = smallestValue;
            currentNode.right = deleteNode(currentNode.right, smallestValue);
            return currentNode;
        }
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
            return currentNode;
        }
        currentNode.right = deleteNode(currentNode.right, value);
        return currentNode;
    }

    public int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

     // DFS
     public void deepFirstSearch(Node node) {
         if (node != null) {
             deepFirstSearch(node.left);
             System.out.print(node.value + " ");
             deepFirstSearch(node.right);
         }
     }

     // BFS
    public void breadthFirstSearch() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(node.value + " ");
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }
}
