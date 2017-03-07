package com.example.b00sti.bmvp.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

public class ExampleData extends RealmObject {
    public int id;
    @PrimaryKey
    public String text;

    public ExampleData() {
    }

    public ExampleData(int id, String text) {
        this.id = id;
        this.text = text;
    }
}
