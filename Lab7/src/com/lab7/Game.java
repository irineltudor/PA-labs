package com.lab7;

import com.lab7.objects.Board;
import com.lab7.objects.Player;
import com.lab7.objects.PlayerRunnable;
import com.lab7.objects.Token;
import com.lab7.waitnotify.PlayerNotify;
import com.lab7.waitnotify.PlayerWait;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Board board=new Board();
    List<Player> playerList=new LinkedList<>();

    public Game(){
        this.createGame();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    private void createGame()
    {
        setPlayerList(List.of(new Player("Robotul"),new Player("Irinel")));
        LinkedList<Token> tokens=new LinkedList<>();
        tokens.add(new Token(100));
        tokens.add(new Token(100));
        tokens.add(new Token(100));
        tokens.add(new Token(100));

        board.setTokens(tokens);
    }
    public String printWinner()
    {   int mx=playerList.get(0).getTokensSum();
        int mxIndex=0;
        for(int i=1;i<=playerList.size()-1;i++) {
            if (mx < playerList.get(i).getTokensSum()) {
                mxIndex = i;
                mx = playerList.get(i).getTokensSum();
            }
        }

        return playerList.get(mxIndex).name;
    }

    public void play()
    {
        PlayerRunnable player1=new PlayerRunnable(board,playerList.get(0),true);
        PlayerRunnable player2=new PlayerRunnable(board,playerList.get(1),false);
        List<Thread> threadList = new ArrayList<Thread>();





           PlayerWait wait1=new PlayerWait(player1);
           PlayerWait wait2=new PlayerWait(player2);
           PlayerNotify notify=new PlayerNotify(List.of(player1,player2));

           Thread t1=new Thread(wait1);
           t1.start();
           threadList.add(t1);
           Thread t2=new Thread(wait2);
           t2.start();
           threadList.add(t2);
           Thread t3=new Thread(notify);
           t3.start();
           threadList.add(t3);

        for(Thread t : threadList) {

            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//           new Thread(player1).start();
//
//           new Thread(player2).start();


        System.out.println(playerList.get(0));
        System.out.println(playerList.get(1));
        System.out.println("Castigatorul este:" + printWinner());


    }
}
