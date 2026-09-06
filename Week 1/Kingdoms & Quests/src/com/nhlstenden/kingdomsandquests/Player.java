package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;

public class Player
{
    private Character character;
    private ArrayList<Quest> availableQuests;
    private ArrayList<Quest> acceptedQuests;

    public Player()
    {
        this.character = null;
        this.availableQuests = new ArrayList<>();
        this.acceptedQuests = new ArrayList<>();
    }

    public Character getCharacter()
    {
        return this.character;
    }

    public ArrayList<Quest> getAcceptedQuests()
    {
        return new ArrayList<>(this.acceptedQuests);
    }

    public void createCharacter(Character character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException(
                "Een character mag niet null zijn."
            );
        }

        if (this.character != null)
        {
            throw new IllegalStateException(
                "De speler heeft al een character."
            );
        }

        this.character = character;
    }

    public void addQuest(Quest quest)
    {
        if (quest == null)
        {
            throw new IllegalArgumentException("Een quest mag niet null zijn.");
        }

        if (this.availableQuests.contains(quest))
        {
            throw new IllegalArgumentException("Deze quest staat al in de lijst.");
        }

        this.availableQuests.add(quest);
    }

    public ArrayList<Quest> viewQuests()
    {
        ArrayList<Quest> quests = new ArrayList<>();

        for (Quest quest : this.availableQuests)
        {
            if (!this.acceptedQuests.contains(quest))
            {
                quests.add(quest);
            }
        }

        return quests;
    }

    public void acceptQuest(Quest quest)
    {
        if (quest == null)
        {
            throw new IllegalArgumentException("Een quest mag niet null zijn.");
        }

        if (this.character == null)
        {
            throw new IllegalStateException("Maak eerst een character.");
        }

        if (!this.availableQuests.contains(quest))
        {
            throw new IllegalArgumentException("Deze quest is niet beschikbaar.");
        }

        if (this.acceptedQuests.contains(quest))
        {
            throw new IllegalStateException("Deze quest is al geaccepteerd.");
        }

        if (this.character.getExperiencePoints() < quest.getDifficulty() * 10)
        {
            throw new IllegalStateException("Je hebt niet genoeg XP.");
        }

        this.acceptedQuests.add(quest);
    }
}
