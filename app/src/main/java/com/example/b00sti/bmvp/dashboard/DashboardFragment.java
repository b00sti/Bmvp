package com.example.b00sti.bmvp.dashboard;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.b00sti.bmvp.R;
import com.example.b00sti.bmvp.base.BaseFragment;
import com.example.b00sti.bmvp.data.ExampleData;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends BaseFragment<DashboardPresenter> implements DashboardContract.View {
    @Bean
    DashboardPresenter presenter;

    @ViewById(R.id.progressBar) ProgressBar progressBar;
    @ViewById(R.id.inputET) EditText editText;
    @ViewById(R.id.dataRV) RecyclerView recyclerView;

    @Bean
    ExampleDataAdapter exampleDataAdapter;

    public static Fragment newInstance() {
        return new DashboardFragment_();
    }

    @Click(R.id.button1B)
    void clickedButton1() {
        presenter.saveData(editText.getText().toString());
    }

    @Click(R.id.button2B)
    void clickedButton2() {
        presenter.refreshRVwithExampleData();
    }

    @Click(R.id.button3B)
    void clickedButton3() {
        presenter.afterClick3();
    }

    @Override
    protected DashboardPresenter registerPresenter() {
        presenter.attachView(this);
        return presenter;
    }

    @AfterViews
    void init() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        exampleDataAdapter.setDataSet(new ArrayList<ExampleData>());
        recyclerView.setAdapter(exampleDataAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        presenter.refreshRVwithExampleData();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoConnection() {
        Toast.makeText(getActivity(), "No Connection", Toast.LENGTH_LONG).show();
    }

    @Override
    public void refreshExampleAdapter(List<ExampleData> exampleData) {
        exampleDataAdapter.setDataSet(exampleData);
        exampleDataAdapter.notifyDataSetChanged();
    }
}
