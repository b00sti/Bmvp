package com.example.b00sti.bmvp.dashboard;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.b00sti.bmvp.R;
import com.example.b00sti.bmvp.base.MvpFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends MvpFragment<DashboardContract.Presenter> implements DashboardContract.View {
    @Bean
    DashboardPresenter presenter;

    @ViewById(R.id.progressBar) ProgressBar progressBar;

    public static Fragment newInstance() {
        return new DashboardFragment_();
    }

    @Click(R.id.button1B)
    void clickedButton1() {
        presenter.afterClick1();
    }

    @Click(R.id.button2B)
    void clickedButton2() {
        presenter.afterClick2();
    }

    @Click(R.id.button3B)
    void clickedButton3() {
        presenter.afterClick3();
    }

    @Override
    protected DashboardContract.Presenter setPresenterView() {
        presenter.setView(this);
        return presenter;
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
}
