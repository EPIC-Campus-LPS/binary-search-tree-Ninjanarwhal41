public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BST() {
        size = 0;
    }

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

    public int countNodes() {
        return size;
    }
    //returns the number of nodes in the tree, stored in the private instance variable size.

    public int countLeafNodes() {
        if(root == null){
            return 0;
        }
        return countLeafNodes(root);
    } //returns the number of leaf nodes in tree

    private int countLeafNodes(TreeNode<E> node) {
        if (node == null){
            return 0;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 1;
        }
        return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getRightChild());
    }


    public int getHeight() {
        if (root == null) {
            return 0;
        }
        return getHeight(root);
    } //returns the longest path from the root to a leaf node

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
        System.out.print(node.getValue() + ", ");

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
        String result = "";
        if (node == null) {
            return;
        }

        //left
        printInorder(node.getLeftChild());
        //root
        System.out.print(node.getValue() + ", ");
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
            }else{
                break;
            }
        }
        //find the node we're trying to remove.

        //if the node is a leaf node, delete it.
        if(curr.getLeftChild() == null && curr.getRightChild() == null){
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
}
