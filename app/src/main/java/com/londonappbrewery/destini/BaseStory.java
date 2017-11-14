package com.londonappbrewery.destini;

import android.util.Log;

/**
 * Created by RamsesPC on 11/14/2017.
 */

public abstract class BaseStory
{
    private StoryElement currentElement;

    public BaseStory()
    {
        currentElement = setupStory(); // Set Start Element
    }

    public StoryElement getCurrentStoryElement() {
        return currentElement;
    }

    public void advanceStory(OptionType optionType)
    {
        if(currentElement.isEndingElement()) { return; }
        OptionButtonElement optionElement = getOptionElementForType(optionType);
        currentElement = optionElement.getNextElementForChoice();
    }

    public OptionButtonElement getOptionElementForType(OptionType optionType)
    {
        OptionButtonElement optionElement = currentElement.getOptionType(optionType);
        return optionElement;
    }

    protected abstract StoryElement setupStory();

    protected StoryElement createStoryElement(int storyStringId, int optionOneId, int optionTwoId, StoryElement optionOnePath, StoryElement optionTwoPath)
    {
        StoryElement se = new StoryElement(storyStringId, new OptionButtonElement(optionOneId, optionOnePath), new OptionButtonElement(optionTwoId, optionTwoPath));
        return se;
    }

    protected StoryElement createStoryElement(int storyStringId, int optionOneId, int optionTwoId)
    {
        return createStoryElement(storyStringId, optionOneId, optionTwoId, null, null);
    }

    protected StoryElement createEndingStoryElement(int storyStringId)
    {
        StoryElement se = new StoryElement(storyStringId, null, null);
        return se;
    }
}
