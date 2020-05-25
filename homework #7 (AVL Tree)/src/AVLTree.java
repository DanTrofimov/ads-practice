class AVLTree {

    // корневой элемент
    Node root;

    // высота дерева
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // поворот по часовой
    private Node rotateToRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    // поворот против часовой
    private Node rotateToLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // балансировка дерева
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // вставка элемента
    public Node insertNode(Node node, int key) {
        if (node == null)
            return (new Node(key));
        if (key < node.key) node.left = insertNode(node.left, key);
        else if (key > node.key) node.right = insertNode(node.right, key);
        else return node;
        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
            return rotateToRight(node);
        if (balance < -1 && key > node.right.key)
            return rotateToLeft(node);
        if (balance > 1 && key > node.left.key) {
            node.left = rotateToLeft(node.left);
            return rotateToRight(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rotateToRight(node.right);
            return rotateToLeft(node);
        }
        return node;
    }

    // минимальный элемент дерева
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // удаление элемента
    Node removeNode(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) root.left = removeNode(root.left, key);
        else if (key > root.key)
            root.right = removeNode(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node element = null;
                if (element == root.left)
                    element = root.right;
                else element = root.left;
                if (element == null) {
                    element = root;
                    root = null;
                }
                else root = element;
            }
            else {
                Node element = minValueNode(root.right);
                root.key = element.key;
                root.right = removeNode(root.right, element.key);
            }
        }
        if (root == null) return root;
        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateToRight(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateToLeft(root.left);
            return rotateToRight(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) return rotateToLeft(root);
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rotateToRight(root.right);
            return rotateToLeft(root);
        }
        return root;
    }

    // класс элемента дерева
    private class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int d) {
            this.key = d;
            this.height = 1;
        }
    }
}

