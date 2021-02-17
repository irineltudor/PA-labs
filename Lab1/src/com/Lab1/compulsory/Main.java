package com.Lab1.compulsory;

public class Main {

    /*
       The sum of the digits of a number
     */
    public static int digitsSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;

        }
        return sum;
    }

    /*
      Finds the control digit of a number
     */
    public static int controlDigit(int n) {
        while (n > 9) {
            n = digitsSum(n);
        }
        return n;

    }

    public static void main(String[] args) {

        System.out.println("Hello world!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        //Generating random number between 0 and 1.000.000
        int n = (int) (Math.random() * 1_000_000);

        //Applying mathematical operations
        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
        System.out.println(n);

        //Getting the control digit of the number
        n = controlDigit(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);


    }
}
