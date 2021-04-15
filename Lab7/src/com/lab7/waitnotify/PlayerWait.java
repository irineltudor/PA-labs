package com.lab7.waitnotify;

import com.lab7.objects.Player;
import com.lab7.objects.PlayerRunnable;

public class PlayerWait implements Runnable{
    final PlayerRunnable player;

    public PlayerWait(PlayerRunnable player)
    {
        this.player=player;
    }
    @Override
    public void run() {
        while (player.board.getTokens().size() > 0) {
            synchronized (player) {

                    try {
                        if(player.board.getTokens().size()>1) {

                            player.wait();

                            player.run();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


}
