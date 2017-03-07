package com.example.b00sti.bmvp.dashboard;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.b00sti.bmvp.R;
import com.example.b00sti.bmvp.data.ExampleData;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-07
 */

@EViewGroup(R.layout.example_data_item_view)
public class ExampleDataItemView extends LinearLayout {

    @ViewById(R.id.idTV) TextView id;
    @ViewById(R.id.textTV) TextView textView;

    public ExampleDataItemView(Context context) {
        super(context);
    }

    public void bind(ExampleData exampleData) {
        id.setText(String.valueOf(exampleData.id));
        textView.setText(exampleData.text);
    }

}
