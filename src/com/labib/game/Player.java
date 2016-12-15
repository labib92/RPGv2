package com.labib.game;

import java.util.Random;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class Player {
    private int health = 100;
    private int numbHealthPotions = 3;
    private int healthPotionHealAmount = 30;
    private int healthPotionDropChance = 50;
    private Random random;

    public int getHealthPotionHealAmount() {
        return healthPotionHealAmount;
    }

    public int getHealth() {
        return health;
    }

    public int getNumbHealthPotions() {
        return numbHealthPotions;
    }
    public int getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    public Player(Random rand) {
        random =rand;
    }

    public void drinkPotion() {
        health += healthPotionHealAmount;
        numbHealthPotions--;
    }


    public void setNumbHealthPotions() {
        numbHealthPotions++;
    }

    public int damageDealtToPlayer(int enemyAttackDamage) {
        int damageTaken = random.nextInt(enemyAttackDamage);
        health -= damageTaken;
        return damageTaken;

    }

}
