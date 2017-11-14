package com.londonappbrewery.destini;

/**
 * Created by RamsesPC on 11/14/2017.
 */

public class MainStory extends BaseStory
{
    @Override
    protected StoryElement setupStory() {

        // Creating Elements
        StoryElement startElement = createStoryElement(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);

        StoryElement T3Element = createStoryElement(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);

        StoryElement T2Element = createStoryElement(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);

        StoryElement T4EndElement = createEndingStoryElement(R.string.T4_End);
        StoryElement T5EndElement = createEndingStoryElement(R.string.T5_End);
        StoryElement T6EndElement = createEndingStoryElement(R.string.T6_End);

        //Linking Elements
        startElement.getOptionOne().linkNextElementForChoice(T3Element);
        startElement.getOptionTwo().linkNextElementForChoice(T2Element);

        T2Element.getOptionOne().linkNextElementForChoice(T3Element);
        T2Element.getOptionTwo().linkNextElementForChoice(T4EndElement);

        T3Element.getOptionOne().linkNextElementForChoice(T6EndElement);
        T3Element.getOptionTwo().linkNextElementForChoice(T5EndElement);

        return startElement;
    }
}
