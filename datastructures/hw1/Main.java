package AVLTree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(2, "2");
        tree.insert(1, "1");
        tree.insert(3, "3");
        tree.insert(4, "4");
        tree.insert(5, "5");

        System.out.println("Tree:");
        TreePrinter.print(tree);
        System.out.println("With virtual:");
        TreePrinter.printWithVirtual(tree);
        System.out.println("With ranks:");
        TreePrinter.printWithRanks(tree);
        System.out.println("With size:");
        TreePrinter.printWithSize(tree);
    }
}
