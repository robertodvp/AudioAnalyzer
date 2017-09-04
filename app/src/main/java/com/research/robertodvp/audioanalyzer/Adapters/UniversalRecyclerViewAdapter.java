package com.research.robertodvp.audioanalyzer.Adapters;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.research.robertodvp.audioanalyzer.Enums.DMLSentence;
import com.research.robertodvp.audioanalyzer.View.UniversalViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by robertov on 28/08/2017.
 */

public class UniversalRecyclerViewAdapter<T> extends RecyclerView.Adapter<UniversalViewHolder> {
    public ArrayList<T> getmObjects() {
        return mObjects;
    }

    public void setmObjects(ArrayList<T> mObjects) {
        this.mObjects = mObjects;
    }

    private ArrayList<T> mObjects;
    private Boolean trashVisibility=false;
    private String mObjType;
    private String mLayoutFileName;
    private Class[] mvType = { View.class };
    private Class mVHClassDefinition;
    private Class mEntityClassDefinition;

    // Provide a suitable constructor (depends on the kind of dataset)
    public UniversalRecyclerViewAdapter(ArrayList<T> objects, String entity) {
        try {
            mObjType = entity;
            mObjects = objects;
            mLayoutFileName = mObjType.toLowerCase()+"_recyclervw_list_item";
            mEntityClassDefinition = Class.forName("com.research.robertodvp.audioanalyzer.Entities."+mObjType);
            mVHClassDefinition = Class.forName("com.research.robertodvp.audioanalyzer.View."+mObjType+"ViewHolder");
        }catch (Exception e){
            Log.e(TAG, "UniversalRecyclerViewAdapter: "+e.getMessage());
        }
    }

    public Boolean getTrashVisibility(){
        return trashVisibility;
    }

    public void setTrashVisibility(Boolean visibility){
        trashVisibility = visibility;
        //notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public UniversalViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        int id = parent.getContext().getResources().getIdentifier(mLayoutFileName, "layout", "com.research.robertodvp.audioanalyzer");
        View v = LayoutInflater.from(parent.getContext())
                .inflate(id, parent, false);

        UniversalViewHolder hld = null;

        try {
            Constructor cons = mVHClassDefinition.getConstructor(mvType);
            Object[] obj = { v };
            return (UniversalViewHolder)cons.newInstance(obj);

        } catch (Exception e){
            Log.e(TAG, "onCreateViewHolder: ", e);
        }
        return  null;
    }

    @Override
    public void onBindViewHolder(final UniversalViewHolder holder, final int position)  {
        final int pos = position;
        try {
            holder.position = pos;
            holder.populate(mEntityClassDefinition.cast(mObjects.get(pos)), trashVisibility);
            holder.mTrashImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //do something
                    try {
                        Class activityClass = holder.mV.getContext().getClass();
                        Class[] args1 = new Class[2];
                        args1[0] = DMLSentence.class;
                        args1[1] = mObjects.get(pos).getClass();
                        Object[] objects = new Object[2];
                        objects[0] = DMLSentence.DELETE;
                        objects[1] = mObjects.get(pos);
                        String x = "update"+holder.object.getClass().getSimpleName()+"Data";
                        Method method = activityClass.getDeclaredMethod("update"+holder.object.getClass().getSimpleName()+"Data", args1);
                        method.invoke(activityClass.cast(holder.mV.getContext()), objects);
                        mObjects.remove(pos); //or some other task // here data should be persisted
                        notifyDataSetChanged();
                    } catch(Exception e){
                        Log.e(TAG, "onBindViewHolder Remove pos: ", e);
                    }
                    //we can just call database manipulator and then call activity and refresh view with new data...
                }
            });
        } catch(Exception e){
            Log.e(TAG, "onBindViewHolder: "+e.getMessage() );
        }

    }


    @UiThread
    public void dataSetChanged() {
        //for(int i = 0; i<mScores.size(); i++){
        notifyItemRangeChanged(0, getItemCount());
        //notifyDataSetChanged();
        //}
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }

}
