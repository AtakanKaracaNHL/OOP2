package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;

public class Quest
{
    private int experiencePoints;
    private int difficulty;
    private ArrayList<Player> completedPlayers;

    public Quest(int experiencePoints, int difficulty)
    {
        if (experiencePoints <= 0)
        {
            throw new IllegalArgumentException(
                "De XP-beloning moet groter zijn dan 0."
            );
        }

        if (difficulty < 0)
        {
            throw new IllegalArgumentException(
                "Difficulty mag niet negatief zijn."
            );
        }

        this.experiencePoints = experiencePoints;
        this.difficulty = difficulty;
        this.completedPlayers = new ArrayList<>();
    }

    public int getExperiencePoints()
    {
        return this.experiencePoints;
    }

    public int getDifficulty()
    {
        return this.difficulty;
    }

    public void completeQuest(Player player)
    {
        if (player == null)
        {
            throw new IllegalArgumentException("Een speler mag niet null zijn.");
        }

        if (!player.getAcceptedQuests().contains(this))
        {
            throw new IllegalStateException("Accepteer eerst deze quest.");
        }

        if (this.completedPlayers.contains(player))
        {
            throw new IllegalStateException("Deze quest is al afgerond.");
        }

        player.getCharacter().receiveExperience(this.experiencePoints);
        this.completedPlayers.add(player);
    }
}
