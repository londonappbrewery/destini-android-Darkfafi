package com.londonappbrewery.destini;

import android.util.Log;

/**
 * Created by RamsesPC on 11/13/2017.
 */

public class StoryElement
{
    private int storyStringId;
    private OptionButtonElement optionOne;
    private OptionButtonElement optionTwo;

    public StoryElement(int storyStringId, OptionButtonElement optionOne, OptionButtonElement optionTwo)
    {
        this.storyStringId = storyStringId;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
    }

    public int getStoryStringId() {
        return storyStringId;
    }

    public OptionButtonElement getOptionOne() {
        return optionOne;
    }

    public OptionButtonElement getOptionTwo() {
        return optionTwo;
    }

    public boolean hasOptionType(OptionType optionType)
    {
        OptionButtonElement element = getOptionType(optionType);
        return (element != null && element.getNextElementForChoice() != null);
    }

    public OptionButtonElement getOptionType(OptionType optionType)
    {
        OptionButtonElement element = null;

        switch (optionType)
        {
            case OptionOne:
                element = optionOne;
                break;
            case OptionTwo:
                element = optionTwo;
                break;
            default:
                element = null;
                Log.e("Game", "No option element variable for type: " + optionType);
                break;
        }

        return element;
    }

    public boolean isEndingElement()
    {
        return !hasOptionType(OptionType.OptionOne) && !hasOptionType(OptionType.OptionTwo);
    }
}
