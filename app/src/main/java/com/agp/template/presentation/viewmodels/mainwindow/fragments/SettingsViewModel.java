package com.agp.template.presentation.viewmodels.mainwindow.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<String> settingsData = new MutableLiveData<>();

    public LiveData<String> getSettingsData() {
        return settingsData;
    }

    public void applySettings(String data) {
        settingsData.setValue(data); // Логика для обновления настроек
    }
}
