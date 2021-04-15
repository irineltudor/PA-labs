package com.lab7.objects;

import com.lab7.waitnotify.PlayerWait;

public class PlayerRunnable implements Runnable {
    public Player player;
    public Board board;
    boolean first;
    public PlayerRunnable()
    { this.player=new Player();

    }
    public PlayerRunnable(Board board, Player player)
    {
        this.board=board;
        this.player=player;
    }



    @Override
    public void run(){


//        while (board.getTokens().size() > 0) {

               if(board.getTokens().size() > 0) {
                   Token token = board.getNextToken();
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
