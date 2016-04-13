package com.example.test.samplemasterdetail.adapters;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.samplemasterdetail.BuildConfig;
import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.MainFragment;
import com.example.test.samplemasterdetail.utils.ToonParser;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by evin on 3/10/16.
 */
public class ToonsAdapter extends RecyclerView.Adapter<ToonsAdapter.ViewHolder> {

    private static final String TAG = "ToonsAdapterTAG_";
    private static final String SIMPSONS_FLAVOR = "simpsons";

    private final List<RelatedTopic> mTopics;
    private final MainFragment mMainFragment;

    private final int IMAGE_PLACEHOLDER = (BuildConfig.FLAVOR.contains(SIMPSONS_FLAVOR))
            ? R.drawable.simpsons_placeholder
            : R.drawable.got_placeholder;

    private int IMAGE_WIDTH;
    private int IMAGE_HEIGHT;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView txtTitle;
        public final TextView txtDescription;

        public final ImageView imgIcon;
        public RelatedTopic relatedTopic;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.r_txt_title);
            txtDescription = (TextView) itemView.findViewById(R.id.r_txt_description);
            imgIcon = (ImageView) itemView.findViewById(R.id.r_img_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMainFragment.toonClicked(relatedTopic);
                }
            });
        }
    }

    public ToonsAdapter(MainFragment mainFragment, List<RelatedTopic> topics) {
        mMainFragment = mainFragment;
        mTopics = topics;

        if (mMainFragment != null) {
            Resources resources = mMainFragment.getResources();
            IMAGE_WIDTH = ((int) resources.getDimension(R.dimen.image_width));
            IMAGE_HEIGHT = ((int) resources.getDimension(R.dimen.image_height));
        }
    }

    @Override
    public ToonsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View termView = inflater.inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(termView);
    }

    @Override
    public void onBindViewHolder(ToonsAdapter.ViewHolder viewHolder, int position) {
        RelatedTopic topic = mTopics.get(position);

        //We can be sure that this function always returns an array with length 2
        String[] parsedText = ToonParser.parseText(topic.getText());

        TextView textViewTitle = viewHolder.txtTitle;
        textViewTitle.setText(parsedText[0]);

        TextView textViewDescription = viewHolder.txtDescription;
        textViewDescription.setText(parsedText[1]);

        ImageView imageViewIcon = viewHolder.imgIcon;

        setImageOrPlaceholder(topic, imageViewIcon);

        viewHolder.relatedTopic = topic;
    }

    private void setImageOrPlaceholder(RelatedTopic topic, ImageView imageViewIcon) {
        if (mMainFragment != null && mMainFragment.isGrid()) {
            imageViewIcon.setVisibility(View.VISIBLE);

            String url = topic.getIcon().getURL();

            if (url.isEmpty()) {
                Picasso.with(mMainFragment.getContext())
                        .load(IMAGE_PLACEHOLDER)
                        .resize(IMAGE_WIDTH, IMAGE_HEIGHT)
                        .into(imageViewIcon);
            } else {
                Picasso.with(mMainFragment.getContext())
                        .load(url)
                        .error(IMAGE_PLACEHOLDER)
                        .resize(IMAGE_WIDTH, IMAGE_HEIGHT)
                        .into(imageViewIcon);
            }
        } else {
            imageViewIcon.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }
}
