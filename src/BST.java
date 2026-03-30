public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private TreeNode<E>[] data;
    private int size;

    public BST(TreeNode<E>[] data) {
        this.data = data;
        size = data.length;
        root = data[0];
    }

    public void add(E value){
        TreeNode<E> temp = root;
        TreeNode<E> newNode = new TreeNode<E>(value, null, null);
        if(root == null){
            root = newNode;
            root.setLeftChild(null);
            root.setRightChild(null);
        }

        if(value.compareTo(root.getValue()) > 0){
            if (temp != null && temp.getLeftChild() == null){
                temp.setLeftChild(newNode);
            }
            while(value.compareTo(temp.getValue()) > 0){

            }
        }
        else{
            if (temp != null && temp.getLeftChild() == null){
                temp = temp.getLeftChild();
            }

        }


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
        while(temp != null && temp.getLeftChild() != null && temp.getRightChild() != null){
            temp = temp.getLeftChild();
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
