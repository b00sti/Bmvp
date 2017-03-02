package com.example.b00sti.bmvp.dashboard.interactors;

import com.example.b00sti.bmvp.data.ExampleData;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

public class SetExampleDataInteractor {

    public void execute(List<ExampleData> data) {
        SaveAll(data);
    }

    public <E extends RealmObject> void SaveAll(final List<E> items) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (E item : items) {
                    realm.copyToRealmOrUpdate(item);
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        });
    }
}