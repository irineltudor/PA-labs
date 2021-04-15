package com.lab7.waitnotify;

import com.lab7.objects.Player;
import com.lab7.objects.PlayerRunnable;

import java.util.List;

public class PlayerNotify implements Runnable{
    final List<PlayerRunnable> player;

    public PlayerNotify(List<PlayerRunnable> player)
    {
        this.player=player;
    }
    @Override
    public void run() {

        while (player.get(1).board.getTokens().size() > 0) {
            for (PlayerRunnable current : player
            ) {
                synchronized (current) {
                    try {
                        current.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    current.notifyAll();
                }
            }
        }




    }
}
