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
public class Node<E, F extends Comparable> implements Comparable<Node> {

    Node left;
    Node right;

    E memo;
    F key;

    Node(E element, F key) {
        memo = element;
        this.key = key;
    }

    Node(F key) {
        this.key = key;
    }

    Node() {
    }

    public int compareTo(Node t) {
        return key.compareTo(t.key);
    }

}