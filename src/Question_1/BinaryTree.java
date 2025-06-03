/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.function.Consumer;

/**
 *
 * @author xhu
 */
public class BinaryTree<E, F extends Comparable> {

    Node root;
    int numberOfNodes;
    boolean reversed = false;

    public BinaryTree(Node node) {
        root = node;
    }

    public BinaryTree(E element, F key) {
        root = new Node(element, key);
    }

    public BinaryTree() {
    }

    public void addElement(E element, F key) {

        // create a new node that holds the key and element we want to add

        Node newNode = new Node(element, key);

        // if the tree is empty and does not have a root node, we do not need the
        // recursive helper function, so we can just set the root as our new node and
        // return. Else, we must use the private addNode recursive helper method.

        if (root == null) {
            root = newNode;
            numberOfNodes++;
        } else {
            addNode(root, newNode);
        }

    }

    private void addNode(Node root, Node node) {

        // store the value of the comparison between the two nodes in a variable to
        // avoid repeat calculations.

        int comparison = node.compareTo(root);

        // if node precedes the root, go left. If left null we can simply add node,
        // else we must call this method again with roots left child. Once node has been
        // added, increment node count.

        if (comparison < 0) {
            if (root.left == null) {
                root.left = node;
                numberOfNodes++;
            } else {
                addNode(root.left, node);
            }

            // if the condition is not met then node is greater than root or equal, so go
            // right. If right null we can simply add node, else we must call this method
            // again with roots right child. Once node has been added, increment node count.

        } else {
            if (root.right == null) {
                root.right = node;
                numberOfNodes++;
            } else {
                addNode(root.right, node);
            }

        }

    }

    // for your debugging
    public void traversal(Node root, Consumer<Node> action) {

        // The base case is when we have passed a leaf node, so current is null.

        if (root == null) {
            return;
        }

        // If we have gotten past the null check, that means we should check if there is
        // a node further left.

        traversal(root.left, action);

        // We then use the lambda given to us as a parameter that defines what action
        // to perform with this node.

        action.accept(root);

        // We then attempt to navigate right.

        traversal(root.right, action);

        // This is an example of in-order traversal that follows the pattern:
        // process left child, process current node, then process right child. LNR

    }

    public Node[] toSortedList() {

        Node[] inOrderNodes = new Node[numberOfNodes];

        // An int array of size 1 is created to hold the index, as the lambda knows
        // about variables that are final or effectively final. While the value within
        // the array is mutable, the reference to the array is final.

        int[] index = { 0 };

        // Call the traversal method, and give the lambda that adds the nodes to an
        // array as a parameter using the consumer library.

        traversal(root, a -> {
            inOrderNodes[index[0]++] = a;
        });

        return inOrderNodes;
    }

    public E searchElement(F key) {

        Node<E, F> toReturn = searchNode(root, new Node((F) key));

        if (toReturn == null) {
            return null;
        } else {
            return toReturn.memo;
        }

    }

    public Node searchNode(Node root, Node node) {

        // base case: root == null. This means that we have passed a leaf node, and no
        // matching node has been found. Return null.

        if (root == null) {
            return null;
        }

        // Set the comparison variable to regular compareTo functionallity if the tree
        // has not been reversed, but if the tree has been reversed, set the variable to
        // follow the opposite ordering.

        int comparison = reversed ? root.key.compareTo(node.key) : node.key.compareTo(root.key);

        // If the compareTo method returns 0, we know we have found the correct node and
        // can now return.

        if (comparison == 0) {
            return root;
        }

        // Depending on the state of the tree, go left if that is where the node would
        // be expected, or go right.

        return comparison < 0 ? searchNode(root.left, node) : searchNode(root.right, node);

    }

    public void reverseOrder() {

        // call the recursive helper function with the root of this tree. Then change
        // the reversed flag.

        reverseOrder(root);
        reversed = !reversed;
    }

    private void reverseOrder(Node root) {

        // this is the base case. If we reach a node and it value is null, we have gone
        // past a leaf node, so this method call path can finish.

        if (root == null) {
            return;
        }

        // swap this nodes left child with its right child using a code block for the
        // temporary node variable.

        {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        // traverse down what used to be the right side of the tree first (now the left
        // side of the tree),swapping children then navigating deeper untill the base
        // case (node == null) is reached. Then once the left side of the new tree has
        // been fully explored, it will go back one level, then navigate right from
        // there. This will then continue all the way across the tree.

        reverseOrder(root.left);
        reverseOrder(root.right);
    }

}
