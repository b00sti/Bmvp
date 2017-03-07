package com.example.b00sti.bmvp.dashboard;

import android.content.Context;
import android.view.ViewGroup;

import com.example.b00sti.bmvp.base.BaseAdapter;
import com.example.b00sti.bmvp.base.ViewWrapper;
import com.example.b00sti.bmvp.data.ExampleData;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-07
 */
@EBean
public class ExampleDataAdapter extends BaseAdapter<ExampleData, ExampleDataItemView> {
    @RootContext Context context;

    @Override
    protected ExampleDataItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ExampleDataItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<ExampleDataItemView> holder, int position) {
        ExampleDataItemView itemView = holder.getView();
        ExampleData exampleData = dataSet.get(position);
        itemView.bind(exampleData);
    }
}
