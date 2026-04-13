public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BST() {
        size = 0;
    }

    /** places a value into a binary tree in its proper place to follow binary tree conventions
     * @param value the value to be added to the binary tree
     */
    public void add(E value) {
        TreeNode<E> newNode = new TreeNode<E>(value, null, null);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        TreeNode<E> curr = root;
        TreeNode<E> parent = null;

        while (curr != null) {
            parent = curr;
            if (value.compareTo(curr.getValue()) > 0) {
                curr = curr.getRightChild();
            } else if (value.compareTo(curr.getValue()) <= 0) {
                curr = curr.getLeftChild();
            }
        }
        if (value.compareTo(parent.getValue()) > 0) {
            parent.setRightChild(newNode);
        } else {
            parent.setLeftChild(newNode);
        }
        size++;
    }

    /**
     * @param value the value to be checked
     * @return a boolean that is true if the tree contains value and false otherwise.
     */
    public boolean contains(E value) {
        if (root == null){
            return false;
        }
        TreeNode<E> curr = root;
        while (curr != null) {
            if (value.compareTo(curr.getValue()) == 0) {
                return true;
            }
            if (value.compareTo(curr.getValue()) < 0) {
                curr = curr.getLeftChild();
            }
            else if (value.compareTo(curr.getValue()) > 0) {
                curr = curr.getRightChild();
            }

        }
        return false;
    }

    /**
     * counts the number of nodes in a tree
     * @return a count of the number of nodes the binary tree contains
     */
    public int countNodes() {
        return size;
    }
    /**
     * @return countLeafNodes called at the root node, 0 if the root is null and therefore the tree is empty.
     */
    public int countLeafNodes() {
        if(root == null){
            return 0;
        }
        return countLeafNodes(root);
    } //returns the number of leaf nodes in tree

    /**
     * recursive private helper method to count how many leaf nodes there are (nodes with no children).
     * @param node a given TreeNode
     * @return countLeafNodes of the left child plus the right child.
     */
    private int countLeafNodes(TreeNode<E> node) {
        if (node == null){
            return 0;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 1;
        }
        return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getRightChild());
    }


    /**
     * @return getHeight at the root node, 0 if the tree is empty.
     */
    public int getHeight() {
        if (root == null) {
            return 0;
        }
        return getHeight(root);
    } //returns the longest path from the root to a leaf node

    /**
     * @param node a given TreeNode
     * @return 1 plus the highest height between the left and right branches.
     */
    private int getHeight(TreeNode<E> node){
        //base case
        if (node == null){
            return 0;
        }
        return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
    }

    public void printPreorder() {
        if (root == null) {
            System.out.println("Empty!");
        } else {
            printPreorder(root);
            System.out.println();
        }
    }

    private void printPreorder(TreeNode<E> node) {
        //base case
        if (node == null) {
            return;
        }
        //root first
        System.out.print(node.getValue() + " ");

        //left
        printPreorder(node.getLeftChild());


        //right
        printPreorder(node.getRightChild());
    }

    public void printInorder() {
        if (root == null) {
            System.out.println("Empty!");
        } else {
            printInorder(root);
            System.out.println();
        }
    }

    private void printInorder(TreeNode<E> node) {
        //base case
        if (node == null) {
            return;
        }

        //left
        printInorder(node.getLeftChild());
        //root
        System.out.print(node.getValue() + " ");
        //right
        printInorder(node.getRightChild());

    }

    public void printPostorder() {
        if (root == null) {
            System.out.println("Empty!");
        }
        else {
            printPostorder(root);
        }
    }

    private void printPostorder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        //left
        printPostorder(node.getLeftChild());
        //right
        printPostorder(node.getRightChild());
        //root
        System.out.print(node.getValue() + " ");
    }
    public E delete(E value){
        if(!contains(value)){
            System.out.println("The value is not in the tree!");
            return null;
        }
        if(root == null){
            System.out.println("You can't remove values from an empty tree!");
            return null;
        }
        TreeNode<E> curr = root;
        TreeNode<E> parent = null;
        int pos = 0;
        while (true) {

            if (value.compareTo(curr.getValue()) > 0) {
                parent = curr;
                pos = 1;
                curr = curr.getRightChild();
            }
            else if (value.compareTo(curr.getValue()) < 0) {
                parent = curr;
                pos = -1;
                curr = curr.getLeftChild();
            }
            else{
                break;
            }
        }
        //find the node we're trying to remove.

        //if the node is a leaf node, delete it.
        if(curr.getRightChild() == null && curr.getLeftChild() == null){
            if(pos == 1){
                parent.setRightChild(null);
            }
            else if(pos == -1){
                parent.setLeftChild(null);
            }
            else{
                root = null;
            }
        }
        //if the node has one child, replace it with the child.
        else if((parent.getRightChild() == null && parent.getLeftChild() != null)){
            parent = parent.getLeftChild();
        }
        else if((parent.getLeftChild() == null && parent.getRightChild() != null)){
            parent = parent.getRightChild();
        }
        else{
            parent.setValue(parent.getLeftChild().getValue());
        }
        size--;
        return value;
    }

    /**
     *
     */
    public void clearTree(){
        root = null;
        System.out.println("The tree is now clear.");
    }
}
