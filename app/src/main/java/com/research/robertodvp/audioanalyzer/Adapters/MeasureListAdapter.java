package com.research.robertodvp.audioanalyzer.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.research.robertodvp.audioanalyzer.Entities.Measure;
import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.R;
import com.research.robertodvp.audioanalyzer.View.MeasureThumbView;
import com.research.robertodvp.audioanalyzer.View.ScoreThumbView;

import java.util.ArrayList;

/**
 * Created by robertov on 14/08/2017.
 */

public class MeasureListAdapter extends ArrayAdapter {

    private ArrayList<Measure> mMeasures;
    private Boolean trashVisibility=false;

    public MeasureListAdapter(Context context, ArrayList<Measure> measures) {
        super(context, 0, measures);
        mMeasures = measures;
    }

    @Override
    public int getCount() {
        return mMeasures == null ? 0 : mMeasures.size();
    }

    @Override
    public Measure getItem(int position) {
        return mMeasures.get(position);
    }

    /*@Override
    public String getItemId(int position) {
        return getItem(position).getmScoreId();
    }*/

    public Boolean getTrashVisibility(){
        return trashVisibility;
    }

    public void setTrashVisibility(Boolean visibility){
        trashVisibility = visibility;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MeasureThumbView measureThumbView = (MeasureThumbView) convertView;
        if (measureThumbView == null) {
            measureThumbView = MeasureThumbView.inflate(parent);
        }

        final Measure p = getItem(position);
        measureThumbView.populate(p);


        //Handle buttons and add onClickListeners
        ImageView deleteTrash = (ImageView)measureThumbView.findViewById(R.id.trash);
        //Button addBtn = (Button)view.findViewById(R.id.add_btn);

        deleteTrash.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                mMeasures.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });

        if(trashVisibility){
            deleteTrash.setVisibility(View.VISIBLE);
            notifyDataSetChanged();
        }else{
            deleteTrash.setVisibility(View.INVISIBLE);
            notifyDataSetChanged();
        }

        return measureThumbView;
    }
}
