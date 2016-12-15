package com.labib.game.commands;

import com.labib.game.Enemy;
import com.labib.game.Player;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class DrinkPotionCommand implements FightCommand {
    @Override
    public Status execute(Player player, Enemy enemy) {
        if (player.getNumbHealthPotions() > 0) {
            heal(player);


        } else {
            System.out.println("\t> You have no health potion left! Defeat enimes for a chance to get one!");
        }
        return Status.PROCEED;
    }
     private void heal(Player player) {
        player.drinkPotion();
        System.out.println("\t> You drink a health potion, healing yourself for " + player.getHealthPotionHealAmount() + "."
                + "\n\t> You now have " + player.getHealth() + " HP."
                + "\n\t> You have " + player.getNumbHealthPotions() + " health potion left.\n");
    }

}
