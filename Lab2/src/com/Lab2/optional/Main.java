package com.Lab2.optional;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Source S1=new Source("S1",0,5);
        Source S2=new Source("S2",1,6);
        Source S3=new Source("S3",1,7);
        Source S4=new Source("S1",0,5);

        Destination D1=new Destination("D1",10);
        Destination D2=new Destination("D2",11);
        Destination D3=new Destination("D3",12);

        System.out.println(S1.equals(S4));

        Problem prob=new Problem();
        prob.addSource(S1);
        prob.addSource(S2);
        prob.addSource(S1);
        prob.addSource(S3);

        prob.addDestinations(D1);
        prob.addDestinations(D2);
        prob.addDestinations(D3);
        prob.createMatrix();

    }
}
