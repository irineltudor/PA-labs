package com.lab6.shapes;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class FreeDrawing {
    LinkedList<List<Integer>> coordinate=new LinkedList<List<Integer>>();
    int[] circleInfo=new int[3];

    public FreeDrawing(){}

    public void addNew(int x,int y)
    { int ok=0;

        for (int i = 0; i <= 5; i++) {
            if (coordinate.contains(List.of(x + i, y))&&coordinate.size()-coordinate.indexOf(List.of(x+i,y))>100) {
                ok = 1;
            } else {
                if (coordinate.contains(List.of(x, y + i))&&coordinate.size()-coordinate.indexOf(List.of(x,y+i))>100) {
                    ok = 1;
                } else {
                    if (coordinate.contains(List.of(x + 1, y + i))&&coordinate.size()-coordinate.indexOf(List.of(x+i,y+i))>100) {
                        ok = 1;
                    }
                }
            }

    }

     if(ok==1)
     {
         circleInfo=recognizeCircle();
     }
        coordinate.add(List.of(x,y));

    }


    public int[] recognizeCircle()
    { int westIndex,eastIndex,northIndex,southIndex;
      westIndex=eastIndex=northIndex=southIndex=0;
      for(int i=1;i < coordinate.size();i++)
      { int x=coordinate.get(i).get(0);
        int y=coordinate.get(i).get(1);
        if(coordinate.get(westIndex).get(0)> x){
            westIndex =i;
        }
        if(coordinate.get(eastIndex).get(0)<x){
            eastIndex=i;
          }
        if(coordinate.get(northIndex).get(1)>y){
            northIndex=i;
          }
        if(coordinate.get(southIndex).get(1)<y){
            southIndex=i;
          }
        }
      int maxRadius,x,y;
      maxRadius = Math.max(coordinate.get(southIndex).get(1) - coordinate.get(northIndex).get(1), coordinate.get(eastIndex).get(0) - coordinate.get(westIndex).get(0))+10;
      x=(int)((coordinate.get(eastIndex).get(0) + coordinate.get(westIndex).get(0))/2);
      y=(int)((coordinate.get(southIndex).get(1) + coordinate.get(northIndex).get(1))/2);

    return new int[]{x, y, maxRadius};

    }

    public int[] getCircleInfo() {
        return circleInfo;
    }

    public int getCurrentX()
    {
        return coordinate.get(coordinate.size()-1).get(0);
    }
    public int getCurrentY()
    {
        return coordinate.get(coordinate.size()-1).get(1);
    }
    public void deleteList()
    {
        coordinate=new LinkedList<List<Integer>>();
    }
}
