package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;

public class SpecialQuest extends Quest
{
    private ArrayList<Item> items;

    public SpecialQuest(int experiencePoints, int difficulty,
                        ArrayList<Item> items)
    {
        super(experiencePoints, difficulty);

        if (items == null || items.isEmpty())
        {
            throw new IllegalArgumentException(
                "Een speciale quest moet minimaal één item hebben."
            );
        }

        for (Item item : items)
        {
            if (item == null)
            {
                throw new IllegalArgumentException(
                    "De lijst mag geen null-items bevatten."
                );
            }
        }

        this.items = new ArrayList<>(items);
    }

    public ArrayList<Item> getItems()
    {
        return new ArrayList<>(this.items);
    }

    @Override
    public void completeQuest(Player player)
    {
        super.completeQuest(player);

        for (Item item : this.items)
        {
            player.getCharacter().receiveItem(item);
        }
    }
}
