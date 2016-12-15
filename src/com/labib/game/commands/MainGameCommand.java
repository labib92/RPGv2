package com.labib.game.commands;

import com.labib.game.Player;

/**
 * Created by labib's pc on 12/15/2016.
 */
public interface MainGameCommand extends Command{
    public boolean execute(Player player);
}
