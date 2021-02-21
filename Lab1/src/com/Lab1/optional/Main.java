package com.Lab1.optional;

public class Main {
    /*
    Check if the argument is valid
     */
    public static boolean isValid(double number)
    {
        return Math.floor(number) == number && number > 0;
    }


    public static void main(String[] args) {

        double number =Integer.parseInt(args[0]);

        if(isValid(number))
        {  int length=(int)(number);

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
        else
        {
            System.out.println("The argument is not valid!");
        }




    }

}
