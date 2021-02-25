package com.Lab2.optional;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Factory S1=new Factory("S1",10);
        Warehouse S4=new Warehouse("S1",11);
        Factory S3=new Factory("S1",10);
        Destination D1=new Destination("D1",10);
        Problem prob=new Problem();
        prob.addSource(S1);
        prob.addSource(S4);
        prob.addSource(S3);

        prob.addDestinations(D1);
        prob.createMatrix();

    }
}
