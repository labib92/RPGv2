package com.labib.game.commands;

import com.labib.game.Player;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class ExitCommand implements MainGameCommand{
    @Override
    public boolean execute(Player player) {
        System.out.println("You exit the dungeon, succeful from your adventure!");
        return false;
    }
}
