/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.util.List;

/**
 *
 * @author xhu
 */
public class Maze extends Thread {

    List<Node> nodes;
    List<Node> solutionPath;

    Panel panel;

    Node startNode;
    Node exitNode;

    public Maze(List<Node> nodes, Panel panel) {
        this.nodes = nodes;
        this.panel = panel;

    }

    public Maze() {
    };

    public void run() {

    }

}
