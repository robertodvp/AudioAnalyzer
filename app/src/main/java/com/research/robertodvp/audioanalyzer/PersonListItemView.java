package com.research.robertodvp.audioanalyzer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by robertov on 16/05/2017.
 */

public class PersonListItemView extends GridLayout {

    TextView mNameView;

    TextView mAddressView;

    TextView mAgeView;

    ImageView mImageView;

    public static PersonListItemView inflate(ViewGroup parent) {
        return (PersonListItemView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_person, parent, false);
    }

    public PersonListItemView(Context context) {
        super(context);
    }

    public PersonListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PersonListItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mNameView = (TextView) findViewById(R.id.name);
        mAddressView = (TextView) findViewById(R.id.address);
        mAgeView = (TextView) findViewById(R.id.age);
        mImageView = (ImageView) findViewById(R.id.image);
    }

    public void populate(Person p) {
        mNameView.setText(p.mName == null ? "Unknown" : p.mName );
        mAddressView.setText(p.mAddress == null ? "Unknown" : p.mAddress);
        mAgeView.setText(p.mAge < 0 ?  "Unknown" : String.valueOf(p.mAge));

        if (p.mAvatarUri == null) {
            mImageView.setVisibility(View.VISIBLE);
           // mImageView.setVisibility(View.GONE);
        } else {
            mImageView.setVisibility(View.VISIBLE);
            mImageView.setImageURI(p.mAvatarUri);
        }
    }
}
