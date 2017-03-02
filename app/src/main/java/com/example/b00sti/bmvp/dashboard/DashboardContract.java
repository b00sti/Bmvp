package com.example.b00sti.bmvp.dashboard;

import com.example.b00sti.bmvp.base.BasePresenter;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

public class DashboardContract {

    public interface View {

        void showProgressBar();

        void hideProgressBar();

        void showNoConnection();

    }

    public interface Presenter extends BasePresenter {

        void afterClick1();

        void afterClick2();

        void afterClick3();

    }
}
