package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button optionOneButtonView, optionTwoButtonView;
    private TextView storyTextView;

    private BaseStory story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        story = new MainStory(); // Sets Story

        optionOneButtonView = (Button)findViewById(R.id.buttonTop);
        optionTwoButtonView = (Button)findViewById(R.id.buttonBottom);
        storyTextView = (TextView)findViewById(R.id.storyTextView);

        optionOneButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionButtonPressed(OptionType.OptionOne);
            }
        });

        optionTwoButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionButtonPressed(OptionType.OptionTwo);
            }
        });
    }


    private void optionButtonPressed(OptionType buttonType)
    {
        advanceInStory(buttonType);
    }

    private void advanceInStory(OptionType optionType)
    {
        story.advanceStory(optionType);

        storyTextView.setText(story.getCurrentStoryElement().getStoryStringId());
        setOptionButtonForCurrentStoryElement(OptionType.OptionOne);
        setOptionButtonForCurrentStoryElement(OptionType.OptionTwo);
    }

    private void setOptionButtonForCurrentStoryElement(OptionType optionButtonType)
    {
        boolean activeOp = story.getCurrentStoryElement().hasOptionType(optionButtonType);
        Button optionView = getButtonInstance(optionButtonType);

        optionView.setEnabled(activeOp);
        optionView.setAlpha((activeOp) ? 1 : 0);

        if(activeOp)
            optionView.setText(story.getOptionElementForType(optionButtonType).getButtonTextId());
    }

    private Button getButtonInstance(OptionType buttonType)
    {
        Button button;

        switch (buttonType)
        {
            case OptionOne:
                button = optionOneButtonView;
                break;
            case OptionTwo:
                button = optionTwoButtonView;
                break;
            default:
                button = null;
                break;
        }

        return button;
    }
}
