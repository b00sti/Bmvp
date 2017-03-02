package com.example.b00sti.bmvp.dashboard;

import android.app.Activity;
import android.widget.Toast;

import com.example.b00sti.bmvp.base.MvpPresenter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

@EBean
public class DashboardPresenter extends MvpPresenter<DashboardContract.View> implements DashboardContract.Presenter {
    private static final String TAG = "DashboardPresenter";

    @RootContext
    Activity ctx;

    @Override
    public void afterClick1() {
        Toast.makeText(ctx, "Clicked 1 !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterClick2() {
        Toast.makeText(ctx, "Clicked 1 !" + ctx.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterClick3() {
        Toast.makeText(ctx, "Clicked 1 !" + ctx.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void subscribe() {
        Toast.makeText(ctx, "Subscribed: " + ctx.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void unsubscribe() {
        Toast.makeText(ctx, "Unsubscribed: " + ctx.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }
}
