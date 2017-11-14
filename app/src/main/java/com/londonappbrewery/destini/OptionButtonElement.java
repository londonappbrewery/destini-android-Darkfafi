package com.londonappbrewery.destini;

/**
 * Created by RamsesPC on 11/14/2017.
 */

public class OptionButtonElement
{
    private int buttonTextId;
    private StoryElement nextElementForChoice;

    public OptionButtonElement(int buttonTextId, StoryElement nextStoryElement)
    {
        this.buttonTextId = buttonTextId;
        nextElementForChoice = nextStoryElement;
    }

    public int getButtonTextId() {
        return buttonTextId;
    }

    public StoryElement getNextElementForChoice() {
        return nextElementForChoice;
    }

    public StoryElement linkNextElementForChoice(StoryElement element)
    {
        return (nextElementForChoice = element);
    }
}
