/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.util.ArrayList;

/**
 *
 * @author xhu
 */
public class Node {

    private String name;
    private int x, y;
    private ArrayList<Node> adjacencies;
    private Node parent;

    private boolean visited;
    private boolean isStartNode;
    private boolean isEndNode;

    Node(String name, int x, int y) {

        this.name = name;
        this.x = x;
        this.y = y;

        adjacencies = new ArrayList<Node>();

        this.parent = null;
        this.visited = false;

        this.isStartNode = name.equalsIgnoreCase("START");
        this.isEndNode = name.equalsIgnoreCase("EXIT");

    }

    public void addAdjacency(Node nodeToAdd) {
        if (nodeToAdd != null && !adjacencies.contains(nodeToAdd)) {
            adjacencies.add(nodeToAdd);
        }
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Node> getAdjacencies() {
        return adjacencies;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isStartNode() {
        return isStartNode;
    }

    public boolean isEndNode() {
        return isEndNode;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
