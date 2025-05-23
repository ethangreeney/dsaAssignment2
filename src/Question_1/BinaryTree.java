/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 */
public class BinaryTree<E, F extends Comparable> {

    Node root;
    int numberOfNodes;
    Node[] nodeList;

    public BinaryTree(Node node) {
        root = node;
    }

    public BinaryTree(E element, F key) {
        root = new Node(element, key);
    }

    public BinaryTree() {
    }

    public void addElement(E element, F key) {

        Node newNode = new Node(element, key);

        if (root == null) {
            root = newNode;
            numberOfNodes++;
        } else {
            addNode(root, newNode);
        }

    }

    private void addNode(Node root, Node node) {

        int comparison = node.compareTo(root);

        if (comparison < 0) {
            if (root.left == null) {
                root.left = node;
                numberOfNodes++;
            } else {
                addNode(root.left, node);
            }

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
    public void traversal(Node root) {

    }

    public Node[] toSortedList() {
        return null;
    }

    private void toSortedList(Node root) {

    }

    public E searchElement(F key) {
        return null;
    }

    public Node searchNode(Node root, Node node) {
        return null;
    }

    public void reverseOrder() {
        reverseOrder(root);
    }

    private void reverseOrder(Node root) {

        // this is the base case. If we reach a node and it value is null, we have gone
        // past a leaf node, so this method call path can finish.

        if (root == null) {
            return;
        }

        // swap this nodes left child with its right child.

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // traverse down what used to be the right side of the tree first (now the left
        // side of the tree),swapping children then navigating deeper untill the base
        // case (node == null) is reached. Then once the left side of the new tree has
        // been fully explored, it will go back one level, then navigate right from
        // there. This will then continue all the way across the tree.

        reverseOrder(root.left);
        reverseOrder(root.right);
    }

}
