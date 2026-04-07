public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BST() {
        size = 0;
    }

    public TreeNode<E> getRoot(){
        return root;
    }
    public void add(E value){
        TreeNode<E> newNode = new TreeNode<E>(value, null, null);
        
        if(root == null){
            root = newNode;
            size++
            return;
        }
        
        TreeNode<E> curr = root;
        TreeNode<E> parent = null;
        
        while(curr != null){
            parent = curr;
          if(value.compareTo(curr.getValue()) > 0){
              curr = curr.getRightChild();
          }
          else if(value.compareTo(curr.getValue()) <= 0){
              curr = curr.getLeftChild();
          }
        }
        if (value.compareTo(parent.getValue()) > 0){
            parent.setRightChild(newNode);
        }
        else{
            parent.setLeftChild(newNode);
        }
        size++;
    }
    public boolean contains(E value){
        return false;
    }
    public int countNodes(){
        int count = 1;
        TreeNode<E> temp = root;
        if(root == null){
            return 0;
        }
        if(root.getLeftChild() == null && root.getRightChild() == null){
            return count;
        }
        while(temp != null){
            count++;
        }
        return count;
    } //returns the number of nodes in the tree

    int countLeafNodes(){
        return 0;
    } //returns the number of leaf nodes in tree
    int getHeight(){
        if (root == null){
            return 0;
        }

        return 0;
    } //returns the longest path from the root to a leaf node
    public void printPreorder() {
        if(root == null){
            System.out.println("Empty!");
        }
        else{
            printPreorder(root);
            System.out.println();
        }
    }
    private void printPreorder(TreeNode<E> node){
        //base case
        if(node == null){
            return;
        }
        //root first
        System.out.print(node.getValue() + ", ");

        //left
        printPreorder(node.getLeftChild());

        //right
        printPreorder(node.getRightChild());
    }
    public void printInorder(TreeNode<E> node){
        if(root == null){
            System.out.println("Empty!");
            return;
        }
        if(node != null){
            printInorder(node.getLeftChild());
            System.out.print(node.getValue() + ", ");
            printInorder(node.getRightChild());
        }
    }

    public void printPostorder(TreeNode<E> node){
        if(root == null){
            System.out.println("Empty!");
            return;
        }
        if(node != null){
            printPostorder(node.getLeftChild());
            printPostorder(node.getRightChild());
            System.out.print(node.getValue() + ", ");
        }
    }
    public E delete(E value){
        if(root == null){
            return null;
        }
        return value;
    }
}
