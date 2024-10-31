package com.agp.template.presentation.viewmodels.mainwindow.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> homeData = new MutableLiveData<>("Изначальный текст в Фрагменте - HOME");

    public LiveData<String> getHomeData() {
        return homeData;
    }

    public void updateData(String data) {
        homeData.setValue(data); // Логика обновления данных в HomeFragment
    }
}