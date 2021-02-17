package com.Lab1.optional;

public class Main {

    public static void main(String[] args) {

        int length =10;
        GRAPH firstGraph= new GRAPH(length);
        firstGraph.randomGraph();
        firstGraph.printMatrix();
        firstGraph.connectedComponentsFunction();

        if(firstGraph.getNumberOfComponents()==1)
        {
            System.out.println("Graph connected");
            firstGraph.createTreeMatrix();
            firstGraph.printTreeMatrix();
        }
        else
        {
            System.out.println("Graph connected components:");
            firstGraph.printConnectedComponents();

        }




    }

}
