package com.example.test.samplemasterdetail.tasks;

import android.os.AsyncTask;

import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.MainFragment;
import com.example.test.samplemasterdetail.retrofit.RetrofitHelper;

import java.util.List;

/**
 * Created by evin on 3/10/16.
 */
public class ToonsTask extends AsyncTask<Void, Void, List<RelatedTopic>> {
    private static final String TAG = "CharactersTaskTAG_";

    MainFragment mMainFragment;

    public ToonsTask(MainFragment mainFragment) {
        mMainFragment = mainFragment;
    }

    @Override
    protected List<RelatedTopic> doInBackground(Void... params) {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        return retrofitHelper.getCharacters();
    }

    @Override
    protected void onPostExecute(List<RelatedTopic> relatedTopics) {
        super.onPostExecute(relatedTopics);

        if (mMainFragment != null) {
            mMainFragment.refreshResults(relatedTopics);
        }

        clearReferences();
    }

    private void clearReferences() {
        mMainFragment = null;
    }
}
