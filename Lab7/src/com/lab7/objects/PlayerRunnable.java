package com.lab7.objects;

public class PlayerRunnable implements Runnable {
    Player player;
    Board board;

    public PlayerRunnable(Board board, Player player)
    {
        this.board=board;
        this.player=player;
    }

    public void updateBoard(Board board)
    {
        this.board=board;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void run(){
            if(board.getTokens().size() > 0) {
                player.addToken(board.getNextToken());
                updateBoard(board);
            }

    }

    @Override
    public String toString() {
        return "PlayerRunnable{" +
                "player=" + player +
                '}';
    }
}
