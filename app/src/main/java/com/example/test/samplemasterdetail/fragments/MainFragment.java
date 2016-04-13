package com.example.test.samplemasterdetail.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.adapters.ToonsAdapter;
import com.example.test.samplemasterdetail.decorators.SpacesItemDecorator;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.tasks.ToonsTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = "MainFragmentTAG_";
    private static final String TOPICS_KEY = "BUNDLE_TOPICS_KEY";
    private static final String IS_GRID_KEY = "BUNDLE_GRID_KEY";

    private ToonsAdapter mToonsAdapter;
    private ArrayList<RelatedTopic> mTopics;

    private OnToonClickCallback onToonClickCallback;

    private boolean isGrid;

    @Bind(R.id.f_main_recycler)
    RecyclerView mRecycler;

    public MainFragment() {

    }

    public interface OnToonClickCallback {
        public void toonClicked(RelatedTopic relatedTopic);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onToonClickCallback = (OnToonClickCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            mTopics = new ArrayList<>();
            isGrid = false;
        } else {
            if (savedInstanceState.containsKey(TOPICS_KEY)) {
                mTopics = savedInstanceState.getParcelableArrayList(TOPICS_KEY);
            }
            isGrid = savedInstanceState.getBoolean(IS_GRID_KEY, false);
        }
        mToonsAdapter = new ToonsAdapter(this, mTopics);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mToonsAdapter);
        alphaAdapter.setDuration(1000);
        mRecycler.setAdapter(alphaAdapter);

        mRecycler.addItemDecoration(new SpacesItemDecorator(10));

        refreshRecyclerLayout();

        if (mTopics.size() <= 0) {
            refreshRecycler(true);
        }
    }

    private void refreshRecyclerLayout() {
        final Context applicationContext = getContext().getApplicationContext();
        if (!isGrid) {
            mRecycler.setLayoutManager(new LinearLayoutManager(applicationContext));
        } else {
            mRecycler.setLayoutManager(new GridLayoutManager(applicationContext, 2,
                    LinearLayoutManager.VERTICAL, false));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(TOPICS_KEY, mTopics);
        outState.putBoolean(IS_GRID_KEY, isGrid);
        super.onSaveInstanceState(outState);
    }

    private void refreshRecycler(boolean overrideSavedInstance) {
        if (overrideSavedInstance) {
            new ToonsTask(this).execute();
        }
    }

    public void refreshResults(List<RelatedTopic> relatedTopics) {
        if (relatedTopics != null) {
            mTopics.clear();
            mTopics.addAll(relatedTopics);
            mToonsAdapter.notifyDataSetChanged();
        }
    }

    public void toggleGrid() {
        isGrid = !isGrid;
        refreshRecyclerLayout();
    }

    public void toonClicked(RelatedTopic relatedTopic) {
        onToonClickCallback.toonClicked(relatedTopic);
    }

    public boolean isGrid() {
        return isGrid;
    }

    public void setFalseGrid() {
        isGrid = false;
        refreshRecyclerLayout();
    }
}
