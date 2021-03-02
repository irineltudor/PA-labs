package com.Lab2.optional;

public class Solution {
    //class members
    String[][] costMatrix = new String[10][10];
    int suppliers;
    int demanders;

    /**
     *
     * @param costMatrix matrix that has the path costs
     * @param suppliers number of suppliers
     * @param demanders number of demanders
     */

    //class methods

    /**
     * Constructor
     */
    Solution(String[][] costMatrix,int suppliers,int demanders)
    {   this.demanders=demanders;
        this.suppliers=suppliers;
        for(int i=0;i<=suppliers+1;i++)
            for(int j=0;j<=demanders+1;j++)
                this.costMatrix[i][j]=costMatrix[i][j];
    }
    /**
     * Greedy algorithm that solves the demand-supply problem for a certain inputs
     */
    public void problemSolution()
    { int cost=0;
      for(int i=1;i<=suppliers;i++)
      {
        int demand=0;

        int supply=Integer.parseInt(costMatrix[i][suppliers+1]);

          while(supply!=0)
          {  int minimumCost=1000;
              for(int j=1;j<=demanders;j++)
            {
              if(Integer.parseInt(costMatrix[i][j])<minimumCost)
              {
                  if(Integer.parseInt(costMatrix[suppliers+1][j])>0)
                  {
                      minimumCost=Integer.parseInt(costMatrix[i][j]);
                      demand=j;
                  }

              }
            }

            if(Integer.parseInt(costMatrix[suppliers+1][demand])>=supply)
            {   System.out.println(costMatrix[i][0] + "->" + costMatrix[0][demand] + " " + supply +" units * cost " + minimumCost + " = " + minimumCost*supply);
                cost=cost + minimumCost*supply;
                costMatrix[suppliers+1][demand]=String.valueOf(Integer.parseInt(costMatrix[suppliers+1][demand])-supply);
                supply=0;


            }
            else
            {   System.out.println(costMatrix[i][0] + "->" + costMatrix[0][demand] + " " +  costMatrix[suppliers+1][demand] +" units * cost " + minimumCost+ " = " + minimumCost*supply );
                cost=cost + minimumCost*supply;
                 supply=supply-Integer.parseInt(costMatrix[suppliers+1][demand]);
                costMatrix[suppliers+1][demand]=String.valueOf(0);

            }

          }





      }
      System.out.println("Total cost : " + cost);
    }
}
