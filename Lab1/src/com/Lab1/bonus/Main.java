package com.Lab1.bonus;
import com.Lab1.optional.GRAPH;

public class Main {
    /*
     Creates a random node tree
    */
    public static void randomTree(int length)
    {
        GRAPH tree = new GRAPH(length);
        tree.randomGraph();
        tree.connectedComponentsFunction();
        int connectedComponents=tree.getNumberOfComponents();
        while(connectedComponents!=1)
        {
            tree.randomGraph();
            tree.connectedComponentsFunction();
            connectedComponents=tree.getNumberOfComponents();
        }
        tree.createTreeMatrix();
        tree.printTreeMatrix();
        tree.printTreeText(0);


    }

    public static void main(String[] args) {
        System.out.println("Random tree generated and textual representation");
        randomTree(7);

    }
}
