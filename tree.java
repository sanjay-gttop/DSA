public class Tree {

    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    public void insert(int data) {
        root = insertion(root, data);
    }

    public Node insertion(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } 
        else if (data < node.data) {
            node.left = insertion(node.left, data);
        } 
        else if (data > node.data) {
            node.right = insertion(node.right, data);
        }
        return node;
    }

    public void delete(int data) {
        root = deletion(root, data);
    }

    public Node deletion(Node node, int data) {
        if (node == null) {
            return null;
        } 
        else if (data < node.data) {
            node.left = deletion(node.left, data);
        } 
        else if (data > node.data) {
            node.right = deletion(node.right, data);
        } 
        else {
            // node with only one child or no child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // node with two children
            node.data = minValue(node.right);
            node.right = deletion(node.right, node.data);
        }
        return node;
    }

    public int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public boolean search(int data) {
        return searching(root, data);
    }

    public boolean searching(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        else if (data < node.data) {
            return searching(node.left, data);
        }
        else {
            return searching(node.right, data);
        }
    }

    public void inorder() {
        inorderTraversal(root);
        System.out.println();
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void preorder() {
        preorderTraversal(root);
        System.out.println();
    }

    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorder() {
        postorderTraversal(root);
        System.out.println();
    }

    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();

        t.insert(50);
        t.insert(30);
        t.insert(70);
        t.insert(20);
        t.insert(40);
        t.insert(60);
        t.insert(80);

        System.out.print("Inorder: ");
        t.inorder();

        System.out.print("Preorder: ");
        t.preorder();

        System.out.print("Postorder: ");
        t.postorder();

        System.out.println("Search 40: " + t.search(40));
        System.out.println("Search 100: " + t.search(100));

        t.delete(20);
        System.out.print("After deleting 20: ");
        t.inorder();

        t.delete(30);
        System.out.print("After deleting 30: ");
        t.inorder();

        t.delete(50);
        System.out.print("After deleting 50: ");
        t.inorder();
    }
}