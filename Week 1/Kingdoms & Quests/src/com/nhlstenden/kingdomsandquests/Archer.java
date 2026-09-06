package com.nhlstenden.kingdomsandquests;

public class Archer extends Character
{
    private int damage;
    private boolean specialAbilityActive;

    public Archer(int damage)
    {
        super();

        if (damage <= 0)
        {
            throw new IllegalArgumentException(
                "Schade moet groter zijn dan 0."
            );
        }

        this.damage = damage;
        this.specialAbilityActive = false;
    }

    @Override
    public void attack()
    {
        if (this.specialAbilityActive)
        {
            System.out.println(
                "Archer veroorzaakt " + this.damage * 2 + " schade."
            );

            this.specialAbilityActive = false;
        }
        else
        {
            System.out.println(
                "Archer veroorzaakt " + this.damage + " schade."
            );
        }
    }

    @Override
    public void defend()
    {
        System.out.println("Archer verdedigt.");
    }

    @Override
    public void useSpecialAbility()
    {
        this.specialAbilityActive = true;
    }
}
