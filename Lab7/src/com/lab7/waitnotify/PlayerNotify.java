package com.lab7.waitnotify;

import com.lab7.objects.Player;
import com.lab7.objects.PlayerRunnable;

import java.util.List;

public class PlayerNotify implements Runnable{
    List<PlayerRunnable> player;

    public PlayerNotify(List<PlayerRunnable> player)
    {
        this.player=player;
    }
    @Override
    public void run() {
           boolean firstRun=true;
        while (player.get(1).board.getTokens().size() > 0) {
            for (PlayerRunnable current : player
            ) {
                synchronized (current) {
                    if(firstRun)
                    {
                        current.notify();
                        firstRun=false;
                    }
                    else {


                        int index = player.indexOf(current) - 1;
                        if (index < 0) {
                            index = player.size() - 1;
                        }
                        if (player.get(index).isDone) {
                            current.notify();
                            player.get(index).notDone();
                        }
                    }
                }
            }
        }




    }
}
