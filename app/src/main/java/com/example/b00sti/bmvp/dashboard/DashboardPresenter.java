package com.example.b00sti.bmvp.dashboard;

import android.app.Activity;
import android.widget.Toast;

import com.example.b00sti.bmvp.base.BasePresenter;
import com.example.b00sti.bmvp.dashboard.interactors.GetExampleDataInteractor;
import com.example.b00sti.bmvp.dashboard.interactors.SetExampleDataInteractor;
import com.example.b00sti.bmvp.data.ExampleData;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

@EBean
public class DashboardPresenter extends BasePresenter<DashboardContract.View> implements DashboardContract.Presenter {
    private static final String TAG = "DashboardPresenter";

    @RootContext
    Activity ctx;

    @Override
    public void afterClick1(String s) {
        List<ExampleData> exampleDatas = new ArrayList<>();
        exampleDatas.add(new ExampleData(s.length(), s));
        new SetExampleDataInteractor().execute(exampleDatas);
        Toast.makeText(ctx, "Clicked 1 !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterClick2() {
        addDisposable(new GetExampleDataInteractor().execute().subscribe(new Consumer<List<ExampleData>>() {
            @Override
            public void accept(List<ExampleData> exampleDatas) throws Exception {
                StringBuilder message = new StringBuilder().append("Data: ");
                for (ExampleData data : exampleDatas) {
                    message.append(data.text);
                }
                Toast.makeText(ctx, message.toString(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public void afterClick3() {
        view.showNoConnection();
    }

    @Override
    public void onSubscribe() {
        Toast.makeText(ctx, "Subscribed: " + ctx.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUnsubscribe() {
        Toast.makeText(ctx, "Unsubscribed: " + ctx.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }
}
