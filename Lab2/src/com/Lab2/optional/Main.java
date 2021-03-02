package com.Lab2.optional;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Factory S1=new Factory("S1",10);
        Warehouse S2=new Warehouse("S2",35);
        Warehouse S3=new Warehouse("S3",25);
        Factory S4=new Factory("S1",10);
        Destination D1=new Destination("D1",20);
        Destination D2=new Destination("D2",25);
        Destination D3=new Destination("D3",25);

        System.out.println(S1.equals(S4));//equals test

        Problem prob=new Problem();
        prob.addSource(S1);
        prob.addSource(S2);
        prob.addSource(S3);

        prob.addDestinations(D1);
        prob.addDestinations(D2);
        prob.addDestinations(D3);
        prob.createMatrix();

        Solution sol = new Solution(prob.costMatrix,prob.getSuppliers(),prob.getDemanders());
        sol.problemSolution();

    }
}
