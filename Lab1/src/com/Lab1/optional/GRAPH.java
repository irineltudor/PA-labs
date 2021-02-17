package com.Lab1.optional;

public class GRAPH {
    int dimensions = 1000;
    int length;
    int[][] matrix = new int[dimensions][dimensions];
    int[] connectedComponents = new int[dimensions];
    int[][] treeMatrix = new int[dimensions][dimensions];
    int numberOfComponents;


    // Constructor
    public GRAPH(int length) {
        this.length = length;
    }

    /*
        Generates a random graph
    */
    public void randomGraph() {
        for (int i = 0; i < this.length; i++) {
            matrix[i][i] = 0;
            for (int j = i + 1; j < this.length; j++) {
                if (Math.random() < 0.5) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;


                } else {
                    matrix[i][j] = 0;
                    matrix[j][i] = 0;
                }

            }
        }


    }

    /*
        Prints the generated matrix
     */
    public void printMatrix() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++)
                System.out.print(this.matrix[i][j] + " ");
            System.out.println();
        }

    }

    /*
        DFS algorithm
    */

    public void recursiveDFS(int index, int number) {
        this.connectedComponents[index] = number;
        for (int i = 0; i < this.length; i++) {
            if (matrix[index][i] == 1) {
                if (this.connectedComponents[i] == 0) {
                    recursiveDFS(i, number);
                }
            }
        }

    }

    /*
        Finds how much connected components a Graph has and what are the components
     */

    public void connectedComponentsFunction() {
        int number = 0;
        for (int i = 0; i < this.length; i++)
            this.connectedComponents[i] = number;

        for (int i = 0; i < this.length; i++) {
            if (this.connectedComponents[i] == 0) {
                number++;
                recursiveDFS(i, number);


            }

        }
        this.numberOfComponents = number;

    }

    /*
        Displays the connected components
     */

    public void printConnectedComponents() {
        int nr = 0;
        while (nr < numberOfComponents) {
            nr++;
            System.out.print(nr + ": ");
            for (int i = 0; i < this.length; i++) {
                if (connectedComponents[i] == nr)
                    System.out.print(i + " ");

            }
            System.out.println();

        }

    }

    //Getter
    public int getNumberOfComponents() {
        return this.numberOfComponents;
    }

    /*
        Recursive method that creates the parent vector
     */
    private void createTree(int index, boolean[] isVisited, int[] parent) {
        for (int i = 0; i < this.length; i++) {
            if (matrix[index][i] == 1) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    parent[i] = index;
                    createTree(i, isVisited, parent);
                }
            }
        }

    }

    /*
        Creates the adjaceny matrix for the tree
    */

    public void createTreeMatrix() {
        if (numberOfComponents > 1) {
            System.out.println("Cannot create a tree, your graph is not connected!");
        } else {
            boolean[] isVisited = new boolean[length];
            int[] parent = new int[length];
            parent[0] = -1;
            isVisited[0] = true;
            createTree(0, isVisited, parent);
            for (int i = 0; i < length; i++) {
                if (parent[i] >= 0) {
                    this.treeMatrix[parent[i]][i] = 1;
                    this.treeMatrix[i][parent[i]] = 1;

                }
            }


        }
    }

    /*
        Prints the tree matrix
     */
    public void printTreeMatrix() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++)
                System.out.print(this.treeMatrix[i][j] + " ");
            System.out.println();
        }

    }

}

