package com.research.robertodvp.audioanalyzer.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;

import static android.content.ContentValues.TAG;

/**
 * Created by robertov on 28/08/2017.
 */

public abstract class UniversalViewHolder<T> extends RecyclerView.ViewHolder{

    public View mV;
    public ImageView mTrashImg;
    public int position;
    public Object object;

    public UniversalViewHolder(View v) {
        super(v);
        mV = v;
        mV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Toast.makeText(v.getContext(), "Touched layout", Toast.LENGTH_SHORT).show();
                Log.d("TOUCH", "Touched layout");
                Log.i("touched item", this.toString());

                try {
                    Intent intent = null;
                    Class activityClass = Class.forName("com.research.robertodvp.audioanalyzer."+object.getClass().getSimpleName()+"Activity");
                    intent = new Intent(context, activityClass);
                    intent.putExtra(object.getClass().getSimpleName(), (Serializable)object);
                    v.getContext().startActivity(intent);
                } catch (Exception e) {
                    Log.e(TAG, "onTouchEvent: ", e);
                }
            }
        });
    }

    public abstract void populate(T type, Boolean trashVisibility);

    public void setTrashImgVisibility(boolean visibility){
        if(visibility){
            //mDataTxtName.setText(StrFormat.fixedLengthString(  "Visible" , 50, "right", ' ') );
            mTrashImg.setVisibility(View.VISIBLE);
        } else {
            //mDataTxtName.setText(StrFormat.fixedLengthString(  "Invisble" , 50, "right", ' ') );
            mTrashImg.setVisibility(View.INVISIBLE);
        }
    }
    public void executeOnClick(View v, T obj)
    {

    }
}
