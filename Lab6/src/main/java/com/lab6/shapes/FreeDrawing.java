package com.lab6.shapes;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class FreeDrawing {
    LinkedList<List<Integer>> coordinate=new LinkedList<List<Integer>>();
    int nr=0;

    public FreeDrawing(){}

    public void addNew(int x,int y)
    {
        coordinate.add(List.of(x,y));
    }

    public Shape recognizeShape()
    {
        for(int i=0;i<=coordinate.size();i++)
        {
            int x=coordinate.get(i).get(0);
            int y=coordinate.get(i).get(1);
        }

        return null;
    }

    public int getCurrentX()
    {
        return coordinate.get(coordinate.size()-1).get(0);
    }
    public int getCurrentY()
    {
        return coordinate.get(coordinate.size()-1).get(1);
    }
}
