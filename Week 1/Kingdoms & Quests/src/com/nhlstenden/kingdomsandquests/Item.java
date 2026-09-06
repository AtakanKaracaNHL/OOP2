package com.nhlstenden.kingdomsandquests;

public class Item
{
    private String title;

    public Item(String title)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException(
                "De titel van een item mag niet leeg zijn."
            );
        }

        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }
}
