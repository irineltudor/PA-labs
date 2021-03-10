package com.Lab3;
public class TravelPlan {
    private String name;
    private City city = new City();
    private int[] preferences=new int[100];

    //Constructor
    TravelPlan() {
    }

    TravelPlan(String name, City a) {
        this.city = a;
        this.name = name;
    }

   //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPreferences(int[] preferences) {
        this.preferences = preferences;
    }

    //Getter
    public String getName() {
        return name;
    }


    public int minDistance(int[] d, boolean[] isVisited)
    {
        // Initialize min value
        int min = 10000, min_index=0;

        for (int i = 0; i < d.length; i++) {
            if (!isVisited[i] && d[i] < min) {

                    min = d[i];
                min_index = i;

            }
            if(min==d[i] && preferences[i]>preferences[min_index]) {
                min = d[i];
                min_index = i;
            }
        }


        return min_index;
    }

    /**
     * @param a Location start
     * @param b Location end
     *
     * This algorithm prints the shortest path between 2 give locations using dijkstra`s algorithm
     */
    public void shortestPath(Location a, Location b) {
        int[][] matrix = city.createMatrix();
        int[] d = new int[city.nodes.size()];
        d[city.nodes.indexOf(a)] = 0;
        boolean[] isVisited = new boolean[city.nodes.size()];
        for (int i = 1; i < d.length; i++) {
            d[i] = 10000;
            isVisited[i] = false;
        }


        for (int i = 0; i < d.length - 1; i++) {

            int u = minDistance(d, isVisited);


            isVisited[u] = true;


            for (int j= 0; j < d.length; j++)

                if (!isVisited[j] && matrix[u][j]>0 && d[u] != 10000 && d[u] + matrix[u][j] < d[j])
                    d[j] = d[u] + matrix[u][j];
        }
        System.out.println("Distance lowest cost between " + a.getName() + " and " + b.getName() + " is " + d[city.nodes.indexOf(b)] );

    }
}