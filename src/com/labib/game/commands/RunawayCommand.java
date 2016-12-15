package com.labib.game.commands;

import com.labib.game.Enemy;
import com.labib.game.Player;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class RunawayCommand implements FightCommand{
    @Override
    public Status execute(Player player, Enemy enemy) {
        System.out.println("\tYou run away from the " + enemy.getName() + "!");
        return Status.RUAWAY;
    }
}
