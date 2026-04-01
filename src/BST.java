public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BST() {
        size = 0;
    }

    public void add(E value){
        TreeNode<E> newNode = new TreeNode<E>(value, null, null);
        TreeNode<E> curr = root;
        if(root == null){
            root = newNode;
        }
        while(curr != null){
          if(curr.getValue().compareTo(value) > 0 && curr.getLeftChild() != null){
              curr = curr.getLeftChild();
          }
          else if(curr.getValue().compareTo(value) <= 0 && curr.getRightChild() != null){
              curr = curr.getRightChild();
          }
        }
        if (curr.getValue().compareTo(value) > 0){
            curr.setRightChild(newNode);
        }
        else{
            curr.setLeftChild(newNode);
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
    void printInorder(){
        System.out.println();
    }
    void printPreorder(){
        System.out.println();
    }
    void printPostorder(){
        System.out.println();
    }
    E delete(E value){
        return null;
    }
}
