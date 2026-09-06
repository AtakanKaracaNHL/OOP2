package com.nhlstenden.kingdomsandquests;

public class Mage extends Character
{
    private int defense;

    public Mage(int defense)
    {
        super();

        if (defense <= 0)
        {
            throw new IllegalArgumentException(
                "Verdediging moet groter zijn dan 0."
            );
        }

        this.defense = defense;
    }

    @Override
    public void attack()
    {
        System.out.println("Mage valt aan.");
    }

    @Override
    public void defend()
    {
        System.out.println(
            "Mage verdedigt met " + this.defense + " verdediging."
        );
    }

    @Override
    public void useSpecialAbility()
    {
        this.defense *= 2;
    }
}
