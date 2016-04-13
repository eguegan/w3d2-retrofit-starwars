package com.example.test.samplemasterdetail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.samplemasterdetail.BuildConfig;
import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.utils.ToonParser;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private static final String TAG = "DetailsFragmentTAG_";
    private RelatedTopic mTopic;

    private static final String SIMPSONS_FLAVOR = "simpsons";

    @Bind(R.id.f_details_txt)
    TextView mTextView;
    @Bind(R.id.f_details_img_background)
    ImageView mImageView;

    private final int IMAGE_PLACEHOLDER = (BuildConfig.FLAVOR.contains(SIMPSONS_FLAVOR))
            ? R.drawable.simpsons_placeholder
            : R.drawable.got_placeholder;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void refreshDetails(RelatedTopic relatedTopic) {
        if (relatedTopic == null) {
            return;
        }

        mTopic = relatedTopic;

        String[] parsedText = ToonParser.parseText(mTopic.getText());
        setImageOrPlaceholder(mTopic, mImageView);
        mTextView.setText(parsedText[1]);
    }

    private void setImageOrPlaceholder(RelatedTopic topic, ImageView imageViewIcon) {
        if (topic == null) {
            return;
        }

        String url = topic.getIcon().getURL();

        if (url.isEmpty()) {
            Picasso.with(getContext())
                    .load(IMAGE_PLACEHOLDER)
                    .into(imageViewIcon);
        } else {
            Picasso.with(getContext())
                    .load(url)
                    .error(IMAGE_PLACEHOLDER)
                    .into(imageViewIcon);
        }
    }

}
