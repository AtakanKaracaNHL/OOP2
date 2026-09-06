package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;

public abstract class Character
{
    private static final int EXPERIENCE_PER_LEVEL = 200;

    private int experiencePoints;
    private int level;
    private ArrayList<String> skills;
    private ArrayList<Item> items;

    protected Character()
    {
        this.experiencePoints = 0;
        this.level = 1;
        this.skills = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public int getExperiencePoints()
    {
        return this.experiencePoints;
    }

    public int getLevel()
    {
        return this.level;
    }

    public ArrayList<String> getSkills()
    {
        return new ArrayList<>(this.skills);
    }

    public ArrayList<Item> getItems()
    {
        return new ArrayList<>(this.items);
    }

    public void receiveExperience(int experiencePoints)
    {
        if (experiencePoints <= 0)
        {
            throw new IllegalArgumentException("XP moet groter zijn dan 0.");
        }

        this.experiencePoints += experiencePoints;
    }

    public void levelUp()
    {
        if (this.experiencePoints < EXPERIENCE_PER_LEVEL)
        {
            throw new IllegalStateException("Je hebt minimaal 200 XP nodig.");
        }

        this.experiencePoints -= EXPERIENCE_PER_LEVEL;
        this.level++;
    }

    public void acquireSkill(String skill)
    {
        if (skill == null || skill.isBlank())
        {
            throw new IllegalArgumentException("Een skill mag niet leeg zijn.");
        }

        if (this.skills.contains(skill))
        {
            throw new IllegalArgumentException("Dit character heeft deze skill al.");
        }

        this.skills.add(skill);
    }

    public void receiveItem(Item item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException("Een item mag niet null zijn.");
        }

        this.items.add(item);
    }

    public abstract void attack();

    public abstract void defend();

    public abstract void useSpecialAbility();
}
