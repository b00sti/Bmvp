package com.example.b00sti.bmvp.dashboard;

import com.example.b00sti.bmvp.data.ExampleData;

import java.util.List;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-03-02
 */

public class DashboardContract {

    public interface View {

        void showProgressBar();

        void hideProgressBar();

        void showNoConnection();

        void refreshExampleAdapter(List<ExampleData> exampleData);

    }

    public interface Presenter {

        void saveData(String s);

        void refreshRVwithExampleData();

        void afterClick3();

    }
}
