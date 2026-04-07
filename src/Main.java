import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
        BST<Integer> elm = new BST<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome! Choose an option:");
        do {
            // Display the menu
            System.out.println("0. Fill the tree from a file.");
            System.out.println("1. Add a value to the tree");
            System.out.println("2. Delete a value from the tree");
            System.out.println("3. Check if the tree contains a value");
            System.out.println("4. Print pre-order traversal");
            System.out.println("5. Print in-order traversal");
            System.out.println("6. Print post-order traversal");
            System.out.println("7. Print stats.");
            System.out.println("8. Clear the tree");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            // Input validation and handling
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch(choice){
                    case 0:
                        File input = new File("/home/username/IdeaProjects/binary-search-tree-Ninjanarwhal41/src/test.txt");
                        try(Scanner reader = new Scanner(input)){
                            System.out.println("Adding the following values from your file:");
                            while(reader.hasNextLine()){
                                int value = reader.nextInt();
                                System.out.println(value + " ");
                                elm.add(value);
                            }
                        }
                        catch(FileNotFoundException e){
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        System.out.print("Enter a value to add: ");
                        int value = scanner.nextInt();
                        elm.add(value);
                        break;
                    case 2:
                        System.out.print("Enter a value to delete: ");
                        int val = scanner.nextInt();
                        elm.delete(val);
                        break;
                    case 3:
                        System.out.print("Enter a value to check if it is in the tree: ");
                        int valu = scanner.nextInt();
                        if (elm.contains(valu)){
                            System.out.println("Success! The tree contains the value " + valu + ".");
                        }
                        else{
                            System.out.println("The tree does not contain the value " + valu + ".");
                        }
                        break;
                    case 4:
                        elm.printPreorder();
                        break;
                    case 5:
                        elm.printInorder();
                        break;
                    case 6:
                        elm.printPostorder();
                        break;
                    case 7:
                        System.out.println("Stats:");
                        System.out.println("Number of Nodes: " + elm.countNodes());
                        System.out.println("Tree Height: " + elm.getHeight());
                        System.out.println("Number of Leaf Nodes: " + elm.countLeafNodes());
                        break;
                    case 8:

                        System.out.println("The tree is now clear.");
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