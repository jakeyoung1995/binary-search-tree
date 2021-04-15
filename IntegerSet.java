public class IntegerSet {

    private Node root;
    
    public IntegerSet(int array[]) {
	//Add elements of array to Binary Search Tree
        constructSet(array);
    }

    private void constructSet(int array[]) {
        for(int i : array) {
            add(i);
        }
    }

    // Adds a new integer to the set without duplicates
    public boolean add(int newItem) {
        if(contains(newItem)) {
            System.out.println("The integer: " + newItem + " is a duplicate and" +
                    " cannot be added");
            return false;
        } else {
            root = insertRec(root, newItem);
            return true;
        }
    }

    // Helper method to insert new data in the correct location as an auto-balanced AVL tree
    private Node insertRec(Node root, int data) {
        if(root == null)
            return(new Node(data));

        if(data < root.data)
            root.left = insertRec(root.left, data);
        else if(data > root.data)
            root.right = insertRec(root.right, data);
        else
            return root;

        root.height = 1 + max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if(balance > 1 && data < root.left.data)
            return rightRotate(root);

        if(balance < -1 && data > root.right.data)
            return leftRotate(root);

        if(balance > 1 && data < root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if(balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    // Determines if the set contains the item in the parameter
    public boolean contains(int itemToFind) {
        return inorderSearch(root, itemToFind);
    }

    // Helper method to perform an in-order traversal search of the set
    private boolean inorderSearch(Node root, int key) {
        if(root != null) {
            if(key == root.data) {
                return true;
            }
            return inorderSearch(root.right, key) || inorderSearch(root.left, key);
        }
        return false;
    }

    // Will return a new set that contains elements from both sets, without duplicates
    public IntegerSet union(IntegerSet other) {
        int i[] = new int[0];
        IntegerSet set = new IntegerSet(i);
        doCopy(root,set);
        doUnion(other.root, set);
        return set;
    }

    // Helper method to copy over non-duplicated integers
    private String doCopy(Node root, IntegerSet set) {
        String data = "";
        if(root != null) {
            set.add(root.data);
            doUnion(root.left, set);
            doUnion(root.right, set);
        }
        return data;
    }

    // Helper method to combine both sets without copying duplicates
    private String doUnion(Node root, IntegerSet set) {
        String data = "";
        if(root != null) {
            if(!set.contains(root.data)) {
                set.add(root.data);
            }
            doUnion(root.left, set);
            doUnion(root.right, set);
        }
        return data;
    }

    // Will return a set that only includes elements that belong to both sets
    public IntegerSet intersection(IntegerSet other) {
        int i[] = new int[0];
        IntegerSet set = new IntegerSet(i);
        doIntersection(root, other, set);
        return set;
    }

    // Recursive helper method to find intersection
    private String doIntersection(Node root, IntegerSet other, IntegerSet set) {
        String data = "";
        if(root != null) {
            if(other.contains(root.data)) {
                set.add(root.data);
            }
            doIntersection(root.left, other, set);
            doIntersection(root.right, other, set);
        }
        return data;
    }

    // toString method to create a string using an inorder traversal
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        constructInOrderString(sb);
        sb.append(')');
        return sb.toString();
    }

    // Helper method to create String
    private void constructInOrderString(StringBuilder sb) {
        inorderRec(root, sb);
    }

    // Helper method to create string using inorder Traversal
    private String inorderRec(Node root, StringBuilder sb) {
        String data = "";
        if(root != null) {
            inorderRec(root.left, sb);
            sb.append(root.data + " ");
            inorderRec(root.right, sb);
        }
        return data;
    }

    // Function to check that the tree is balanced
    public void autoBalance(IntegerSet set) {
        if(isBalanced(set.root)) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }
    }

    // Helper method to determine if the tree is balanced
    private boolean isBalanced(Node root) {
        int lh; // Height of the left subtree
        int rh; // Height of the right subtree
        if(root == null) {
            return true;
        }

        lh = height(root.left);
        rh = height(root.right);

        if(Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    // Helper method to identify the height of the node
    private int height(Node N) {
        if(N == null)
            return 0;

        return N.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(Node N) {
        if(N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    private class Node {
        int data;
        int height;
        Node left;
        Node right;


        Node(int data) {
            this.data = data;
            left = right = null;
            height = 1;
        }
    }

}
