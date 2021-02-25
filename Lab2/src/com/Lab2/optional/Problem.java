package com.Lab2.optional;



import java.util.Vector;

public class Problem {
    //class members
    String[][] costMatrix = new String[10][10];
    Vector<Source> allSources = new Vector<>(10);
    Vector<Destination> allDestinations = new Vector<>(10);

    //class methods
    /*
    This function is adding sources to a vector with sources and tests if a source already exists
     */
    public void addSource(Source source) {
        if (!allSources.contains(source))
            allSources.add(source);
        else {
            System.out.println("Source (" + source + ") already exists");
        }
    }

    /*
    This function is adding destinations to a vector with destinations and tests if a destination already exists
     */
    public void addDestinations(Destination destination) {
        if (!allDestinations.contains(destination))
            allDestinations.add(destination);
        else {
            System.out.println("Destination already exists");
        }
    }

    /*
     This function creates the cost matrix
     */
    public void createMatrix() {
        for (int i = 0; i <= allSources.size() + 1; i++) {
            for (int j = 0; j <= allDestinations.size() + 1; j++) {
                costMatrix[i][j] = " 0";
            }

        }
        for (int i = 1; i <= allSources.size(); i++) {
            costMatrix[i][0] = allSources.get(i - 1).getName();
            costMatrix[i][allDestinations.size() + 1] = String.valueOf(allSources.get(i - 1).getSupply());

        }
        for (int i = 1; i <= allDestinations.size(); i++) {
            costMatrix[0][i] = allDestinations.get(i - 1).getName();
            costMatrix[allSources.size() + 1][i] = String.valueOf(allDestinations.get(i - 1).getDemand());

        }

        for (int i = 0; i <= allSources.size() + 1; i++) {
            for (int j = 0; j <= allDestinations.size() + 1; j++) {
                System.out.print(costMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }


}
