import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
         /*
        The function of this main program is to:
        Fill the tree from a file
        Add a value to tree
        Delete a value from the tree
        See if tree contains a value
        Test traversals (pre, in, post)
        Print stats (nodes, leaf nodes, height)
        Clear the tree
        Exit Program
         */
        TreeNode<Integer> a = new TreeNode<Integer>(3, null, null);
        TreeNode<Integer> b = new TreeNode<Integer>(2, null, null);
        TreeNode<Integer> c = new TreeNode<Integer>(1, null, null);

        BST<Integer> elm = new BST<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            // Display the menu
            System.out.println("Welcome! Choose an option:");
            System.out.println("0. Fill the tree from a file.");
            System.out.println("1. Add a value to the tree");
            System.out.println("2. Delete a value from the tree");
            System.out.println("3. Check if the tree contains a value");
            System.out.println("4. Test pre-order traversal");
            System.out.println("5. Test in-order traversal");
            System.out.println("6. Test post-order traversal");
            System.out.println("7. Print stats.");
            System.out.println("8. Clear the tree");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            // Input validation and handling
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch(choice){
                    case 0:
                    case 1:
                        System.out.print("Enter a value to add: ");
                        int value = scanner.nextInt();
                        elm.add(value);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            else{
                System.out.println("Invalid choice. Please enter an integer.");
                scanner.next();
            }
            System.out.println(); // Add a newline for readability
        }
        while (choice != 9);

        scanner.close();
    }
}