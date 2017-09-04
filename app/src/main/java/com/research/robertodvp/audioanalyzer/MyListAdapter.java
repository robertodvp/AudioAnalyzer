package com.research.robertodvp.audioanalyzer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertov on 16/05/2017.
 */

public class MyListAdapter extends ArrayAdapter<Person> {

    private ArrayList<Person> mPersons;

    public MyListAdapter(Context context,  ArrayList<Person> persons) {
        super(context, 0, persons);
        mPersons = persons;
    }

    @Override
    public int getCount() {
        return mPersons == null ? 0 : mPersons.size();
    }

    @Override
    public Person getItem(int position) {
        return mPersons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).mId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonListItemView personView = (PersonListItemView) convertView;
        if (personView == null) {
            personView = PersonListItemView.inflate(parent);
        }

        final Person p = getItem(position);
        personView.populate(p);

        return personView;
    }
}