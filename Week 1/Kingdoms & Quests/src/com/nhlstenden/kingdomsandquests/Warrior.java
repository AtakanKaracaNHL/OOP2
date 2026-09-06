package com.nhlstenden.kingdomsandquests;

public class Warrior extends Character
{
    private int attackPower;
    private boolean specialAbilityActive;

    public Warrior(int attackPower)
    {
        super();

        if (attackPower <= 0)
        {
            throw new IllegalArgumentException(
                "Aanvalskracht moet groter zijn dan 0."
            );
        }

        this.attackPower = attackPower;
        this.specialAbilityActive = false;
    }

    @Override
    public void attack()
    {
        if (this.specialAbilityActive)
        {
            System.out.println(
                "Warrior valt aan met " + this.attackPower * 2 + " aanvalskracht."
            );

            this.specialAbilityActive = false;
        }
        else
        {
            System.out.println(
                "Warrior valt aan met " + this.attackPower + " aanvalskracht."
            );
        }
    }

    @Override
    public void defend()
    {
        System.out.println("Warrior verdedigt.");
    }

    @Override
    public void useSpecialAbility()
    {
        this.specialAbilityActive = true;
    }
}
