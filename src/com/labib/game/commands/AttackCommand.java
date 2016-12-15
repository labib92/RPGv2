package com.labib.game.commands;

import com.labib.game.Enemy;
import com.labib.game.Game;
import com.labib.game.Player;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class AttackCommand implements FightCommand {


    @Override
    public Status execute(Player player, Enemy enemy) {
        attack(player, enemy);
        if (player.getHealth() <= 0) {
            System.out.println("\t> You have taken too much damage, you are weak to go on!");
            return Status.DIED;
        }
        return Status.PROCEED;
    }

    private void attack(Player player, Enemy enemy) {
        System.out.println("\t> You strike the " + enemy.getName() + " for " + enemy.damageDealtToEnemy() + " damage.");
        System.out.println("\t> You received " + player.damageDealtToPlayer(enemy.getEnemyAttackDamage()) + " in retaliation");
    }
}
