package com.Lab2.compulsory;
public class Main {
    public static void main(String[] args) {

        Source S1=new Source();
        S1.setName("S1");
        S1.setSource(SourceType.FACTORY);
        S1.setSupply(10);

        Source S2=new Source("S2",SourceType.WAREHOUSE,35);
        Source S3=new Source("S3",SourceType.WAREHOUSE,25);

        Destination D1=new Destination();
        D1.setName("D1");
        D1.setDemand(20);
        Destination D2=new Destination("D2",25);
        Destination D3=new Destination("D3",25);

        System.out.println(S1 + "\n" + S2 + "\n" + S3);
        System.out.println(D1 + "\n" + D2 + "\n" + D3);





    }
}
