package com.research.robertodvp.audioanalyzer.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.R;
import com.research.robertodvp.audioanalyzer.View.ScoreThumbView;

import java.util.ArrayList;

/**
 * Created by robertov on 20/05/2017.
 */

public class ScoreListAdapter extends ArrayAdapter<Score> {

    private ArrayList<Score> mScores;
    private Boolean trashVisibility=false;

    public ScoreListAdapter(Context context, ArrayList<Score> scores) {
        super(context, 0, scores);
        mScores = scores;
    }

    @Override
    public int getCount() {
        return mScores == null ? 0 : mScores.size();
    }

    @Override
    public Score getItem(int position) {
        return mScores.get(position);
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
        //notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ScoreThumbView scoreThumbView = (ScoreThumbView) convertView;
        if (scoreThumbView == null) {
            scoreThumbView = ScoreThumbView.inflate(parent);
        }

        final Score p = getItem(position);
        scoreThumbView.populate(p);


        //Handle buttons and add onClickListeners
        ImageView deleteTrash = (ImageView)scoreThumbView.findViewById(R.id.trash);
        //Button addBtn = (Button)view.findViewById(R.id.add_btn);

        deleteTrash.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                mScores.remove(position); //or some other task
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

        return scoreThumbView;
    }
}
