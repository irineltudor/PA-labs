package com.lab7.objects;

import com.lab7.waitnotify.PlayerWait;

import java.util.Scanner;

public class PlayerRunnable implements Runnable {
    public Player player;
    public Board board;
    public boolean isRobot;
    public boolean isDone=false;
    public PlayerRunnable()
    { this.player=new Player();

    }
    public PlayerRunnable(Board board, Player player,boolean isRobot)
    {
        this.board=board;
        this.player=player;
        this.isRobot=isRobot;
    }

     public void done()
     {
         this.isDone=true;
     }
     public void notDone()
     {
         this.isDone=false;
     }


    @Override
    public void run(){


//        while (board.getTokens().size() > 0) {
          if(isRobot) {
              if (board.getTokens().size() > 0) {
                  Token token = board.getNextToken();
                  player.addToken(token);
                  System.out.println(player.name + " a luat " + token.a + " " + token.b + " cu costul " + token.cost);

              }
          }
          else{
              Scanner keyboard = new Scanner(System.in);
              System.out.println(board.tokens);
              System.out.println("enter a");
              int a = keyboard.nextInt();
              System.out.println("enter b");
              int b = keyboard.nextInt();
              Token token = board.getToken(a,b);
              while(token.a==0&&token.b==0)
              {   System.out.println("Incorrect a and b try again : ");
                  System.out.println("enter a");
                 a = keyboard.nextInt();
                  System.out.println("enter b");
                  b = keyboard.nextInt();
                  token = board.getToken(a,b);

              }
              player.addToken(token);
              System.out.println(player.name + " a luat " + token.a + " " + token.b + " cu costul " + token.cost);
          }

//        }








    }

    @Override
    public String toString() {
        return "PlayerRunnable{" +
                "player=" + player +
                '}';
    }
}
