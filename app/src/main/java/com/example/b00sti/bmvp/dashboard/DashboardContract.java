package com.example.b00sti.bmvp.dashboard;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

public class DashboardContract {

    public interface View {

        void showProgressBar();

        void hideProgressBar();

        void showNoConnection();

    }

    public interface Presenter {

        void afterClick1(String s);

        void afterClick2();

        void afterClick3();

    }
}
