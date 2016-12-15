package com.labib.game.commands;

import com.labib.game.Enemy;
import com.labib.game.Player;

/**
 * Created by labib's pc on 12/15/2016.
 */
public interface FightCommand extends Command {
    enum Status {
        DIED, PROCEED, RUAWAY, ERROR
    }

    public Status execute(Player player, Enemy enemy);
}
