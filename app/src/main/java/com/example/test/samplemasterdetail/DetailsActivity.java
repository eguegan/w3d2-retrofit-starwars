package com.example.test.samplemasterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;

import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.DetailsFragment;
import com.example.test.samplemasterdetail.utils.ToonParser;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivityTAG_";

    private DetailsFragment mDetailsFragment;
    private RelatedTopic mTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //If it is a tablet layout, go back to the parent activity (since the Details
        //fragment is already shown there)
        if (isTablet()){
            onBackPressed();
        }

        retrieveFragments();
        setupToolbar();
        retrieveTopic();
        setTitleBar();
    }

    //Set title bar depending on the Character's name
    private void setTitleBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String title = (mTopic != null)
                    ? ToonParser.parseText(mTopic.getText())[0]
                    : getString(R.string.activity_details_name);
            actionBar.setTitle(title);
            actionBar.setSubtitle(R.string.activity_details_name);
        }
    }

    //Get the references for the fragments
    private void retrieveFragments() {
        mDetailsFragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.details_fragment);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            //Add a back reference to MainActivity
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    //Since we don't have the DetailsFragment reference, we need to calculate the width
    //and make the validation manually
    private boolean isTablet() {
        return getWidthInDp() > 600;
    }

    //Use of the DisplayMetrics class to get an exact width in dp
    private float getWidthInDp() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return displayMetrics.widthPixels / displayMetrics.density;
    }

    //Check if we're retrieving the information of the current character from the incoming intent
    private void retrieveTopic() {
        Intent incomingIntent = getIntent();
        if (incomingIntent.hasExtra(MainActivity.DETAILS_KEY)) {
            mTopic = incomingIntent.getParcelableExtra(MainActivity.DETAILS_KEY);
            if (mDetailsFragment != null) {
                mDetailsFragment.refreshDetails(mTopic);
            }
        }
    }
}
